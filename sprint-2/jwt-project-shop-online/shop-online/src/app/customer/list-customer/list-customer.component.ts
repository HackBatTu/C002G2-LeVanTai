import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {Subscription} from "rxjs";
import {FormGroup} from "@angular/forms";
import {CustomerService} from "../../service/customer/customer.service";
import {CommonService} from "../../service/security/common.service";

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
              private title: Title,) {
    this.title.setTitle('Danh Sách Khách Hàng')

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
