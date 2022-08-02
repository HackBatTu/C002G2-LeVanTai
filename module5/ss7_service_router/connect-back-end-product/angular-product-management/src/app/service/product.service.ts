import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/category";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = "http://localhost:8080/rest";
  constructor(private httpClient: HttpClient) {
  }

  getAll(page: number, nameSearch): Observable<Product[]>{
    let search;
    if (nameSearch == null) {
      search = '';
    } else {
      search = nameSearch;
    }
    return this.httpClient.get<Product[]>(this.URL_PRODUCT + '/product?page=' + page +'&search=' + search );
  }

  getAllCategories(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.URL_PRODUCT + '/category');
  }
  saveProduct(product){
    return this.httpClient.post(this.URL_PRODUCT + '/create', product)
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_PRODUCT + '/findId/' + id)
  }

  updateProduct(product){
      return this.httpClient.patch(this.URL_PRODUCT + '/edit' ,product)
  }

  deleteProduct(id){
    return this.httpClient.delete(this.URL_PRODUCT + '/delete/' + id)
  }

}
