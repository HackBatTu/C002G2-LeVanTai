import {Injectable} from '@angular/core';
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
  private URL_CONNECT = APL_URL + '/rest';

  constructor(private httpClient: HttpClient) {
  }

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

  createProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(this.URL_CONNECT + '/product/create', product)
  }

  editProduct(product: Product): Observable<Product> {
    return this.httpClient.patch<Product>(this.URL_CONNECT + '/product/edit' , product)
  }

  findById(id): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_CONNECT + '/findById/' + id);
  }

  deleteProduct(id) {
    return this.httpClient.delete(this.URL_CONNECT + '/delete/' + id);
  }

  getAllCategory() {
    return this.httpClient.get<Category[]>(this.URL_CONNECT + '/category');
  }

  getSmartPhone() {
    return this.httpClient.get(this.URL_CONNECT + '/smart-phone');
  }

  getLaptop() {
    return this.httpClient.get(this.URL_CONNECT + '/laptop');
  }

  getTivi() {
    return this.httpClient.get(this.URL_CONNECT + '/tivi');
  }

  getCamera() {
    return this.httpClient.get(this.URL_CONNECT + '/camera');
  }

  getDevice() {
    return this.httpClient.get(this.URL_CONNECT + '/device-sup');
  }


}
