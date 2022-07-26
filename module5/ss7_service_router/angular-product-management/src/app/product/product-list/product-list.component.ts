import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {Category} from "../../model/category";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  categories: Category[] = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.productService.getAll().subscribe(data => {
      this.products = data;
    },error => {});
  }


  getAllCategories() {
    this.productService.getAllCategories();
  }


}
