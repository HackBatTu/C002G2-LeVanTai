import {Injectable} from '@angular/core';
import {CookieService} from './cookie.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private cookieService: CookieService) {
  }

  isLogin(value: any) {
    if (this.isAdmin(value.grantList)) {
      this.cookieService.setCookie('role', 'ROLE_ADMIN', 1);
    } else {
      this.cookieService.setCookie('role', 'ROLE_USER', 1);
    }
    this.cookieService.setCookie('username', value.username, 1);
    this.cookieService.setCookie('jwToken', value.token, 1);
  }

  isAdmin(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_ADMIN';
    });
  }

  // isStaff(grantList: string[]): boolean {
  //   return grantList.some(value => {
  //     return value === 'ROLE_STAFF';
  //   });
  // }
}
