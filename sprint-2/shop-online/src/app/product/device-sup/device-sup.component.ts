import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {Title} from "@angular/platform-browser";
import {CookieService} from "../../login/service/cookie.service";
import {ProductService} from "../../service/product.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-device-sup',
  templateUrl: './device-sup.component.html',
  styleUrls: ['./device-sup.component.css']
})
export class DeviceSupComponent implements OnInit {

  role: string = '';
  username: string = '';
  token: string = '';

  deviceProduct: Product[] = [];

  constructor(private title: Title,
              private cookieService: CookieService,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router) {
    this.title.setTitle("Trang Sản Phẩm Thiết Bị Hỗ Trợ")
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getDevice()
  }

  getDevice(){
    this.productService.getDevice().subscribe(data =>{
      console.log(data)
      // @ts-ignore
      this.deviceProduct = data;
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
