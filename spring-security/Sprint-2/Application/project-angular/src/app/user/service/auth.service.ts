import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from '../../../environments/environment';
import {AppUser} from '../model/appUser';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient: HttpClient) { }

  checkLogin(): Observable<boolean> {
    return this.httpClient.post<boolean>(API_URL + "/check/login", null);
  }
  checkAdminRole(): Observable<string> {
    return this.httpClient.post<string>(API_URL + "/role/admin", null);
  }

  getRoles(): Observable<any> {
    return this.httpClient.post(API_URL + "/get/role", null)
  }

  getAllUsers(): Observable<AppUser[]> {
    return this.httpClient.get<AppUser[]>(API_URL + '/users');
  }
}
