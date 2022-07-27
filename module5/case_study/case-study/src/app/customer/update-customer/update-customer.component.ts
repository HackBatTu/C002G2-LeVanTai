import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../../model/customer-type";
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  customerForm: FormGroup;
  customerTypes: CustomerType[] = [];
  customer: Customer = {};

  constructor(private customerService: CustomerService, private router: Router, private activeRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.customerService.findById(parseInt(id)).subscribe(data => {
        this.customerService.getAllCustomerType().subscribe(value => {
          this.customerTypes = value;
        }, error => {
        }, () => {
            this.customer = data,
            this.customerForm = new FormGroup({
              id: new FormControl(this.customer.id, [Validators.required]),
              name: new FormControl(this.customer.name, [Validators.required]),
              customerType: new FormControl(),
              dateOfBird: new FormControl(this.customer.dateOfBird, [Validators.required]),
              gender: new FormControl(this.customer.gender, [Validators.required]),
              idCard: new FormControl(this.customer.idCard, [Validators.required]),
              phoneNumber: new FormControl(this.customer.phoneNumber, [Validators.required]),
              email: new FormControl(this.customer.email, [Validators.required]),
              address: new FormControl(this.customer.address, [Validators.required]),
            })
        })
      })
    }, error => {
      console.log(error);
    });
  }

  get name() {
    return this.customerForm.get('name')
  }

  get dateOfBird() {
    return this.customerForm.get('dateOfBird')
  }

  get gender() {
    return this.customerForm.get('gender')
  }

  get idCard() {
    return this.customerForm.get('idCard')
  }

  get phoneNumber() {
    return this.customerForm.get('phoneNumber')
  }

  get email() {
    return this.customerForm.get('email')
  }

  get address() {
    return this.customerForm.get('address')
  }
  updateCustomer() {
    const customerEdit = this.customerForm.value;
    this.customerService.updateCustomer(customerEdit).subscribe(data => {}, error => {
    }, () => {
      this.router.navigateByUrl("/customer");
    });
  }

  compareCustomerType(c1: CustomerType, c2: CustomerType):boolean {
      return c1.id === c2.id;
  }
}
