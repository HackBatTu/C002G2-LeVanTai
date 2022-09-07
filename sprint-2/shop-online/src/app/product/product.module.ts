import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProductRoutingModule} from './product-routing.module';
import {CreateComponent} from './create/create.component';
import {EditComponent} from './edit/edit.component';
import {DetailComponent} from './detail/detail.component';
import {SmartPhoneComponent} from './smart-phone/smart-phone.component';
import {TiviComponent} from './tivi/tivi.component';
import {LaptopComponent} from './laptop/laptop.component';
import {CameraComponent} from './camera/camera.component';
import {DeviceSupComponent} from './device-sup/device-sup.component';
import {ReactiveFormsModule} from "@angular/forms";
import {CKEditorModule} from "@ckeditor/ckeditor5-angular";


@NgModule({
  declarations: [CreateComponent, EditComponent, DetailComponent, SmartPhoneComponent, TiviComponent, LaptopComponent, CameraComponent, DeviceSupComponent],
  imports: [
    CommonModule,
    ProductRoutingModule,
    ReactiveFormsModule,
    CKEditorModule
  ]
  ,exports: [
    CreateComponent,
    EditComponent,
    DetailComponent,
    SmartPhoneComponent,
    TiviComponent,
    LaptopComponent,
    CameraComponent,
    DeviceSupComponent
  ]
})
export class ProductModule {
}
