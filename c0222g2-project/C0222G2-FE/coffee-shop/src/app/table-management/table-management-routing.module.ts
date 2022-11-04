import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListTableManagementComponent} from './list-table-management/list-table-management.component';
import {EditTableManagementComponent} from './edit-table-management/edit-table-management.component';
import {AddTableManagementComponent} from './add-table-management/add-table-management.component';


const routes: Routes = [
  {
    path: 'table/management',
    component: ListTableManagementComponent
  },
  {
    path: 'table/edit/:id',
    component: EditTableManagementComponent
  },
  {
    path: 'table/add',
    component: AddTableManagementComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TableManagementRoutingModule { }
