import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeCreateComponent} from './employee/employee-create/employee-create.component';
import {EmployeeUpdateComponent} from './employee/employee-update/employee-update.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'employee-list'},
  {path: 'employee-create', component: EmployeeCreateComponent},
  {path: 'employee-update', component: EmployeeUpdateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
