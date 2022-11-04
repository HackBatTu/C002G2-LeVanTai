import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddOrderComponent} from './add-order/add-order.component';
import {ListOrderManagementComponent} from './list-order-management/list-order-management.component';
import { ScreenOrderComponent } from './screen-order/screen-order.component';
import {UserGuard} from "../login/authguard/user.guard";
import {Error404PageComponent} from "../login/error404-page/error404-page.component";
import {StaffGuard} from "../login/authguard/staff.guard";


const routes: Routes = [
  {
    path: 'order/screen',
    component: ScreenOrderComponent,
    canActivate: [UserGuard]
  },
  {
    path: 'order/add',
    component: AddOrderComponent,
    canActivate: [UserGuard]
  },
  {
    path: 'order/list',
    component: ListOrderManagementComponent,
    canActivate: [StaffGuard]
  },
  {
    path: 'order/screen/:id',
    component: ScreenOrderComponent,
    canActivate: [UserGuard]
  },
  {
    path: '**',
    redirectTo: '/404'
  },
  {
    path: '404',
    component: Error404PageComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrderRoutingModule { }
