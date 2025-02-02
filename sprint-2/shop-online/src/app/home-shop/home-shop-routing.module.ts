import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ChatComponent} from "./chat/chat.component";


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {
    path: 'chat',
    component: ChatComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeShopRoutingModule {
}
