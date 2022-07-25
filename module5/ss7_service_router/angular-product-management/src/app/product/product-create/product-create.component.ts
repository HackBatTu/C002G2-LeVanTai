import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  constructor(private productService: ProductService,private router: Router) { }

  ngOnInit(): void {
  }
  productForm: FormGroup = new FormGroup({
    id: new FormControl('',[Validators.required]),
    name: new FormControl('',[Validators.required,Validators.minLength(6)]),
    price: new FormControl('',[Validators.required]),
    description: new FormControl('', [Validators.required])
  })

  get id() {
    return this.productForm.get('id')
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

  submit(){
    const product = this.productForm.value;
    this.productService.saveProduct(product)
    this.productForm.reset();
    this.router.navigate(['/product-list']);
  }
}
