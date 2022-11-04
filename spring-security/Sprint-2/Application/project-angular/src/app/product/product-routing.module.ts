import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './product-list/product-list.component';
import {AdminGuard} from '../user/auth/admin.guard';
import {Page404Component} from '../error/page404/page404.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {ProductCartComponent} from './product-cart/product-cart.component';
import {ProductEditComponent} from './product-edit/product-edit.component';


const routes: Routes = [
  {
    path: 'product/list/:name',
    component: ProductListComponent
  },
  {
    path: 'product/list/:id',
    component: ProductListComponent
  },
  {
    path: 'product/list',
    component: ProductListComponent
  },
  {
    path: 'product/detail/:id',
    component: ProductDetailComponent
  },
  {
    path: 'product/create',
    component: ProductCreateComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'product/edit/:id',
    component: ProductEditComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'product/cart',
    component: ProductCartComponent
  },
  {
    path: '**',
    redirectTo: '/404'
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
export class ProductRoutingModule { }
