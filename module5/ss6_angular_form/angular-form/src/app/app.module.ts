import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoComponent } from './todo/todo.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { TodoEditComponent } from './todo-edit/todo-edit.component';
import { TodoDeleteComponent } from './todo-delete/todo-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    RegisterComponent,
    LoginComponent,
    TodoEditComponent,
    TodoDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
