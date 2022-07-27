import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home-page/home/home.component";
import {ListFacilityComponent} from "./facility/list-facility/list-facility.component";
import {UpdateFacilityComponent} from "./facility/update-facility/update-facility.component";
import {CreateFacilityComponent} from "./facility/create-facility/create-facility.component";
import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {UpdateCustomerComponent} from "./customer/update-customer/update-customer.component";
import {CreateCustomerComponent} from "./customer/create-customer/create-customer.component";
import {ListContractComponent} from "./contract/list-contract/list-contract.component";
import {CreateContractComponent} from "./contract/create-contract/create-contract.component";


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'facility',
    component: ListFacilityComponent
  },
  {
    path: 'facility-edit/:id',
    component: UpdateFacilityComponent
  },
  {
    path: 'facility-create',
    component: CreateFacilityComponent
  },
  {
    path: 'customer',
    component: ListCustomerComponent
  },
  {
    path: 'customer-edit/:id',
    component: UpdateCustomerComponent
  },
  {
    path: 'customer-create',
    component: CreateCustomerComponent
  },
  {
    path: 'contract',
    component: ListContractComponent
  },
  {
    path: 'contract-create',
    component: CreateContractComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
