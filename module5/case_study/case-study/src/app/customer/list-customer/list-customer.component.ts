import {Component, OnInit} from '@angular/core';
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [];
  p: number = 1;

  constructor(private customerService: CustomerService, private router: Router) {
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(data => {
      this.customers = data
    }, error => {
    });
  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(data => {
      console.log(id)
    }, error => {
    }, () => {
      this.ngOnInit()
      this.router.navigateByUrl('/customer').then()
    })
  }
}
