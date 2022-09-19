import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeShopRoutingModule } from './home-shop-routing.module';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {HomeComponent} from "./home/home.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ChatComponent } from './chat/chat.component';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ChatComponent
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ChatComponent
  ],
  imports: [
    CommonModule,
    HomeShopRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class HomeShopModule { }
