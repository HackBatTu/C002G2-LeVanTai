import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ConsignmentComponent} from './consignment/consignment.component';
import {ConsignmentCreateComponent} from './consignment-create/consignment-create.component';
import {ConsignmentEditComponent} from './consignment-edit/consignment-edit.component';
// import {FireBaseComponent} from './fire-base/fire-base.component';


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'list'
  },
  {
    path: 'list',
    component: ConsignmentComponent
  },
  {
    path: 'create',
    component: ConsignmentCreateComponent
  },
  {
    path: 'edit/:id',
    component: ConsignmentEditComponent
  },
  // {
  //   path: 'upload-file',
  //   component: FireBaseComponent
  // },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
