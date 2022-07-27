import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './home-page/home/home.component';
import {FooterComponent} from './management/footer/footer.component';
import {HeaderComponent} from './management/header/header.component';
import {ListFacilityComponent} from './facility/list-facility/list-facility.component';
import {CreateFacilityComponent} from './facility/create-facility/create-facility.component';
import {UpdateFacilityComponent} from './facility/update-facility/update-facility.component';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {CreateCustomerComponent} from './customer/create-customer/create-customer.component';
import {UpdateCustomerComponent} from './customer/update-customer/update-customer.component';
import {ListContractComponent} from './contract/list-contract/list-contract.component';
import {CreateContractComponent} from './contract/create-contract/create-contract.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    ListFacilityComponent,
    CreateFacilityComponent,
    UpdateFacilityComponent,
    ListCustomerComponent,
    CreateCustomerComponent,
    UpdateCustomerComponent,
    ListContractComponent,
    CreateContractComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
