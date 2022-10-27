import {Component, OnInit} from '@angular/core';
import { render} from "creditcardpayments/creditCardPayments";
import {Order} from "../../model/order";
import {Customer} from "../../model/customer";
import {ToastrService} from "ngx-toastr";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {CustomerService} from "../../service/customer/customer.service";
import {OrderService} from "../../service/product/order.service";
import {CommonService} from "../../service/security/common.service";
import {AuthService} from "../../service/security/auth.service";

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

  constructor(private authService: AuthService,
              private customerService: CustomerService,
              private cartService: OrderService,
              private toastrService: ToastrService,
              private commonService: CommonService,
              private router: Router) {
    this.authService.checkLogin().subscribe(value => {
      this.loginStatus = value;
      if (value) {
        this.authService.getRoles().subscribe(resp => {
          this.getCustomerByUsername(resp.username);
          this.getRole(resp);
        }, error => {
        });
      } else {

      }
    }, error => {
    });
  }

  getRole(value: any) {
    if (this.isAdmin(value.grantList)) {
      this.role = 'ROLE_ADMIN';
    } else if (this.isUser(value.grantList)) {
      this.role = 'ROLE_USER';
    }
    this.username = value.username;
  }

  isAdmin(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_ADMIN';
    });
  }

  isUser(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_USER';
    });
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
    // const target = $('#paymentsBtn');
    // target.remove('#payments');
    // target.html('<div id="payments" *ngIf="totalMoney >= 0"></div>');
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
          this.router.navigateByUrl("/history").then(() => {
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
