import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleComponent } from './ss4-angular/article/article.component';
import { LikeComponent } from './ss4-angular/like/like.component';
import {FormsModule} from "@angular/forms";
import { NavbarComponent } from './ss4-angular/navbar/navbar.component';
import { FooterComponent } from './ss4-angular/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticleComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
