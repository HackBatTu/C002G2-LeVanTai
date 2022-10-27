import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import {ForgotPasswordLoginComponent} from "./forgot-password-login/forgot-password-login.component";
import {HomeLoginComponent} from "./home-login/home-login.component";
import {LoadingComponent} from "./loading/loading.component";
import {ShareModule} from "../share/share.module";


@NgModule({
  declarations: [ForgotPasswordLoginComponent,HomeLoginComponent,LoadingComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    ShareModule
  ]
})
export class LoginModule { }
