import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  totalPages: number;
  number: number;
  countTotalPages: number[];
  searchForm: FormGroup;

  constructor(private productService: ProductService, private router: Router) {
  }

  ngOnInit(): void {
    this.getAll(0, '');
    this.searchForm = new FormGroup(
      {nameSearch: new FormControl()}
    )
  }

  getAll(page: number, nameSearch) {
    this.productService.getAll(page, nameSearch).subscribe((data: Product[]) => {
      if (data != null) {
        // @ts-ignore
        this.products = data.content;
      } else {
        this.products = [];
      }
      if (this.products.length !== 0) {
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.countTotalPages = new Array(data.totalPages);
        // @ts-ignore
        this.number = data.number;
      }
    })
  }
  searchProduct() {
    const nameProduct = this.searchForm.value.nameSearch;
    this.getAll(0, nameProduct)
  }
  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAll(numberPage, '');
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAll(numberPage, '');
    }
  }

  goItem(i: number) {
    this.getAll(i, '');
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(data => {
    }, error => {
    }, () => {
      this.ngOnInit();
      this.router.navigateByUrl('/product-list').then(() => {
      });
    })
  }


}
