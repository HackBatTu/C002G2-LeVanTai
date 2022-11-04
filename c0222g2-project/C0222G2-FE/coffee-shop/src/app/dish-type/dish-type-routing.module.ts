import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EditDishTypeComponent} from './edit-dish-type/edit-dish-type.component';
import {AddDishTypeComponent} from './add-dish-type/add-dish-type.component';
import {ListDishTypeComponent} from "./list-dish-type/list-dish-type.component";
import {AdminGuard} from "../login/authguard/admin.guard";


const routes: Routes = [
  {
    path: 'dish-type',
   component: ListDishTypeComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'dish-type/edit:id',
    component: EditDishTypeComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'dish-type/add',
    component: AddDishTypeComponent,
    canActivate: [AdminGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DishTypeRoutingModule { }
