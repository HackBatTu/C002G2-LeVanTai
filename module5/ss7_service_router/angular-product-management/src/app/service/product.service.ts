import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {AbstractControl} from "@angular/forms";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = "http://localhost:3000/products"
  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.URL_PRODUCT);
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
