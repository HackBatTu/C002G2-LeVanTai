import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListBillComponent} from './list-bill/list-bill.component';
import {DetailBillComponent} from './detail-bill/detail-bill.component';
import {AdminGuard} from "../login/authguard/admin.guard";


const routes: Routes = [
  {
    path: 'bill',
    component: ListBillComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'bill/detail',
    component: DetailBillComponent,
    canActivate: [AdminGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BillRoutingModule { }
