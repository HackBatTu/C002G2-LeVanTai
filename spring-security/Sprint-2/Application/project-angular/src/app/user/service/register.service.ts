import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient: HttpClient) { }

  goRegister(userRegister: any): Observable<any> {
    return this.httpClient.post(API_URL + "/user/register", userRegister);
  }
}
