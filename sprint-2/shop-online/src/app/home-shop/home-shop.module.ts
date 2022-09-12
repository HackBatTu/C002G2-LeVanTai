import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeShopRoutingModule } from './home-shop-routing.module';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {HomeComponent} from "./home/home.component";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    HomeComponent
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    HomeShopRoutingModule,
    ReactiveFormsModule
  ]
})
export class HomeShopModule { }
