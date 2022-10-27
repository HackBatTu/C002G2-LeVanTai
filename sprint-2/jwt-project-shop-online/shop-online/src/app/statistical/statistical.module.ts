import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StatisticalRoutingModule } from './statistical-routing.module';
import { YesterdayHistoryComponent } from './yesterday-history/yesterday-history.component';
import { HistoryTransactionComponent } from './history-transaction/history-transaction.component';
import { StatisticComponent } from './statistic/statistic.component';
import { TopCustomerComponent } from './top-customer/top-customer.component';
import {ShareModule} from "../share/share.module";


@NgModule({
  declarations: [YesterdayHistoryComponent, HistoryTransactionComponent, StatisticComponent, TopCustomerComponent],
    imports: [
        CommonModule,
        StatisticalRoutingModule,
        ShareModule
    ],
  exports: [
    YesterdayHistoryComponent,
    HistoryTransactionComponent
  ]
})
export class StatisticalModule { }
