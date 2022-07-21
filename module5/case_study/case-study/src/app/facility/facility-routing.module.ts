import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListFacilityComponent} from './list-facility/list-facility.component';
import {UpdateFacilityComponent} from './update-facility/update-facility.component';
import {CreateFacilityComponent} from './create-facility/create-facility.component';

const routes: Routes = [
  {
    path: 'facility',
    component: ListFacilityComponent
  },
  {
    path: 'facility-edit',
    component: UpdateFacilityComponent
  },
  {
    path: 'facility-create',
    component: CreateFacilityComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class FacilityRoutingModule { }
