import {Component, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {GetDishList} from './service/getDishList';
import {DishWithAmountOrder} from './model/DishWithAmountOrder';
import {DishWithTimeCreate} from './model/DishWithTimeCreate';
import {ToastrService} from 'ngx-toastr';
import {CookieService} from '../login/service/cookie.service';
import {Title} from "@angular/platform-browser";
import { NotificationService } from '../order/service/notification.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit, OnChanges {
  dishMostOrderList: DishWithAmountOrder[];
  distNewestList: DishWithTimeCreate[];
  checkData: boolean = true;
  role: string = '';
  token: string = '';
  show;

  constructor(private getDishList: GetDishList,
              private mess: ToastrService,
              private cookieService: CookieService,
              private title : Title,
              private notification: NotificationService,
              private toastr: ToastrService) {
    this.title.setTitle("Trang Chủ");
  }
  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.role = this.readCookieService('role');
    this.token = this.readCookieService('jwToken');
    this.get5DishMostOrder();
    this.get5DishNewest();
    this.notification.receiveMessage();
    this.show = this.notification.currentMessage;
    console.log(this.show);
    
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  /**
   * @date 14/08/2022
   * @author BaoTQ
   * @Function get 5 dish most order to display on homepage
   */

  get5DishMostOrder() {
    this.getDishList.get5DishMostOrder().subscribe(data => {
      this.dishMostOrderList = data;
    }, error => {
      this.checkData = false;
      this.mess.error('Máy chủ có thể đãng gặp sự cố, một số thông tin sẽ không thể hiển thị, hãy thử lại sau', 'LỖI');
    });
  }

  /**
   * @date 14/08/2022
   * @author BaoTQ
   * @Function get 5 dish newest to display on homepage
   */

  get5DishNewest() {
    this.getDishList.get5DishNewest().subscribe(data => {
      this.distNewestList = data;
      console.log(data);
    }, error => {
      this.checkData = false;
      this.mess.error('Máy chủ có thể đãng gặp sự cố, một số thông tin sẽ không thể hiển thị, hãy thử lại sau', 'LỖi');
    });
  }
}
