import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {UpdateCustomerComponent} from './update-customer/update-customer.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';

const routes: Routes = [
  {
    path: 'customer',
    component: ListCustomerComponent
  },
  {
    path: 'customer-edit',
    component: UpdateCustomerComponent
  },
  {
    path: 'customer-create',
    component: CreateCustomerComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class FacilityRoutingModule { }
