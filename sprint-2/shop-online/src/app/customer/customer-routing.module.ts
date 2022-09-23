import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddInfoUserComponent} from "./add-info-user/add-info-user.component";
import {UserCustomerComponent} from "./user-customer/user-customer.component";
import {HistoryOrderComponent} from "./history-order/history-order.component";
import {ListCustomerComponent} from "./list-customer/list-customer.component";


const routes: Routes = [
  {
    path: 'add-info',component: AddInfoUserComponent
  },
  {
    path: 'info',component: UserCustomerComponent
  },
  {
    path: 'history', component: HistoryOrderComponent
  },
  {
    path: 'list-customer', component: ListCustomerComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
