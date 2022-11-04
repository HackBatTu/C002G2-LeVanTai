import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DetailEmployeeComponent} from './detail-employee/detail-employee.component';
import {EditEmployeeComponent} from './edit-employee/edit-employee.component';
import {ListEmployeeComponent} from './list-employee/list-employee.component';
import {AddEmployeeComponent} from './add-employee/add-employee.component';
import {RouterModule} from '@angular/router';
import {EmployeeRoutingModule} from './employee-routing.module';
import {ShareModule} from '../share/share.module';
import {ReactiveFormsModule} from "@angular/forms";
import { PhoneFormatPipe } from './phone-format.pipe';


@NgModule({
  declarations: [
    DetailEmployeeComponent,
    EditEmployeeComponent,
    ListEmployeeComponent,
    AddEmployeeComponent,
    PhoneFormatPipe],
  exports: [
    EditEmployeeComponent,
    AddEmployeeComponent,
    ListEmployeeComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    EmployeeRoutingModule,
    ShareModule,
    ReactiveFormsModule
  ]
})
export class EmployeeModule {
}
