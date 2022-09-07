import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {Title} from "@angular/platform-browser";
import {CookieService} from "../../login/service/cookie.service";
import {ProductService} from "../../service/product.service";
import {ToastrService} from "ngx-toastr";
import {LogoutService} from "../../login/service/logout.service";
import {Router} from "@angular/router";
import {CommonService} from "../../login/service/common.service";

@Component({
  selector: 'app-smart-phone',
  templateUrl: './smart-phone.component.html',
  styleUrls: ['./smart-phone.component.css']
})
export class SmartPhoneComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';

  smartPhoneProduct: Product[] = [];

  constructor(private title: Title,
              private cookieService: CookieService,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router) {
    this.title.setTitle("Trang Sản Phẩm Điện Thoại")
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getSmartPhone()
  }

  getSmartPhone(){
    this.productService.getSmartPhone().subscribe(data =>{
      console.log(data)
      // @ts-ignore
      this.smartPhoneProduct = data;
    })
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
