import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {ActivatedRoute, ParamMap, Router, RouterOutlet} from "@angular/router";
import {CookieService} from "../../login/service/cookie.service";
import {OrderService} from "../../service/order.service";
import {CustomerService} from "../../service/customer.service";
import {CommonService} from "../../login/service/common.service";
import {Order} from "../../model/order";
import {Customer} from "../../model/customer";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  product: Product;
  customer: Customer;
  role: string = '';
  username: string = '';
  token: string = '';
  public infoStatus: boolean = false;
  productOrders: Order[] = [];

  constructor(private title: Title,
              private cookieService: CookieService,
              private productService: ProductService,
              private toast: ToastrService,
              private cartService: OrderService,
              private router: Router,
              private active: ActivatedRoute,
              private orderService: OrderService,
              private customerService: CustomerService,
              private commonService: CommonService) {
    this.title.setTitle("Chi Tiết Sản Phẩm")
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getParamId()
    this.getCustomerByUsername(this.username)
    this.getProductInCardByCustomer(this.customer)
  }
  getProductInCardByCustomer(customer: Customer) {
    this.cartService.getProductInCardByCustomer(customer).subscribe((pos: Order[]) => {
      if (pos != null) {
        this.productOrders = pos;
      } else {
        this.productOrders = [];
      }
    });
  }
  getParamId() {
    this.active.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id');
      // @ts-ignore
      this.productService.findById(parseInt(id)).subscribe(data => {
        console.log(data)
        // @ts-ignore
        this.product = data;
        if (data == null) {
          this.toast.error("Không có dữ liệu hoặc bạn đang nhập quá dữ liệu hiện có", "Thông Báo")
          this.router.navigateByUrl('/home').then();
        }
      });
    });
  }
  addToCartMessage2() {
    this.router.navigateByUrl('/login').then(value => {
      this.toast.warning('Vui lòng đăng nhập tài khoản thành viên để thực hiện chức năng này!');
    });
  }
  addToCart(product: Product) {
    let order: Order = {
      customer: this.customer,
      product: product,
      quantity: 1
    };
    this.orderService.addOrder(order).subscribe((po: Order) => {
      this.toast.success('Thêm thành công sản phẩm ' + po.product.name);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'quantity') {
        this.toast.warning('Bạn đã thêm vượt quá số lượng sản phẩm!');
      }
    });
  }
  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
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
    this.toast.warning('Vui lòng đăng nhập thành viên để thực hiện chức năng này!');
  }

  updateInfoMessage() {
    this.router.navigateByUrl('/info').then(value => {
      this.toast.warning('Vui lòng cập nhật thông tin để mua hàng!');
    });
  }
}
