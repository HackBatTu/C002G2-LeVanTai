import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {YesterdayHistoryComponent} from "./yesterday-history/yesterday-history.component";
import {HistoryTransactionComponent} from "./history-transaction/history-transaction.component";
import {StatisticComponent} from "./statistic/statistic.component";
import {TopCustomerComponent} from "./top-customer/top-customer.component";


const routes: Routes = [
  {path: 'yesterday', component: YesterdayHistoryComponent},
  {path: 'transaction', component: HistoryTransactionComponent},
  {path: 'statistic', component: StatisticComponent},
  {path: 'top10-customer', component: TopCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StatisticalRoutingModule { }
