import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from '../../../environments/environment';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor(private httpClient: HttpClient) {
  }

  goLogin(account: any): Observable<any> {
    return this.httpClient.post(API_URL + "/authenticate", account);
  }
}
