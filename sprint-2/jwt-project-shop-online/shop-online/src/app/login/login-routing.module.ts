import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeLoginComponent} from "./home-login/home-login.component";
import {ForgotPasswordLoginComponent} from "./forgot-password-login/forgot-password-login.component";
import {LoadingComponent} from "./loading/loading.component";


const routes: Routes = [
  {
    path: 'login',
    component: HomeLoginComponent},
  {
    path: 'forgot/:token',
    component: ForgotPasswordLoginComponent
  },
  {
    path: 'loading',
    component: LoadingComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
