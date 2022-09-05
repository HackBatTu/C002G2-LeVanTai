import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BarChartComponent} from './charts-js/bar-chart/bar-chart.component';
import {DoughnutChartComponent} from './charts-js/doughnut-chart/doughnut-chart.component';
import {RadarChartComponent} from './charts-js/radar-chart/radar-chart.component';
import {PieChartComponent} from './charts-js/pie-chart/pie-chart.component';
import {HomeComponent} from './product/home/home.component';
import {CartComponent} from './cart/cart.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component: HomeComponent},
  {path: 'cart', component: CartComponent},
  {path: 'bar-chart', component: BarChartComponent},
  {path: 'doughnut-chart', component: DoughnutChartComponent},
  {path: 'radar-chart', component: RadarChartComponent},
  {path: 'pie-chart', component: PieChartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
