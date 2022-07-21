import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleComponent } from './ss4-angular/article/article.component';
import { LikeComponent } from './ss4-angular/like/like.component';
import { NavbarComponent } from './ss4-angular/navbar/navbar.component';
import { FooterComponent } from './ss4-angular/footer/footer.component';
import { NameCardComponent } from './ss5-angular-interraction/name-card/name-card.component';
import { ProgressBarComponent } from './ss5-angular-interraction/progress-bar/progress-bar.component';
import { RatingBarComponent } from './ss5-angular-interraction/rating-bar/rating-bar.component';
import {FormsModule} from '@angular/forms';
import { CountdownTimerComponent } from './ss5-angular-interraction/countdown-timer/countdown-timer.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticleComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent,
    NameCardComponent,
    ProgressBarComponent,
    RatingBarComponent,
    CountdownTimerComponent,
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
