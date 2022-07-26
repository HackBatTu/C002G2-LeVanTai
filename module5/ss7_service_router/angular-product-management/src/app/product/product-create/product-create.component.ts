import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Route, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
  product: Product = {};

  constructor(private productService: ProductService,private router: Router) {
    this.productForm = new FormGroup({
      name: new FormControl('',[Validators.required,Validators.minLength(6)]),
      price: new FormControl('',[Validators.required]),
      description: new FormControl('', [Validators.required])
    })
  }

  ngOnInit(): void {
  }

  get name() {
    return this.productForm.get('name')
  }

  get price() {
    return this.productForm.get('price')
  }

  get description() {
    return this.productForm.get('description')
  }

  CreateProduct(){
    const product = this.productForm.value;
    if(this.productForm.valid){
      product.id = parseInt(product.id)
      this.productService.saveProduct(product).subscribe(data => {}, error => {}, () =>{this.router.navigate(['/product-list']);})
      this.productForm.reset();
    }

  }
}
