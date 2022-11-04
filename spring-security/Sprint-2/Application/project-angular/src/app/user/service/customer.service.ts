import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';
import {AppUser} from '../model/appUser';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) {
  }

  getCustomerByUsername(username: string): Observable<Customer> {
    return this.httpClient.get<Customer>(API_URL + '/get/customer/' + username);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post(API_URL + "/checkout/customer", customer);
  }

  getAppUserFromUsername(username: string):Observable<AppUser> {
    return this.httpClient.get<AppUser>(API_URL + "/get/user/" + username);
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(API_URL + "/customer/list")
  }
}
