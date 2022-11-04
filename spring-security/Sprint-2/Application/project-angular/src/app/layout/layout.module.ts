import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {LayoutRoutingModule} from './layout-routing.module';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {HomeComponent} from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import {ShareModule} from '../share/share.module';
import { LoadingComponent } from './loading/loading.component';


@NgModule({
  declarations: [HeaderComponent, FooterComponent, HomeComponent, LoadingComponent],
  exports: [
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    LayoutRoutingModule,
    ShareModule
  ]
})
export class LayoutModule {
}
