import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StatisticalRoutingModule } from './statistical-routing.module';
import { YesterdayHistoryComponent } from './yesterday-history/yesterday-history.component';
import { HistoryTransactionComponent } from './history-transaction/history-transaction.component';


@NgModule({
  declarations: [YesterdayHistoryComponent, HistoryTransactionComponent],
  imports: [
    CommonModule,
    StatisticalRoutingModule
  ],
  exports: [
    YesterdayHistoryComponent,
    HistoryTransactionComponent
  ]
})
export class StatisticalModule { }
