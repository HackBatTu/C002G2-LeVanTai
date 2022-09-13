import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";
import {Order} from "../model/order";
const APL_URL = `${environment.apiUrl}`


@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private URL_CONNECT = APL_URL + '/rest';

  constructor(private httpClient: HttpClient) { }

  addOrder(productOrder: Order): Observable<Order> {
    return this.httpClient.post(this.URL_CONNECT + "/add/cart", productOrder);
  }

  getProductInCardByCustomer(customer: Customer): Observable<Order[]> {
    return this.httpClient.post<Order[]>(this.URL_CONNECT+ "/cart/products", customer);
  }

  minusQuantity(productOrder: Order): Observable<Order[]> {
    return this.httpClient.post<Order[]>(this.URL_CONNECT + "/cart/minus/quantity", productOrder);
  }

  plusQuantity(productOrder: Order): Observable<Order[]> {
    return this.httpClient.post<Order[]>(this.URL_CONNECT + "/cart/plus/quantity", productOrder);
  }

  deleteProductInCard(po: Order):Observable<any> {
    return this.httpClient.post(this.URL_CONNECT + "/cart/delete", po);
  }

  goPayment(customer: Customer): Observable<any> {
    return this.httpClient.post(this.URL_CONNECT + "/cart/payment", customer);
  }
}
