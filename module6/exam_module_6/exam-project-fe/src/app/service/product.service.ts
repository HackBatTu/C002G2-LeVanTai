import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';
import {ProductType} from '../model/product-type';

@Injectable({
  providedIn: 'root'
})

export class ProductService {
  private URL_CONNECT_PRODUCT = 'http://localhost:8080/rest';

  constructor(private httpClient: HttpClient) {
  }

  getAllProduct(page: number) {
    return this.httpClient.get<Product[]>(this.URL_CONNECT_PRODUCT + '/product?page=' + page);
  }

  getAllProductType() {
    return this.httpClient.get<ProductType[]>(this.URL_CONNECT_PRODUCT + '/productType');
  }

  deleteProduct(id) {
    return this.httpClient.delete(this.URL_CONNECT_PRODUCT + '/delete/' + id);
  }

  createProduct(product) {
    return this.httpClient.post(this.URL_CONNECT_PRODUCT + '/create', product);
  }
}
