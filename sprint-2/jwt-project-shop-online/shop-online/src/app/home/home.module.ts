import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import {ChatComponent} from "./chat/chat.component";
import {HomeComponent} from "./home/home.component";
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {ShareModule} from "../share/share.module";


@NgModule({
  declarations: [ChatComponent, HomeComponent, HeaderComponent, FooterComponent],
  exports: [
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    ShareModule
  ]
})
export class HomeModule { }
