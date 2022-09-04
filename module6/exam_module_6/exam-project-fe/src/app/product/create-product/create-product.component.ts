import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Product} from '../../model/product';
import {ProductType} from '../../model/product-type';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  productForm: FormGroup;
  // @ts-ignore
  product: Product = {};
  productType: ProductType[] = [];

  constructor(private productService: ProductService, private router: Router, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.productService.getAllProductType().subscribe(data => {
      // @ts-ignore
      this.productType = data;
      console.log(data);
    }, error => {
    }, () => {
      this.productForm = new FormGroup({
        codeProduct: new FormControl('', [Validators.required]),
        name: new FormControl('', [Validators.required]),
        unitPrice: new FormControl('', [Validators.required]),
        dateCheckIn: new FormControl('', [Validators.required]),
        country: new FormControl(''),
        productType: new FormControl(''),
        statusDrink: new FormControl(''),
        statusFood: new FormControl(''),
        author: new FormControl(''),
        bookType: new FormControl(''),
        dateIn: new FormControl(''),
      });
    });
  }

  get codeProduct() {
    return this.productForm.get('codeProduct');
  }

  get name() {
    return this.productForm.get('name');
  }

  get unitPrice() {
    return this.productForm.get('unitPrice');
  }

  get dateCheckIn() {
    return this.productForm.get('dateCheckIn');
  }
  createProduct() {
    const product: Product = this.productForm.value;
    product.productType = {
      id: this.productForm.value.productType
    };
    if (this.productForm.valid) {
      this.productService.createProduct(product).subscribe(data => {
        this.router.navigateByUrl('/list-product').then( value => {
          this.toastr.success('Thêm mới thành công!');
        });
      }, error => {
        // tslint:disable-next-line:triple-equals
        if (error.error.codeProduct == 'CodeExists') {
          this.productForm.controls.code.setErrors({ ' CodeExists ': true});
        }
      });
    } else {
      this.toastr.warning('Vui lòng nhập dữ liệu');
    }
  }

  selectProductType(target: any) {
    switch (target.value[3]) {
      case '1':
        // @ts-ignore
        $('#drink').show();
        // @ts-ignore
        $('#food').hide();
        // @ts-ignore
        $('#book').hide();
        break;
      case '2':
        // @ts-ignore
        $('#drink').hide();
        // @ts-ignore
        $('#food').show();
        // @ts-ignore
        $('#book').hide();
        break;
      case '3':
        // @ts-ignore
        $('#drink').hide();
        // @ts-ignore
        $('#food').hide();
        // @ts-ignore
        $('#book').show();
        break;
    }
  }
}
