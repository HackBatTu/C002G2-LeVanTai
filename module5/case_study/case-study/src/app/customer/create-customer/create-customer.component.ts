import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {Customer} from "../../model/customer";
import {CustomerType} from "../../model/customer-type";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  customerForm: FormGroup;
  customer: Customer = {};
  customerTypes: CustomerType[] = [];


  constructor(private customerService: CustomerService, private router: Router,private toastr: ToastrService) {
  }

  showToastr() {
    this.toastr.success('Some messages','tittle',{timeOut: 500, progressBar: false})
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerType().subscribe(value => {
      this.customerTypes = value;
    }, error => {
    }, () => {
      this.customerForm = new FormGroup({
        name: new FormControl('', [Validators.required]),
        customerType: new FormControl(),
        dateOfBird: new FormControl('', [Validators.required]),
        gender: new FormControl('', [Validators.required]),
        idCard: new FormControl('', [Validators.required]),
        phoneNumber: new FormControl('', [Validators.required]),
        email: new FormControl('', [Validators.required]),
        address: new FormControl('', [Validators.required]),

      });
    })
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

  createCustomer() {
    if (this.customerForm.valid) {
      this.customerForm.value.id = parseInt(this.customerForm.value.id)
      this.customerService.saveCustomer(this.customerForm.value).subscribe(data => {
        this.showToastr()
      }, error => {
      }, () => {

        this.router.navigate(['/customer']);
      })
      this.customerForm.reset()
    }
  }


}
