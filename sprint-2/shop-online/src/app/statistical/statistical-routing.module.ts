import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {YesterdayHistoryComponent} from "./yesterday-history/yesterday-history.component";
import {HistoryTransactionComponent} from "./history-transaction/history-transaction.component";


const routes: Routes = [
  {path: 'yesterday', component: YesterdayHistoryComponent},
  {path: 'transaction', component: HistoryTransactionComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StatisticalRoutingModule { }
