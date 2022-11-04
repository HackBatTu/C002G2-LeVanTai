import { Injectable } from '@angular/core';
import {ProductOrder} from '../../product/model/productOrder';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpClient: HttpClient) { }

  addOrder(productOrder: ProductOrder): Observable<ProductOrder> {
    return this.httpClient.post(API_URL + "/add/cart", productOrder);
  }

  getProductInCardByCustomer(customer: Customer): Observable<ProductOrder[]> {
    return this.httpClient.post<ProductOrder[]>(API_URL + "/cart/products", customer);
  }

  minusQuantity(productOrder: ProductOrder): Observable<ProductOrder[]> {
    return this.httpClient.post<ProductOrder[]>(API_URL + "/cart/minus/quantity", productOrder);
  }

  plusQuantity(productOrder: ProductOrder): Observable<ProductOrder[]> {
    return this.httpClient.post<ProductOrder[]>(API_URL + "/cart/plus/quantity", productOrder);
  }

  deleteProductInCard(po: ProductOrder):Observable<any> {
    return this.httpClient.post(API_URL + "/cart/delete", po);
  }

  goPayment(customer: Customer): Observable<any> {
    return this.httpClient.post(API_URL + "/cart/payment", customer);
  }
}
