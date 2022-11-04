import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {DishRoutingModule} from './dish-routing.module';
import {AddDishComponent} from './add-dish/add-dish.component';
import {ListDishComponent} from './list-dish/list-dish.component';
import {RouterModule} from '@angular/router';
import {ShareModule} from '../share/share.module';
import {HttpClientModule} from "@angular/common/http";
import {AngularFireModule} from "@angular/fire";
import {environment} from "../../environments/environment";
import {ReactiveFormsModule} from "@angular/forms";
import {AngularFireDatabaseModule} from "@angular/fire/database";
import {AngularFireStorageModule} from "@angular/fire/storage";
import {EditDishComponent} from "./edit-dish/edit-dish.component";


@NgModule({
  declarations: [
    AddDishComponent,
    EditDishComponent,
    ListDishComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    DishRoutingModule,
    ShareModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireStorageModule,
    AngularFireDatabaseModule,
    ReactiveFormsModule,
  ]
})
export class DishModule {
}
