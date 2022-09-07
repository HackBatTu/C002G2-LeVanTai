import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {CookieService} from '../../login/service/cookie.service';
import {ToastrService} from 'ngx-toastr';
import {LogoutService} from '../../login/service/logout.service';
import {Router} from '@angular/router';
import {CommonService} from '../../login/service/common.service';
import {ProductService} from '../../service/product.service';
import {Product} from "../../model/product";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';
  product: Product[] = [];
  searchForm: FormGroup;
  totalPages: number;
  number: number;
  countTotalPages: number[];

  constructor(private title: Title,
              private cookieService: CookieService,
              private productService: ProductService,
              private toastrService: ToastrService,
              private logoutService: LogoutService,
              private router: Router,
              private commonService: CommonService) {
    this.title.setTitle("Trang chủ FateShop")
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getAll(0, '', '', '');
    this.searchForm = new FormGroup({
      searchName: new FormControl(),
      searchOrigin: new FormControl(),
      searchPrice: new FormControl(),
    });
  }

  getAll(page: number, searchName, searchOrigin, searchPrice) {
    this.productService.getAll(page, searchName, searchOrigin, searchPrice).subscribe((data: Product[]) => {
      console.log(data)
      if (data != null) {
        // @ts-ignore
        this.product = data.content;
      } else {
        this.product = [];
      }
      if (this.product.length !== 0) {
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.countTotalPages = new Array(data.totalPages);
        // @ts-ignore
        this.number = data.number;
      }
    });
  }

  getSearch() {
    const searchByName = this.searchForm.value.searchName;
    const searchByOrigin = this.searchForm.value.searchOrigin;
    const searchByPrice = this.searchForm.value.searchPrice;

    this.getAll(0, searchByName, searchByOrigin, searchByPrice);
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAll(numberPage, '', '', '');
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAll(numberPage, '', '', '');
    }
  }

  goItem(i: number) {
    this.getAll(i, '', '', '');
  }

  deleteProduct(id: number) {
    // @ts-ignore
    this.productService.deleteProduct(id).subscribe(value => {
    }, error => {
    }, () => {
      // @ts-ignore
      $('#staticBackdropDelete' + id).modal('hide');
      this.toastrService.error('deleted', 'SOS!!!');
      this.ngOnInit();
      this.router.navigateByUrl('/home').then();
    })
  }



}
