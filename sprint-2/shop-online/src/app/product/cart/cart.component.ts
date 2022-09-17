import {Component, OnInit} from '@angular/core';
import { render} from "creditcardpayments/creditCardPayments";
import {Order} from "../../model/order";
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {OrderService} from "../../service/order.service";
import {ToastrService} from "ngx-toastr";
import {CommonService} from "../../login/service/common.service";
import {CookieService} from "../../login/service/cookie.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

declare var $: any;

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';
  messageReceived: any;
  private subscriptionName: Subscription;
  public loginStatus: any;
  customer: Customer;
  productOrders: Order[] = [];
  totalMoney: number = 0;

  constructor(private cookieService: CookieService,
              private customerService: CustomerService,
              private cartService: OrderService,
              private toastrService: ToastrService,
              private commonService: CommonService,
              private router: Router) {
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    // subscribe to sender component messages
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
      this.role = this.readCookieService('role');
      this.username = this.readCookieService('username');
      this.token = this.readCookieService('jwToken');
      this.getCustomerByUsername(this.username)
    });
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.sendMessage();
    this.getCustomerByUsername(this.username);
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      this.customer = value;
      this.getProductInCardByCustomer(value);
    });
  }

  getProductInCardByCustomer(customer: Customer) {
    this.cartService.getProductInCardByCustomer(customer).subscribe((pos: Order[]) => {
      if (pos != null) {
        this.productOrders = pos;
        this.caculateTotalMoney(pos);
      } else {
        this.productOrders = [];
      }
    });
  }

  private caculateTotalMoney(pos: Order[]) {
    this.totalMoney = 0;
    for (let i = 0; i < pos.length; i++) {
      // @ts-ignore
      this.totalMoney += ((pos[i].product.price - (pos[i].product.price * (pos[i].product.discount / 100))) * pos[i].quantity);
    }
    if (this.totalMoney >= 0) {
      render(
        {
          id: '#payments',
          currency: 'USD',
          value: String(((this.totalMoney + 50000) / 23000).toFixed(2)),
          onApprove: (details) => {
            console.log(details);
            if (details.status == 'COMPLETED') {
              this.onPaymentSuccess();
            }
          }
        }
      );
    }
  }

  onPaymentSuccess() {
    $('#exampleModalPayment').modal('hide');
    this.router.navigateByUrl('/loading').then(() => {
      this.cartService.goPayment(this.customer).subscribe(() => {
        setTimeout(() => {
          this.router.navigateByUrl("/list-product").then(() => {
            this.toastrService.success('Thanh toán thành công!');
          })
        }, 500);
      });
      this.sendMessage();
    });
  }

  minusQuantity(productOrder: Order) {
    this.cartService.minusQuantity(productOrder).subscribe(value => {
      this.productOrders = value;
      this.caculateTotalMoney(value);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'minimum') {

      }
    });
  }

  closeModal(id: number) {
    $('#exampleModalCenter' + id).modal('hide');
  }

  plusQuantity(productOrder: Order) {
    this.cartService.plusQuantity(productOrder).subscribe(value => {
      this.productOrders = value;
      this.caculateTotalMoney(value);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'maximum') {
        this.toastrService.warning('Số lượng sản phẩm đã tối đa.');
      }
    });
  }

  maximumQuantity() {
    this.toastrService.warning('Số lượng sản phẩm đã tối đa.');
  }

  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }

  deleteProductInCart(po: Order) {
    this.cartService.deleteProductInCard(po).subscribe((value: Order[]) => {
      this.productOrders = value;
      this.caculateTotalMoney(value);
      this.toastrService.success('Xóa thành công sản phẩm ' + po.product.name + ' khỏi giỏ hàng.');
      $('#deleteMinusModal' + po.product.id).modal('hide');
      $('#exampleModalDeleteButton' + po.product.id).modal('hide');
      this.sendMessage();
    }, error => {
      if (error.error.message == 'notfound') {
        this.toastrService.warning('Không tìm thấy sản phẩm!');
      }
    });
  }
}
