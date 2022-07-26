import {Component, OnInit} from '@angular/core';
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

  constructor(private productService: ProductService,
              private activeRoute: ActivatedRoute,
              private router: Router) {

  }

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

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.productService.findById(parseInt(id)).subscribe((data: Product) => {
        this.product = data;
        this.productForm = new FormGroup({
          id: new FormControl(this.product.id, [Validators.required]),
          name: new FormControl(this.product.name, [Validators.required, Validators.minLength(6)]),
          price: new FormControl(this.product.price, [Validators.required]),
          description: new FormControl(this.product.description, [Validators.required])
        })
      })
    }, error => {
      console.log(error);
    });

  }

  updateProduct() {
    const productEdit = this.productForm.value;
    this.productService.updateProduct(productEdit).subscribe(data => {}, error => {
    }, () => {
      this.router.navigateByUrl("/product-list");
    });
  }
}
