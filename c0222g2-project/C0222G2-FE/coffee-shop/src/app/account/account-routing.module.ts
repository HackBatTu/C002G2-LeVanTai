import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DetailAccountComponent} from './detail-account/detail-account.component';
import {ChangePasswordAccountComponent} from './change-password-account/change-password-account.component';


const routes: Routes = [
  {
    path: 'account/detail:id',
    component: DetailAccountComponent
  },
  {
    path: 'account/change-password:id',
    component: ChangePasswordAccountComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccountRoutingModule { }
