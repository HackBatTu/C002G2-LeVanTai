import {Injectable} from '@angular/core';
import {CookieService} from './cookie.service';
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient,
              private cookieService: CookieService) {
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


  checkLogin(): Observable<boolean> {
    return this.httpClient.post<boolean>(API_URL + "/check/login", null);
  }
  checkAdminRole(): Observable<string> {
    return this.httpClient.post<string>(API_URL + "/role/admin", null);
  }

  getRoles(): Observable<any> {
    return this.httpClient.post(API_URL + "/get/role", null)
  }

}
