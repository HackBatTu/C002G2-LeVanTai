import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import { DetailAccountComponent } from './detail-account/detail-account.component';
import { ChangePasswordAccountComponent } from './change-password-account/change-password-account.component';
import {RouterModule} from '@angular/router';
import {ShareModule} from '../share/share.module';


@NgModule({
  declarations: [
    DetailAccountComponent,
    ChangePasswordAccountComponent],
  imports: [
    CommonModule,
    AccountRoutingModule,
    RouterModule,
    ShareModule
  ]
})
export class AccountModule { }
