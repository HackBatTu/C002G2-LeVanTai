import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {
  product: Product[] = [];
  totalPages: number;
  number: number;
  countTotalPages: number[];

  constructor(private productService: ProductService, private router: Router, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAll(0);
  }

  getAll(page: number) {
    this.productService.getAllProduct(page).subscribe(data => {
      if (data != null) {
        // @ts-ignore
        this.product = data.content;
      } else {
        this.product = [];
      }
      if (this.product.length !== 0) {
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.countTotalPages = new Array(data.totalPages);
        // @ts-ignore
        this.number = data.number;
      }
    }, error => {
    }, () => {
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.product.length; i++) {
        this.product[i].totalMoney = 0;
        // tslint:disable-next-line:prefer-for-of
        for (let j = 0; j < this.product[i].order.length; j++) {
          this.product[i].totalMoney += this.product[i].order[j].quantity;
        }
      }
    });
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(data => {
    }, error => {
    }, () => {
      // @ts-ignore
      $('#deleteModal' + id).modal('hide');
      this.ngOnInit();
      this.toastr.error('deleted', 'SOS!!!');
    });
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAll(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAll(numberPage);
    }
  }

  goItem(i: number) {
    this.getAll(i);
  }

}
