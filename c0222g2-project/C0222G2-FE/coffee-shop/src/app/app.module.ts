import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomePageComponent} from './home-page/home-page.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {EmployeeModule} from './employee/employee.module';
import {DishModule} from './dish/dish.module';
import {FeedbackModule} from './feedback/feedback.module';
import {BillModule} from './bill/bill.module';
import {LoginModule} from './login/login.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';
import {DishTypeModule} from './dish-type/dish-type.module';
import {OrderModule} from './order/order.module';
import {ShareModule} from './share/share.module';
import {AngularFireStorageModule} from '@angular/fire/storage';
import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    HeaderComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-center',
        preventDuplicates: true,
      }
    ),
    EmployeeModule,
    DishModule,
    DishTypeModule,
    FeedbackModule,
    BillModule,
    LoginModule,
    ShareModule,
    AngularFireStorageModule,
    AngularFireModule.initializeApp(environment.firebase),
    OrderModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
