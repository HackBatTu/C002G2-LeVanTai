import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import { CookieService } from './cookie.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private AUTHENTICATION_URL = "http://localhost:8080/authenticate";
  private header = 'Bearer '+ this.cookieService.getCookie('jwToken');

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  onLogin(username: string, password: string):Observable<any> {
    return this.httpClient.post<Observable<any>>(this.AUTHENTICATION_URL, {username: username, password: password}, {headers: new HttpHeaders({'authorization':this.header})});
  }
}
