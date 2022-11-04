import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ErrorRoutingModule } from './error-routing.module';
import { Page404Component } from './page404/page404.component';
import { Page401Component } from './page401/page401.component';
import { Page403Component } from './page403/page403.component';
import {ShareModule} from '../share/share.module';


@NgModule({
  declarations: [Page404Component, Page401Component, Page403Component],
  imports: [
    CommonModule,
    ErrorRoutingModule,
    ShareModule
  ]
})
export class ErrorModule { }
