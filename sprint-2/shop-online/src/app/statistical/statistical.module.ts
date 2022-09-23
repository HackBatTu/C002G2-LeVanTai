import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StatisticalRoutingModule } from './statistical-routing.module';
import { YesterdayHistoryComponent } from './yesterday-history/yesterday-history.component';
import { HistoryTransactionComponent } from './history-transaction/history-transaction.component';
import {ReactiveFormsModule} from "@angular/forms";
import { StatisticComponent } from './statistic/statistic.component';
import { TopCustomerComponent } from './top-customer/top-customer.component';


@NgModule({
  declarations: [YesterdayHistoryComponent, HistoryTransactionComponent, StatisticComponent, TopCustomerComponent],
    imports: [
        CommonModule,
        StatisticalRoutingModule,
        ReactiveFormsModule
    ],
  exports: [
    YesterdayHistoryComponent,
    HistoryTransactionComponent
  ]
})
export class StatisticalModule { }
