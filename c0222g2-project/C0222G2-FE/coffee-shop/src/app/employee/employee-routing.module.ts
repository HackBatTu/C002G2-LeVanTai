import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListEmployeeComponent} from './list-employee/list-employee.component';
import {DetailEmployeeComponent} from './detail-employee/detail-employee.component';
import {AddEmployeeComponent} from './add-employee/add-employee.component';
import {EditEmployeeComponent} from './edit-employee/edit-employee.component';
import {AdminGuard} from "../login/authguard/admin.guard";


const routes: Routes = [
  {
    path: 'employee',
    component: ListEmployeeComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'employee/detail/:id',
    component: DetailEmployeeComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'employee/add',
    component: AddEmployeeComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'employee/edit/:id',
    component: EditEmployeeComponent,
    canActivate: [AdminGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule {
}
