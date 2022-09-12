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
  customer: Customer;
  productOrders: Order[] = [];
  totalMoney: number = 0;

  constructor(private cookieService: CookieService,
              private customerService: CustomerService,
              private cartService: OrderService,
              private toastrService: ToastrService,
              private commonService: CommonService) {
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
      this.totalMoney += ((pos[i].product.price - (pos[i].product.price * (pos[i].product.discount / 100)))) * pos[i].quantity;
    }
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      this.customer = value;
      this.getProductInCardByCustomer(value);
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
        this.toastrService.warning("Số lượng sản phẩm đã tối đa.");
      }
    });
  }

  maximumQuantity() {
    this.toastrService.warning("Số lượng sản phẩm đã tối đa.");
  }

  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }

  deleteProductInCart(po: Order) {
    this.cartService.deleteProductInCard(po).subscribe((value: Order[]) => {
      this.productOrders = value;
      this.caculateTotalMoney(value);
      this.toastrService.success("Xóa thành công sản phẩm " + po.product.name + " khỏi giỏ hàng.");
      $('#deleteMinusModal' + po.product.id).modal('hide');
      $('#exampleModalDeleteButton' + po.product.id).modal('hide');
      this.sendMessage();
    }, error => {
      if (error.error.message == 'notfound') {
        this.toastrService.warning("Không tìm thấy sản phẩm!");
      }
    });
  }
  // constructor() {
  //   render({
  //     id: 'myPaypalButtons',
  //     currency: 'USD',
  //     value: '100.00',
  //     onApprove: (details) => {
  //       alert('Transaction Successful');
  //     },
  //     // createOrder: (details) => {
  //     //   alert('Transaction Successful');
  //     // }
  //   });
  // }
  //
  // ngOnInit(): void {
  //   this.onPaypal();
  // }
  //
  //
  // onPaypal() {
  //
  //   // @ts-ignore
  //   paypal.Buttons({
  //     onApprove: function (data, actions) {
  //       return actions.order.capture().then(function (details) {
  //         alert(details.payer.name.given_name + 'thanh toán thành công' + '!')
  //         $('#table-card').hide();
  //         $('#table-card-1').hide();
  //       })
  //     }
  //   }).render('#myPaypalButtons');
  // }
}
