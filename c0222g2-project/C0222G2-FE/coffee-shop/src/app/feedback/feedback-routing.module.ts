import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListFeedbackComponent} from './list-feedback/list-feedback.component';
import {CreateFeedbackComponent} from "./create-feedback/create-feedback.component";
import {AdminGuard} from "../login/authguard/admin.guard";


const routes: Routes = [
  {
    path: 'feedback',
    component: ListFeedbackComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'createFeedback',
    component: CreateFeedbackComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeedbackRoutingModule {
}
