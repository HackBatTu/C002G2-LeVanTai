import {Component, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";

import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer/customer.service";

@Component({
  selector: 'app-user-customer',
  templateUrl: './user-customer.component.html',
  styleUrls: ['./user-customer.component.css']
})
export class UserCustomerComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';
  customer: Customer;

  constructor(private title: Title,
              private customerService: CustomerService
  ) {
    this.title.setTitle("Thông tin tài khoản")

  }

  ngOnInit(): void {
    this.getInfo();
  }


  getInfo() {
    this.customerService.getCustomerByUserName(this.username).subscribe((value: Customer) => {
      this.customer = value;
    })
  }


}
