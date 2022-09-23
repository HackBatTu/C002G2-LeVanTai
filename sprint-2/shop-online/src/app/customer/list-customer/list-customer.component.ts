import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {ToastrService} from "ngx-toastr";
import {CommonService} from "../../login/service/common.service";
import {Title} from "@angular/platform-browser";
import {CookieService} from "../../login/service/cookie.service";
import {Subscription} from "rxjs";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customer: Customer[] = [];
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
  constructor(private customerService: CustomerService,
              private toast: ToastrService,
              private commonService: CommonService,
              private title: Title,
              private cookieService: CookieService) {
    this.title.setTitle('Danh Sách Khách Hàng')
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
    this.getListCustomer(0);
  }

  getListCustomer(page: number){
    this.customerService.getAllCustomer(page).subscribe(data => {
      console.log(data)
      if(data != null){
        // @ts-ignore
        this.customer = data.content
      }else {
        this.customer = [];
      }
      if (this.customer.length !== 0) {
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.size = data.size;
        // @ts-ignore
        this.countTotalPages = new Array(data.totalPages);
        // @ts-ignore
        this.number = data.number;
      }
    })
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getListCustomer(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getListCustomer(numberPage);
    }
  }

  goItem(i: number) {
    this.getListCustomer(i);
  }


}
