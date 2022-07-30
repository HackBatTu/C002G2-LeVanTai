import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Consignment} from '../model/consignment';
import {Product} from '../model/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsignmentService {
  private URL_CONNECT = 'http://localhost:8080/rest';

  constructor(private httpClient: HttpClient) {
  }

  getAll() {
    return this.httpClient.get<Consignment[]>(this.URL_CONNECT + '/consignment');
  }

  getAllProduct() {
    return this.httpClient.get<Product[]>(this.URL_CONNECT + '/product');
  }

  findById(id): Observable<Consignment> {
    return this.httpClient.get<Consignment>(this.URL_CONNECT + '/findId/' + id);
  }

  deleteConsignment(id) {
    return this.httpClient.delete(this.URL_CONNECT + '/delete/' + id);
  }

  consignmentListBySearch(consignment: any): Observable<Consignment[]> {
    let searchName = consignment.searchName;
    let searchDateCheckOut = consignment.searchDateCheckOut;
    let searchStartDate = consignment.searchStartDate;
    let searchEndDate = consignment.searchEndDate;
    return this.httpClient.get<Consignment[]>(this.URL_CONNECT + '?product.name_like=' + searchName + '&dateCheckOut_like=' + searchDateCheckOut +
      '&searchStartDate=' + searchStartDate + '&searchEndDate' + searchEndDate);
  }

  createConsignment(consignment) {
    return this.httpClient.post(this.URL_CONNECT + '/create', consignment);
  }

  updateConsignment(consignment) {
    return this.httpClient.patch(this.URL_CONNECT + '/edit/' + consignment.id, consignment);
  }
}
