import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {
  FacebookLoginProvider,
  GoogleLoginProvider,
  SocialAuthServiceConfig,
  SocialLoginModule
} from "angularx-social-login";
import {NgxPaginationModule} from "ngx-pagination";
import {HttpClientModule} from "@angular/common/http";
import {AngularFireModule} from "@angular/fire";
import {environment} from "../environments/environment";
import {ToastrModule} from "ngx-toastr";
import {ProductModule} from "./product/product.module";
import {CustomerModule} from "./customer/customer.module";
import {StatisticalModule} from "./statistical/statistical.module";
import {LoginModule} from "./login/login.module";
import {HomeModule} from "./home/home.module";
import {ChartsModule} from "ng2-charts";
import {ShareModule} from "./share/share.module";
import {NoopAnimationsModule} from "@angular/platform-browser/animations";
const googleLoginOptions = {
  scope: 'profile email',
  plugin_name: 'sample_login'
};
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    HttpClientModule,
    ChartsModule,
    SocialLoginModule,
    NgxPaginationModule,
    ProductModule,
    CustomerModule,
    StatisticalModule,
    ShareModule,
    LoginModule,
    HomeModule,
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
              '691954765888-heqsae7l1aii1ir5njk0ekakdjkg60iu.apps.googleusercontent.com',
              googleLoginOptions
            ),
          },
          {
            id: FacebookLoginProvider.PROVIDER_ID,
            provider: new FacebookLoginProvider('660649972087304'),
          },
        ],
      } as SocialAuthServiceConfig,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
