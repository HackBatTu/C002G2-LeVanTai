import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {LayoutModule} from './layout/layout.module';
import {LayoutRoutingModule} from './layout/layout-routing.module';
import {UserModule} from './user/user.module';
import {UserRoutingModule} from './user/user-routing.module';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AngularFireStorageModule} from '@angular/fire/storage';
import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {HttpRequestInterceptor} from './user/service/http.interceptor';
import {ErrorRoutingModule} from './error/error-routing.module';
import {ErrorModule} from './error/error.module';
import {ProductModule} from './product/product.module';
import {ProductRoutingModule} from './product/product-routing.module';
import {ShareModule} from './share/share.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    ShareModule,
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-center',
        preventDuplicates: true
      }
    ),
    BrowserAnimationsModule,
    AngularFireStorageModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AppRoutingModule,
    LayoutRoutingModule,
    UserRoutingModule,
    ErrorRoutingModule,
    ProductRoutingModule,
    LayoutModule,
    UserModule,
    ErrorModule,
    ProductModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
