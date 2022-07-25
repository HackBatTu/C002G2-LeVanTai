import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  product: Product = {};

  constructor(private productService: ProductService, private activeRoute: ActivatedRoute, private router: Router) {
    activeRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.product = this.productService.findById(parseInt(id))[0];
    }, error => {
      console.log(error);
    });
    this.productForm = new FormGroup( {
      id: new FormControl(this.product.id),
      name: new FormControl(this.product.name),
      price: new FormControl(this.product.price),
      description: new FormControl(this.product.description)
    })
  }

  ngOnInit(): void {
  }




  updateProduct() {
    const productEdit =  this.productForm.value;
    this.productService.updateProduct(productEdit);
    this.router.navigateByUrl("/product-list");
  }
}
