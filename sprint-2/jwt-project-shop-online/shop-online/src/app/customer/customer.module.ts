import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { AddInfoUserComponent } from './add-info-user/add-info-user.component';
import {UserCustomerComponent} from "./user-customer/user-customer.component";
import { HistoryOrderComponent } from './history-order/history-order.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import {ShareModule} from "../share/share.module";


@NgModule({
  declarations: [AddInfoUserComponent,UserCustomerComponent, HistoryOrderComponent, ListCustomerComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    ShareModule
  ],
  exports: [
    AddInfoUserComponent,
    UserCustomerComponent
  ]
})
export class CustomerModule { }
