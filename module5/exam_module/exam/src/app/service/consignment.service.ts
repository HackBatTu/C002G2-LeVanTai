// tslint:disable-next-line:import-spacing
import  {Injectable} from '@angular/core';
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

  getAll(page: number, searchName, searchDateCheckOut, searchStartDate, searchEndDate) {
    let productName;
    let dateCheckOut;
    let startDate;
    let endDate;
    if (searchName == null) {
      productName = '';
    } else {
      productName = searchName;
    }
    if (searchDateCheckOut == null) {
      dateCheckOut = '';
    } else {
      dateCheckOut = searchDateCheckOut;
    }

    if (searchStartDate == null) {
      startDate = '0001-01-01';
    } else {
      startDate = searchStartDate;
    }

    if (searchEndDate == null) {
      endDate = '8000-01-01';
    } else {
      endDate = searchEndDate;
    }
    return this.httpClient.get<Consignment[]>(this.URL_CONNECT + '/consignment?page=' + page + '&searchName=' + productName +
      '&searchDateCheckOut=' + dateCheckOut + '&searchStartDate=' + startDate + '&searchEndDate=' + endDate);
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

  createConsignment(consignment) {
    return this.httpClient.post(this.URL_CONNECT + '/create', consignment);
  }

  updateConsignment(consignment) {
    return this.httpClient.patch(this.URL_CONNECT + '/update/' + consignment.id , consignment);
  }
}
