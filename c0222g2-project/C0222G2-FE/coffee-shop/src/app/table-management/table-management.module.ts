import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TableManagementRoutingModule } from './table-management-routing.module';
import { ListTableManagementComponent } from './list-table-management/list-table-management.component';
import { AddTableManagementComponent } from './add-table-management/add-table-management.component';
import { EditTableManagementComponent } from './edit-table-management/edit-table-management.component';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [
    ListTableManagementComponent,
    AddTableManagementComponent,
    EditTableManagementComponent],
  imports: [
    CommonModule,
    RouterModule,
    TableManagementRoutingModule,
  ]
})
export class TableManagementModule { }
