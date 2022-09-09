import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";
const APL_URL = `${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private URL_CONNECT = APL_URL + '/rest';
  constructor(private  httpClient: HttpClient) { }

  getCustomerByUserName(userName: string): Observable<Customer> {
    return this.httpClient.get(this.URL_CONNECT + '/customer/' + userName);
  }

  goRegister(userRegister: any): Observable<any> {
    return this.httpClient.post(this.URL_CONNECT + "/user/register", userRegister);
  }

  getListUser() {
    return this.httpClient.get(this.URL_CONNECT + "/user")
  }

  findByUserName(userName: string): Observable<Customer> {
    return this.httpClient.get(this.URL_CONNECT + '/customer/' + userName)
  }

  updateCustomer(customer) {
    return this.httpClient.post(this.URL_CONNECT + '/edit-customer', customer)
  }
}
