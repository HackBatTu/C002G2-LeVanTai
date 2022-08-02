import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {finalize} from "rxjs/operators";
import {AngularFireStorage} from "@angular/fire/storage";
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
  product: Product = {};
  categories: Category[] = [];
  private selectedImage: any = null;

  constructor(private productService: ProductService, private router: Router, private storage: AngularFireStorage) {

  }

  ngOnInit(): void {
    this.productService.getAllCategories().subscribe(data => {
      this.categories = data;
    }, error => {
    }, () => {
      this.productForm = new FormGroup({
        img: new FormControl('',[Validators.required]),
        name: new FormControl('', [Validators.required, Validators.minLength(6)]),
        price: new FormControl('', [Validators.required]),
        description: new FormControl('', [Validators.required]),
        category: new FormControl('')
      });
    })

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

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
  }
  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ssa', 'en-US');
  }
  CreateProduct() {
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRel = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRel.getDownloadURL().subscribe((url) => {
          this.productForm.patchValue({img: url});
          this.productService.saveProduct(this.productForm.value).subscribe(() => {
            this.router.navigateByUrl('/product-list').then(r => alert("create thành công"));
          });
        });
      })
    ).subscribe();
  }


}
