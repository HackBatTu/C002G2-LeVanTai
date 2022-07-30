import {Component, OnInit} from '@angular/core';
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [];
  p: number = 1;
  searchForm: FormGroup;

  constructor(private customerService: CustomerService, private router: Router, private toastr: ToastrService) {
  }
  showToastr() {
    this.toastr.success('Some messages','tittle',{timeOut: 500, progressBar: false})
  }
  ngOnInit(): void {
    this.customerService.getAll().subscribe(data => {
      this.customers = data
    }, error => {
    });
    this.searchForm = new FormGroup({
      searchName: new FormControl(""),
      searchIdCard: new FormControl("")
    });
  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(data => {
    }, error => {
    }, () => {

      this.ngOnInit()
      this.router.navigateByUrl('/customer').then(()=>{
        this.toastr.success("Some messages", "tittle");
      })
    })
  }



  getSearch() {
    this.customerService.customerListBySearch(this.searchForm.value.searchName, this.searchForm.value.searchIdCard).subscribe(data => {
      this.customers = data;
      console.log(data);
    }, error => {
    }, () => {
    })
  }
}
