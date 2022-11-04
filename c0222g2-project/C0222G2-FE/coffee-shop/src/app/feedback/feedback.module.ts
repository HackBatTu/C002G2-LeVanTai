import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FeedbackRoutingModule} from './feedback-routing.module';
import {ListFeedbackComponent} from './list-feedback/list-feedback.component';
import {RouterModule} from '@angular/router';
import {ShareModule} from '../share/share.module';
import {HttpClientModule} from "@angular/common/http";
import {CreateFeedbackComponent} from './create-feedback/create-feedback.component';


@NgModule({
  declarations: [
    ListFeedbackComponent,
    CreateFeedbackComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FeedbackRoutingModule,
    ShareModule,
    HttpClientModule
  ]
})
export class FeedbackModule {
}
