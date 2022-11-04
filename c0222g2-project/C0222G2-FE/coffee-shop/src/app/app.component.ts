import {Component} from '@angular/core';
import {CookieService} from "./login/service/cookie.service";
import {LogoutService} from "./login/service/logout.service";
import {CommonService} from "./login/service/common.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'coffee-shop';

  constructor(private cookieService: CookieService,
              private logoutService: LogoutService,
              private commonService: CommonService) {
    if (this.cookieService.getCookie('stayLogged') != 'true' && this.cookieService.getCookie('jwToken') != '') {
      this.logoutService.onLogout(this.cookieService.getCookie('jwToken')).subscribe(value => {
        this.cookieService.deleteAllCookies();
        this.cookieService.removeAllCookies();
        this.sendMessage();
      })
    }
  }

  onActivate(event) {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });
  }

  sendMessage(): void {
    // send message to subscribers via observable subject
    this.commonService.sendUpdate('Đăng Nhập thành công!');
  }
}
