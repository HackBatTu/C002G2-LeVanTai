import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";
import {Order} from "../model/order";
import {QuantityDto} from "../model/quantity-dto";
import {CustomerDto} from "../model/customer-dto";

const APL_URL = `${environment.apiUrl}`

@Injectable({
  providedIn: 'root'
})
export class StatisticalService {
  private URL_CONNECT = APL_URL + '/rest';

  constructor(private httpClient: HttpClient) {
  }


  getOrderByCustomer(page: number, customer: Customer): Observable<Order[]> {
    return this.httpClient.post<Order[]>(this.URL_CONNECT + "/cart/history?page=" + page, customer);
  }

  getAllOrder(page: number): Observable<Order[]> {
    return this.httpClient.get<Order[]>(this.URL_CONNECT + "/list-order?page=" + page);
  }

  getAllOrderYesterday(page: number): Observable<Order[]> {
    return this.httpClient.get<Order[]>(this.URL_CONNECT + "/yesterday?page=" + page);
  }

  getStatisticByWeek(): Observable<QuantityDto[]> {
    return this.httpClient.get<QuantityDto[]>(this.URL_CONNECT + "/statistic/by-week" );
  }

  getStatisticByMonth(): Observable<QuantityDto[]> {
    return this.httpClient.get<QuantityDto[]>(this.URL_CONNECT + "/statistic/by-month" );
  }

  getStatisticByYear(): Observable<QuantityDto[]> {
    return this.httpClient.get<QuantityDto[]>(this.URL_CONNECT + "/statistic/by-year" );
  }


  getTopTenListCustomer() {
    return this.httpClient.get<CustomerDto[]>(this.URL_CONNECT + "/customer-top" );
  }
}
