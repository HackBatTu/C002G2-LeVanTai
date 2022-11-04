import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListDishComponent} from './list-dish/list-dish.component';
import {AddDishComponent} from "./add-dish/add-dish.component";
import {EditDishComponent} from "./edit-dish/edit-dish.component";
import {AdminGuard} from "../login/authguard/admin.guard";


const routes: Routes = [
  {
    path: 'dish',
    component: ListDishComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'dish/edit/:id',
    component: EditDishComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'dish/add',
    component: AddDishComponent,
    canActivate: [AdminGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DishRoutingModule { }
