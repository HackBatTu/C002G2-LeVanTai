import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {CookieService} from './cookie.service';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {
  private LOGOUT_URL = 'http://localhost:8080/logoutSecurity';


  constructor(private httpClient: HttpClient, private cookieService: CookieService) {
  }

  onLogout(token: string): Observable<any> {
    const header = 'Bearer ' + this.cookieService.getCookie('jwToken');
    this.httpClient.get<any>(this.LOGOUT_URL + '/' + token, {headers: new HttpHeaders({'authorization': header})}).pipe();
    return of(token);
  }
}
