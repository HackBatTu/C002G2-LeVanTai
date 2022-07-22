import { Component, OnInit } from '@angular/core';
import {Customer} from "../customer";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customer: Customer[] = [];

  constructor() {
    this.customer = [
      {id:0, name: 'Lê Thị Phương',birthday: '2001-01-01',gender: 1,idCard: '123456789',phoneNumber: '0901234567',
      email: 'phuongngu@gmail.com',address: 'xóm núi',customerType: {id: 0, name: 'gold'}},
      {id:1, name: 'Lê Thị Luận',birthday: '2001-01-01',gender: 0,idCard: '123456789',phoneNumber: '0901234567',
        email: 'phuongngu@gmail.com',address: 'xóm núi',customerType: {id: 1, name: 'diamond'}},
      {id:2, name: 'Lê Thị Bình',birthday: '2001-01-01',gender: 0,idCard: '123456789',phoneNumber: '0901234567',
        email: 'phuongngu@gmail.com',address: 'xóm núi',customerType: {id: 0, name: 'gold'}},
      {id:3, name: 'Lê Thị Phúc',birthday: '2001-01-01',gender: 0,idCard: '123456789',phoneNumber: '0901234567',
        email: 'phuongngu@gmail.com',address: 'xóm núi',customerType: {id: 0, name: 'gold'}},
      {id:4, name: 'Lê Thị Hậu',birthday: '2001-01-01',gender: 0,idCard: '123456789',phoneNumber: '0901234567',
        email: 'phuongngu@gmail.com',address: 'xóm núi',customerType: {id: 0, name: 'gold'}},
    ]
  }

  ngOnInit(): void {
  }

}
