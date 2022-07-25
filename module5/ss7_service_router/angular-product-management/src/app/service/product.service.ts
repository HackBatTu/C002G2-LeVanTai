import { Injectable } from '@angular/core';
import {Product} from "../model/product";
import {AbstractControl} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor() {
    this.products.push( {id: 1, name: 'Hòa Ngu', price: 10.0 , description: 'non'},
      {id: 2, name: 'tuyến đẹp trai', price: 20.0, description: 'gà mái mơ'},
      {id: 3, name: 'phương xọt rác', price: 30.0, description: 'trẻ trâu'},
      {id: 4, name: 'luận trà xanh', price:40.0,description: 'non'})

  }
  products: Product[] = [];

  getAll(){
    return this.products;
  }

  saveProduct(product){
    this.products.push(product)
  }

  findById(id: number) {
    return this.products.filter(product => product.id === id);
  }

  updateProduct(productEdit) {
    for (let i = 0; i < this.products.length ; i++) {
      if(this.products[i].id === productEdit.id){
        this.products[i] = productEdit;
      }
    }
  }

  deleteProduct(id) {
    this.products = this.products.filter(product => product.id !== id);
  }

}
