import { NgModule, DEFAULT_CURRENCY_CODE } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrderRoutingModule } from './order-routing.module';
import {AddOrderComponent} from './add-order/add-order.component';
import {ListOrderManagementComponent} from './list-order-management/list-order-management.component';
import {RouterModule} from '@angular/router';
import {ShareModule} from '../share/share.module';
import { ScreenOrderComponent } from './screen-order/screen-order.component';
import { AngularFireModule } from '@angular/fire';
import { AngularFireDatabaseModule } from '@angular/fire/database';
import { environment } from 'src/environments/environment';


@NgModule({
    exports: [
        ListOrderManagementComponent
    ],
    declarations: [
      AddOrderComponent,
      ListOrderManagementComponent,
      ScreenOrderComponent
    ],
    imports: [
      CommonModule,
      RouterModule,
      OrderRoutingModule,
      ShareModule,
      AngularFireModule.initializeApp(environment.firebase),
      AngularFireDatabaseModule,

    ],
  providers: [{
    provide: DEFAULT_CURRENCY_CODE,
    useValue: 'fr' // 'de' for Germany, 'fr' for France ...
  }]
})
export class OrderModule { }
