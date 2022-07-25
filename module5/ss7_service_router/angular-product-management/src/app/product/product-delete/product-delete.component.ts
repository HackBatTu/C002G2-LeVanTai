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
    activatedRoute.paramMap.subscribe( (paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.product = this.productService.findById(parseInt(id))[0];
    }, error => {
      console.log(error)
    })
  }

  ngOnInit() {
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id);
    this.router.navigateByUrl("/product-list");
  }

}
