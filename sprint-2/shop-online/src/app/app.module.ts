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
import {NgxPaginationModule} from 'ngx-pagination';

// social login
import { SocialLoginModule, SocialAuthServiceConfig } from 'angularx-social-login';
import {
  GoogleLoginProvider,
  FacebookLoginProvider,
  AmazonLoginProvider,
} from 'angularx-social-login';
import {productoInterceptor} from "./interceptors/producto.interceptor";

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
    SocialLoginModule,
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
    NgxPaginationModule,
    AngularFireModule.initializeApp(environment.firebase),
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-center',
        preventDuplicates: true,
      }
    ),
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '691954765888-heqsae7l1aii1ir5njk0ekakdjkg60iu.apps.googleusercontent.com'
            ),
          },
          {
            id: FacebookLoginProvider.PROVIDER_ID,
            provider: new FacebookLoginProvider('660649972087304'),
          },
        ],
      } as SocialAuthServiceConfig,
    },
    productoInterceptor
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
