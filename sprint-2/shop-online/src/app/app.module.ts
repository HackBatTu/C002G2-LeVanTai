import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ChartsModule} from 'ng2-charts';
import {BarChartComponent} from './charts-js/bar-chart/bar-chart.component';
import {DoughnutChartComponent} from './charts-js/doughnut-chart/doughnut-chart.component';
import {RadarChartComponent} from './charts-js/radar-chart/radar-chart.component';
import {PieChartComponent} from './charts-js/pie-chart/pie-chart.component';
import {ToastrModule} from 'ngx-toastr';
import {environment} from '../environments/environment';
import {AngularFireModule} from '@angular/fire';
import {LoginModule} from './login/login.module';
import {HttpClientModule} from '@angular/common/http';
import {ProductModule} from './product/product.module';
import {CustomerModule} from "./customer/customer.module";
import {HomeShopModule} from "./home-shop/home-shop.module";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {StatisticalModule} from "./statistical/statistical.module";


@NgModule({
  declarations: [
    AppComponent,
    BarChartComponent,
    DoughnutChartComponent,
    RadarChartComponent,
    PieChartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    ChartsModule,
    HttpClientModule,
    ProductModule,
    CustomerModule,
    StatisticalModule,
    LoginModule,
    HomeShopModule,
    AngularFireModule.initializeApp(environment.firebase),
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-right',
        preventDuplicates: true,
      }
    ),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
