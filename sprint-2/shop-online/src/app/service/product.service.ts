import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/category";
import {Observable} from "rxjs";
import {Product} from "../model/product";
import {environment} from "../../environments/environment";

const APL_URL = `${environment.apiUrl}`

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_CONNECT = APL_URL+ '/rest';

  constructor(private httpClient: HttpClient) { }

  getAll(page: number, searchName, searchOrigin, searchPrice) {
    let productName;
    let productOrigin;
    let productPrice;
    if (searchName == null) {
      productName = '';
    } else {
      productName = searchName;
    }
    if (searchOrigin == null) {
      productOrigin = '';
    } else {
      productOrigin = searchOrigin;
    }

    if (searchPrice == null) {
      productPrice = '';
    } else {
      productPrice = searchPrice;
    }

    return this.httpClient.get<Product[]>(this.URL_CONNECT + '/product?page=' + page + '&searchName=' + productName +
      '&searchOrigin=' + productOrigin + '&searchPrince=' + productPrice);
  }
  getAllCategory() {
    return this.httpClient.get<Category[]>(this.URL_CONNECT + '/category');
  }

  findById(id): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_CONNECT + '/findId/' + id);
  }

  deleteProduct(id) {
    return this.httpClient.delete(this.URL_CONNECT + '/delete/' + id);
  }
}
