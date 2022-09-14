import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Customer} from "../../model/customer";
import {Order} from "../../model/order";
import {CookieService} from "../../login/service/cookie.service";
import {CommonService} from "../../login/service/common.service";
import {CustomerService} from "../../service/customer.service";
import {ProductService} from "../../service/product.service";
import {OrderService} from "../../service/order.service";

@Component({
  selector: 'app-history-order',
  templateUrl: './history-order.component.html',
  styleUrls: ['./history-order.component.css']
})
export class HistoryOrderComponent implements OnInit {
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
              private commonService: CommonService,
              private customerService: CustomerService,
              private orderService: OrderService) {
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
    this.getCustomerByUsername(this.username)
    this.getOrderByCustomer(this.customer)
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      this.customer = value;
      console.log(value)
    });
  }

  getOrderByCustomer(customer: Customer){
    this.orderService.getOrderByCustomer(customer).subscribe((pos: Order[]) => {
      console.log(pos)
      if (pos != null) {
        // @ts-ignore
        this.productOrders = pos;
      } else {
        this.productOrders = [];
      }
    });
  }
}
