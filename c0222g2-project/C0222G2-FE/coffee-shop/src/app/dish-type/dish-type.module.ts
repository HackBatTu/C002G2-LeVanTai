import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DishTypeRoutingModule } from './dish-type-routing.module';
import { ListDishTypeComponent } from './list-dish-type/list-dish-type.component';
import { AddDishTypeComponent } from './add-dish-type/add-dish-type.component';
import { EditDishTypeComponent } from './edit-dish-type/edit-dish-type.component';
import {RouterModule} from '@angular/router';
import {ShareModule} from '../share/share.module';
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    ListDishTypeComponent,
    AddDishTypeComponent,
    EditDishTypeComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    DishTypeRoutingModule,
    ShareModule,
    HttpClientModule
  ]
})
export class DishTypeModule { }
