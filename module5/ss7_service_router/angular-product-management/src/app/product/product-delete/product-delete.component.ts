import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  product: Product = {};

  constructor(private activatedRoute: ActivatedRoute, private productService: ProductService, private router: Router) {

  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe( (paramMap: ParamMap) => {
    const id = paramMap.get('id');
    this.productService.findById(parseInt(id)).subscribe(data => {
      this.product = data;});

  }, error => {
    console.log(error)
  })
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(data => {}, error => {} , () => { this.router.navigateByUrl("/product-list");});
  }

}
