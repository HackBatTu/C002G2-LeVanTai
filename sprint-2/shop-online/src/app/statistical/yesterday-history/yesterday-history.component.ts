import { Component, OnInit } from '@angular/core';
import {Order} from "../../model/order";
import {Subscription} from "rxjs";
import {FormGroup} from "@angular/forms";
import {OrderService} from "../../service/order.service";
import {ToastrService} from "ngx-toastr";
import {CommonService} from "../../login/service/common.service";
import {Title} from "@angular/platform-browser";
import {CookieService} from "../../login/service/cookie.service";
import {StatisticalService} from "../../service/statistical.service";

@Component({
  selector: 'app-yesterday-history',
  templateUrl: './yesterday-history.component.html',
  styleUrls: ['./yesterday-history.component.css']
})
export class YesterdayHistoryComponent implements OnInit {

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
    this.title.setTitle('Lịch Sử Giao Dịch Hôm Qua')
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
    this.getAllOrderYesterday(0)
  }

  getAllOrderYesterday(page: number){
    this.statisticalService.getAllOrderYesterday(page).subscribe(value => {
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
        this.size = value.size;
        // @ts-ignore
        this.countTotalPages = new Array(value.totalPages);
        // @ts-ignore
        this.number = value.number;
      }
    })
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAllOrderYesterday(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllOrderYesterday(numberPage);
    }
  }

  goItem(i: number) {
    this.getAllOrderYesterday(i);
  }

}
