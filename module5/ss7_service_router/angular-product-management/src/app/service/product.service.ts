import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/category";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = "http://localhost:3000/products";
  private URL_CATEGORY: string = "http://localhost:3000/category";
  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.URL_PRODUCT);
  }

  getAllCategories(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.URL_CATEGORY);
  }
  saveProduct(product){
    return this.httpClient.post(this.URL_PRODUCT,product)
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_PRODUCT + '/' + id)
  }

  updateProduct(product){
      return this.httpClient.patch(this.URL_PRODUCT + '/' + product.id,product)
  }

  deleteProduct(id){
    return this.httpClient.delete(this.URL_PRODUCT + '/' + id)
  }


}
