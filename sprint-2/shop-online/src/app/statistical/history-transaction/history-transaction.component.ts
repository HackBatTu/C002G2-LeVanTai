import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer";
import {Subscription} from "rxjs";
import {FormGroup} from "@angular/forms";
import {CookieService} from "../../login/service/cookie.service";
import {CommonService} from "../../login/service/common.service";
import {CustomerService} from "../../service/customer.service";
import {OrderService} from "../../service/order.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {Order} from "../../model/order";
import {StatisticalService} from "../../service/statistical.service";



@Component({
  selector: 'app-history-transaction',
  templateUrl: './history-transaction.component.html',
  styleUrls: ['./history-transaction.component.css']
})
export class HistoryTransactionComponent implements OnInit {
  order: Order[] = [];
  username: string ='';
  role: string ='';
  token: string ='';
  private subscriptionName: Subscription;
  messageReceived: any;
  searchForm: FormGroup;
  totalPages: number;
  number: number;
  countTotalPages: number[];
  size: number;
  constructor(private statisticalService: StatisticalService,
              private toast: ToastrService,
              private commonService: CommonService,
              private title: Title,
              private cookieService: CookieService) {
    this.title.setTitle('Lịch Sử Giao Dịch Web')
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    // subscribe to sender component messages
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
      this.role = this.readCookieService('role');
      this.username = this.readCookieService('username');
      this.token = this.readCookieService('jwToken');
      // this.getCustomerByUsername(this.username)
    });
  }
  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getListOrder(0)
  }

  getListOrder(page: number){
    this.statisticalService.getAllOrder(page).subscribe(value => {
      console.log(value)
      if(value != null){
        // @ts-ignore
        this.order = value.content
      }else {
        this.order = [];
      }
      if (this.order.length !== 0) {
        // @ts-ignore
        this.totalPages = value.totalPages;
        // @ts-ignore
        this.countTotalPages = new Array(value.totalPages);
        // @ts-ignore
        this.size = value.size;
        // @ts-ignore
        this.number = value.number;
      }
    })
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getListOrder(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getListOrder(numberPage);
    }
  }

  goItem(i: number) {
    this.getListOrder(i);
  }


}
