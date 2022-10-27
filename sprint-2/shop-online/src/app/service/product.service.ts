import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/category";
import {Observable} from "rxjs";
import {Product} from "../model/product";
import {environment} from "../../environments/environment";
import {Customer} from "../model/customer";
import {Order} from "../model/order";

const APL_URL = `${environment.apiUrl}`

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_CONNECT = APL_URL + '/rest';

  constructor(private httpClient: HttpClient) {
  }

  getAll(page: number, searchCategory, searchName, searchOrigin, searchStartPrice, searchEndPrice, sort) {
    let productCategory;
    let productName;
    let productOrigin;
    let productStartPrice;
    let productEndPrice;
    if (searchCategory == null) {
      productCategory = '';
    } else {
      productCategory = searchCategory;
    }
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
    if (searchStartPrice == null) {
      productStartPrice = '0';
    } else {
      productStartPrice = searchStartPrice;
    }
    if (searchEndPrice == null) {
      productEndPrice = '200000000';
    } else {
      productEndPrice = searchEndPrice;
    }
    return this.httpClient.get<Product[]>(this.URL_CONNECT + '/products?page=' + page + '&categoryId=' + productCategory + '&searchName=' + productName +
      '&searchOrigin=' + productOrigin + '&searchStartPrice=' + productStartPrice + '&searchEndPrice=' + productEndPrice + "&sort=" + sort);
  }

  getAllListProducts() {
    return this.httpClient.get(this.URL_CONNECT + '/product/list');
  }

  createProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(this.URL_CONNECT + '/product/create', product)
  }

  editProduct(product: Product): Observable<Product> {
    return this.httpClient.patch<Product>(this.URL_CONNECT + '/product/edit', product)
  }

  findById(id): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_CONNECT + '/findById/' + id);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.httpClient.delete<Product>(this.URL_CONNECT + '/delete/' + id);
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
