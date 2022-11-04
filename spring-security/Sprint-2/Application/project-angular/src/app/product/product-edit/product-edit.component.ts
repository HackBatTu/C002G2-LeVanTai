import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../model/category';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {AngularFireStorage} from '@angular/fire/storage';
import {ProductService} from '../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoryService} from '../service/category.service';
import {Product} from '../model/product';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';

declare var $: any;

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  productEditForm: FormGroup;
  categories: Category[] = [];
  public Editor = ClassicEditor;
  product: Product;
  selectedImage: any;
  public imgSrc: any = "../../../assets/img/loading.gif";

  constructor(@Inject(AngularFireStorage) private storage: AngularFireStorage,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(value => {
      this.categoryService.getAllCategoriesList().subscribe(value => {
        this.categories = value;
      }, error => {
      }, () => {
        this.findProductById(value.get('id'));
      });
    });
  }

  ngOnInit(): void {
  }

  findProductById(id: string) {
    this.productService.findProductById(id).subscribe((value: Product) => {
      this.editForm(value);
      this.product = value;
    }, error => {
    }, () => {
      $('#previewImage').attr('src', this.product.image);
    });
  }

  editForm(product: Product) {
    this.productEditForm = new FormGroup({
      id: new FormControl(product.id, [Validators.required]),
      name: new FormControl(product.name, [Validators.required]),
      manufactureTime: new FormControl(product.manufactureTime, [Validators.required]),
      origin: new FormControl(product.origin, [Validators.required]),
      price: new FormControl(product.price, [Validators.required]),
      quantity: new FormControl(product.quantity, [Validators.required]),
      warrantyPeriod: new FormControl(product.warrantyPeriod, [Validators.required]),
      discountPercent: new FormControl(product.discountPercent),
      specifications: new FormControl(product.specifications, [Validators.required]),
      description: new FormControl(product.description, [Validators.required]),
      image: new FormControl(product.image, [Validators.required]),
      category: new FormControl(product.category, [Validators.required])
    });
  }

  showPreview(event: any) {
    if (event.target.files && event.target.files.length > 0) {
      const file = (event.target.files[0] as File);
      this.productEditForm.get('image').setValue(file);
    }
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (o: any) => this.imgSrc = o.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectedImage = event.target.files[0];
    } else {
      this.imgSrc = '';
      this.selectedImage = null;
    }
  }

  private getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }

  onEditProduct() {
    let productEdit: Product = this.productEditForm.value;
    if (this.productEditForm.valid) {
      if (this.selectedImage == undefined) {
        this.productService.updateProduct(productEdit).subscribe(value => {
          this.router.navigateByUrl('/product/list').then(() => {
            this.toastrService.success('Chỉnh sửa thành công!');
          });
        });
      } else {
        const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
        const fileRef = this.storage.ref(nameImg);
        this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
          finalize(() => {
            fileRef.getDownloadURL().subscribe((url) => {
              productEdit.image = url;
              this.productService.updateProduct(productEdit).subscribe(value => {
                this.router.navigateByUrl('/product/list').then(() => {
                  this.toastrService.success('Chỉnh sửa thành công!');
                });
              });
            });
          })
        ).subscribe();
      }
    } else {
      this.checkErrorName();
      this.checkErrorPrice();
      this.checkErrorOrigin();
      this.checkErrorQuantity();
      this.checkErrorManufactureTime();
      this.checkErrorCategory();
      this.chooseFile();
      this.checkErrorWarrantyPeriod();
      this.checkErrorDescription();
      this.checkErrorSpecifications();
    }
  }

  checkErrorName() {
    let dataToggle = $('[data-toggle="name"]');
    if (this.productEditForm.controls.name.hasError('required')) {
      dataToggle.attr('data-content', 'Tên sản phẩm không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorPrice() {
    let dataToggle = $('[data-toggle="price"]');
    if (this.productEditForm.controls.price.hasError('required')) {
      dataToggle.attr('data-content', 'Giá sản phẩm không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorOrigin() {
    let dataToggle = $('[data-toggle="origin"]');
    if (this.productEditForm.controls.origin.hasError('required')) {
      dataToggle.attr('data-content', 'Xuất xứ sản phẩm không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorQuantity() {
    let dataToggle = $('[data-toggle="quantity"]');
    if (this.productEditForm.controls.quantity.hasError('required')) {
      dataToggle.attr('data-content', 'Số lượng sản phẩm không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorManufactureTime() {
    let dataToggle = $('[data-toggle="releaseTime"]');
    if (this.productEditForm.controls.manufactureTime.hasError('required')) {
      dataToggle.attr('data-content', 'Ngày sản xuất sản phẩm không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorCategory() {
    let dataToggle = $('[data-toggle="category"]');
    if (this.productEditForm.controls.category.hasError('required')) {
      dataToggle.attr('data-content', 'Vui lòng chọn danh mục.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  chooseFile() {
    $('.custom-file-input').on('change', function() {
      const fileName = $(this).val().split('\\').pop();
      $(this).siblings('.custom-file-label').addClass('selected').html(fileName);
    });
    let dataToggle = $('[data-toggle="image"]');
    if (this.productEditForm.controls.image.hasError('required')) {
      dataToggle.attr('data-content', 'Ảnh sản phẩm không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorWarrantyPeriod() {
    let dataToggle = $('[data-toggle="warrantyPeriod"]');
    if (this.productEditForm.controls.warrantyPeriod.hasError('required')) {
      dataToggle.attr('data-content', 'Thời hạn bảo hành không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorDescription() {
    let dataToggle = $('[data-toggle="description"]');
    if (this.productEditForm.controls.description.hasError('required')) {
      dataToggle.attr('data-content', 'Mô tả sản phẩm không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorSpecifications() {
    let dataToggle = $('[data-toggle="specifications"]');
    if (this.productEditForm.controls.specifications.hasError('required')) {
      dataToggle.attr('data-content', 'Thông số kỹ thuật không được để trống.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000);
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  compareCategory(c1: Category, c2: Category) {
    if (c1 != null && c2 != null) {
      return c1.id == c2.id;
    }
  }
}
