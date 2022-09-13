import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {Title} from "@angular/platform-browser";
import {CookieService} from "../../login/service/cookie.service";
import {ProductService} from "../../service/product.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {Order} from "../../model/order";
import {Customer} from "../../model/customer";
import {OrderService} from "../../service/order.service";
import {CustomerService} from "../../service/customer.service";
import {CommonService} from "../../login/service/common.service";

@Component({
  selector: 'app-camera',
  templateUrl: './camera.component.html',
  styleUrls: ['./camera.component.css']
})
export class CameraComponent implements OnInit {

  role: string = '';
  username: string = '';
  token: string = '';
  public infoStatus: boolean = false;
  customer: Customer;
  cameraProduct: Product[] = [];

  constructor(private title: Title,
              private cookieService: CookieService,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router,
              private orderService: OrderService,
              private customerService: CustomerService,
              private commonService: CommonService) {
    this.title.setTitle("Trang Sản Phẩm Máy Ảnh")
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getCamera()
    this.getCustomerByUsername(this.username);
  }

  getCamera(){
    this.productService.getCamera().subscribe(data =>{
      console.log(data)
      // @ts-ignore
      this.cameraProduct = data;
    })
  }
  addToCart(product: Product) {
    let order: Order = {
      customer: this.customer,
      product: product,
      quantity: 1
    };
    this.orderService.addOrder(order).subscribe((po: Order) => {
      this.toastrService.success('Thêm thành công sản phẩm ' + po.product.name);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'quantity') {
        this.toastrService.warning('Bạn đã thêm vượt quá số lượng sản phẩm!');
      }
    });
  }
  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      this.customer = value;
      if (value == null) {
        this.infoStatus = true;
      } else {
        this.infoStatus = value.appUser.isDeleted;
      }
    });
  }

  addToCartMessage() {
    this.toastrService.warning('Vui lòng đăng nhập thành viên để thực hiện chức năng này!');
  }

  updateInfoMessage() {
    this.router.navigateByUrl('/info').then(value => {
      this.toastrService.warning('Vui lòng cập nhật thông tin để mua hàng!');
    });
  }
  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
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
