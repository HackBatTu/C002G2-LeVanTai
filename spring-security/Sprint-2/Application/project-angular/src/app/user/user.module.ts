import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserRoutingModule} from './user-routing.module';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ShareModule} from '../share/share.module';
import {InfoComponent} from './info/info.component';
import {CheckoutComponent} from './checkout/checkout.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ChatComponent } from './chat/chat.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';


@NgModule({
  declarations: [LoginComponent, RegisterComponent, InfoComponent, CheckoutComponent, FeedbackComponent, ChatComponent, AdminDashboardComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    ShareModule
  ]
})
export class UserModule { }
