import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgxPaginationModule} from "ngx-pagination";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToastrModule} from "ngx-toastr";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { FooterComponent } from './management/footer/footer.component';
import { HeaderComponent } from './management/header/header.component';
import { ConsignmentComponent } from './consignment/consignment.component';
import { ConsignmentCreateComponent } from './consignment-create/consignment-create.component';
import { ConsignmentEditComponent } from './consignment-edit/consignment-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    ConsignmentComponent,
    ConsignmentCreateComponent,
    ConsignmentEditComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({ timeOut: 600,
      progressBar: true,
      progressAnimation: 'increasing',
      preventDuplicates: true
    }),
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
