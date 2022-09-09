import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddInfoUserComponent} from "./add-info-user/add-info-user.component";
import {UserCustomerComponent} from "./user-customer/user-customer.component";


const routes: Routes = [
  {
    path: 'add-info/:userName',component: AddInfoUserComponent
  },
  {
    path: 'info',component: UserCustomerComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
