import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private URL_CUSTOMER = "http:/localhost:3000/customer";
  constructor(private httpClient: HttpClient) { }


  getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.URL_CUSTOMER)
  }

  saveCustomer(customer){
    return this.httpClient.post(this.URL_CUSTOMER,customer);
  }

  findById(id): Observable<Customer> {
    return this.httpClient.get<Customer>(this.URL_CUSTOMER +'/'+id)
  }

  updateCustomer(customer){
    return this.httpClient.patch(this.URL_CUSTOMER+'/'+customer.id,customer)
  }

  deleteCustomer(id){
    return this.httpClient.delete(this.URL_CUSTOMER + '/' + id)
  }

}
