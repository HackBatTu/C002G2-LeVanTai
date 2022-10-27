import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {Page401Component} from './page401/page401.component';
import {Page403Component} from './page403/page403.component';
import {Page404Component} from './page404/page404.component';


const routes: Routes = [
  {
    path: '401',
    component: Page401Component
  },
  {
    path: '403',
    component: Page403Component
  },
  {
    path: '404',
    component: Page404Component
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ErrorRoutingModule { }
