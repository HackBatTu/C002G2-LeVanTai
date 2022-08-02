import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";
import {Category} from "../../model/category";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  product: Product = {};
  categories: Category[] = [];
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
      this.productService.findById(parseInt(id)).subscribe(data => {
        this.product = data;
        this.productService.getAllCategories().subscribe(value => {
          this.categories = value;
        }, error => {
        }, () => {
          this.productForm = new FormGroup({
            id: new FormControl(this.product.id, [Validators.required]),
            img: new FormControl(this.product.img, [Validators.required]),
            name: new FormControl(this.product.name, [Validators.required, Validators.minLength(6)]),
            price: new FormControl(this.product.price, [Validators.required]),
            description: new FormControl(this.product.description, [Validators.required]),
            category: new FormControl(this.product.category)
          })
        })
      })
    });

  }

  updateProduct() {
    this.productService.updateProduct(this.productForm.value).subscribe(data => {
      this.product = data;
    }, error => {
    }, () => {
      this.router.navigateByUrl("/product-list").then(value => {});
    });
  }
  compareCategory(c1: Category, c2: Category):boolean {
    if ((c1 && c2) != undefined) {
      return c1.id === c2.id;
    }
  }
}
