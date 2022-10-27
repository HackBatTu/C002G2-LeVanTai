import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer";
import {CustomerDto} from "../../model/customer-dto";
import {StatisticalService} from "../../service/statistical/statistical.service";

@Component({
  selector: 'app-top-customer',
  templateUrl: './top-customer.component.html',
  styleUrls: ['./top-customer.component.css']
})
export class TopCustomerComponent implements OnInit {
  customer: CustomerDto[] = [];

  constructor(private statisticalService: StatisticalService) { }

  ngOnInit(): void {
    this.getListCustomer()
  }

  getListCustomer(){
    this.statisticalService.getTopTenListCustomer().subscribe( data => {
      console.log(data)
      this.customer = data;
    })
  }
}
