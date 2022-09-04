import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginRoutingModule } from './login-routing.module';
import { HomeLoginComponent } from './home-login/home-login.component';
import { ForgotPasswordLoginComponent } from './forgot-password-login/forgot-password-login.component';
import { ChangePasswordLoginComponent } from './change-password-login/change-password-login.component';
import {RouterModule} from '@angular/router';
// import {ShareModule} from '../share/share.module';
import { Error403PageComponent } from './error403-page/error403-page.component';
import { LoadingComponent } from './loading/loading.component';
import { Error404PageComponent } from './error404-page/error404-page.component';
import { Error401PageComponent } from './error401-page/error401-page.component';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    HomeLoginComponent,
    ForgotPasswordLoginComponent,
    ChangePasswordLoginComponent,
    Error403PageComponent,
    LoadingComponent,
    Error404PageComponent,
    Error401PageComponent],
  imports: [
    CommonModule,
    RouterModule,
    LoginRoutingModule,
    ReactiveFormsModule,
    // ShareModule
  ]
})
export class LoginModule { }
