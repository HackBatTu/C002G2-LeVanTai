import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

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

  getProduct(id: number) {
    return this.productService.findById(id);
  }
  updateProduct(id: number) {
    const product = this.productForm.value;
    this.productService.updateProduct(id,product)
    this.router.navigate(['/product-list'])
  }
}
