import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeLoginComponent} from './home-login/home-login.component';
import {ForgotPasswordLoginComponent} from './forgot-password-login/forgot-password-login.component';
import {ChangePasswordLoginComponent} from './change-password-login/change-password-login.component';
import {Error403PageComponent} from './error403-page/error403-page.component';
import {LoadingComponent} from './loading/loading.component';
import {LoginGuard} from './authguard/login.guard';
import {Error401PageComponent} from './error401-page/error401-page.component';
import {UserCustomerComponent} from "../customer/user-customer/user-customer.component";

const routes: Routes = [
  {
    path: 'login',
    component: HomeLoginComponent,
    canActivate: [LoginGuard]
  },
  {
    path: 'forgot/:token',
    component: ForgotPasswordLoginComponent
  },
  {
    path: 'change',
    component: ChangePasswordLoginComponent
  },
  {
    path: 'error403',
    component: Error403PageComponent
  },
  {
    path: 'loading',
    component: LoadingComponent
  },
  {
    path: 'error401',
    component: Error401PageComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule {
}
