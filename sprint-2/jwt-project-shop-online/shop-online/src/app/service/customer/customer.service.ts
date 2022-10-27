import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {Customer} from "../../model/customer";
import {AppUser} from "../../model/app-user";
import {Order} from "../../model/order";

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

  getAllCustomer(page: number): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.URL_CONNECT + "/customer-list?page=" + page )
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post(this.URL_CONNECT + "/update/customer", customer);
  }


  getProductById(id: number): Observable<Order[]> {
    return this.httpClient.get<Order[]>(this.URL_CONNECT + "/findProductById/"+ id);
  }
}
