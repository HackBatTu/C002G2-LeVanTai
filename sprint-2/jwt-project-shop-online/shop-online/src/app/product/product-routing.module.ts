import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateComponent} from './create/create.component';
import {EditComponent} from './edit/edit.component';
import {DetailComponent} from './detail/detail.component';
import {SmartPhoneComponent} from "./smart-phone/smart-phone.component";
import {LaptopComponent} from "./laptop/laptop.component";
import {TiviComponent} from "./tivi/tivi.component";
import {CameraComponent} from "./camera/camera.component";
import {DeviceSupComponent} from "./device-sup/device-sup.component";
import {CartComponent} from "./cart/cart.component";
import {AllProductComponent} from "./all-product/all-product.component";
import {HomeComponent} from "../home/home/home.component";


const routes: Routes = [
  {path: "create-product", component: CreateComponent},
  {path: "edit-product/:id", component: EditComponent},
  {path: "detail-product/:id", component: DetailComponent},
  {path: "home", component: HomeComponent},
  {path: "smart-phone", component: SmartPhoneComponent},
  {path: "laptop", component: LaptopComponent},
  {path: "tivi", component: TiviComponent},
  {path: "camera", component: CameraComponent},
  {path: "device-sup", component: DeviceSupComponent},
  {path: "cart", component: CartComponent},
  {path: "list-product", component: AllProductComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
