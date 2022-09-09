import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { AddInfoUserComponent } from './add-info-user/add-info-user.component';
import {UserCustomerComponent} from "./user-customer/user-customer.component";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [AddInfoUserComponent,UserCustomerComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    ReactiveFormsModule
  ],
  exports: [
    AddInfoUserComponent,
    UserCustomerComponent
  ]
})
export class CustomerModule { }
