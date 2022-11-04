import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {LoginGuard} from './auth/login.guard';
import {InfoComponent} from './info/info.component';
import {CheckoutComponent} from './checkout/checkout.component';
import {AuthGuard} from './auth/auth.guard';
import {ChatComponent} from './chat/chat.component';
import {AdminDashboardComponent} from './admin-dashboard/admin-dashboard.component';
import {AdminGuard} from './auth/admin.guard';


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [LoginGuard]
  },
  {
    path: 'info',
    component: InfoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'register',
    component: RegisterComponent,
    canActivate: [LoginGuard]
  },
  {
    path: 'checkout',
    component: CheckoutComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'chat',
    component: ChatComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'dashboard',
    component: AdminDashboardComponent,
    canActivate: [AdminGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
