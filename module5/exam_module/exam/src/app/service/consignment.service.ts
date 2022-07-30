import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Consignment} from '../model/consignment';
import {Product} from '../model/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsignmentService {
  private URL_CONSIGMENT = 'http://localhost:3000/consignment';
  private URL_PRODUCT = 'http://localhost:3000/product';

  constructor(private httpClient: HttpClient) {
  }

  getAll() {
    return this.httpClient.get<Consignment[]>(this.URL_CONSIGMENT);
  }

  getAllProduct() {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT);
  }

  findById(id): Observable<Consignment> {
    return this.httpClient.get<Consignment>(this.URL_CONSIGMENT + '/' + id);
  }

  deleteConsignment(id) {
    return this.httpClient.delete(this.URL_CONSIGMENT + '/' + id);
  }

  consignmentListBySearch(consignment: any): Observable<Consignment[]> {
    let searchName = consignment.searchName;
    let searchDateCheckOut = consignment.searchDateCheckOut;
    let searchStartDate = consignment.searchStartDate;
    let searchEndDate = consignment.searchEndDate;
    return this.httpClient.get<Consignment[]>(this.URL_CONSIGMENT + '?product.name_like=' + searchName + '&dateCheckOut_like=' + searchDateCheckOut +
    '&searchStartDate=' + searchStartDate + '&searchEndDate' + searchEndDate);
  }

  createConsignment(consignment) {
    return this.httpClient.post(this.URL_CONSIGMENT, consignment);
  }

  updateConsignment(consignment) {
    return this.httpClient.patch(this.URL_CONSIGMENT + '/' + consignment.id, consignment );
  }
}
