import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateComponent} from './create/create.component';
import {EditComponent} from './edit/edit.component';
import {DetailComponent} from './detail/detail.component';
import {HomeComponent} from './home/home.component';


const routes: Routes = [
  {path: "create-product", component: CreateComponent},
  {path: "edit-product", component: EditComponent},
  {path: "detail-product", component: DetailComponent},
  {path: "home", component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
