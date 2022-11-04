import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';
import {AngularFireStorage} from '@angular/fire/storage';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {Category} from '../model/category';
import {CategoryService} from '../service/category.service';

declare var $: any;

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit, OnDestroy {

  selectedImage: any;
  public Editor = ClassicEditor;
  productCreateForm: FormGroup;
  product: Product;
  categories: Category[] = [];
  public imgSrc: any = "../../../assets/img/loading.gif";

  constructor(@Inject(AngularFireStorage) private storage: AngularFireStorage,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router,
              private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.categoryService.getAllCategoriesList().subscribe(value => {
      this.categories = value;
    }, error => {}, () => {
      this.createForm();
    })
  }

  createForm() {
    this.productCreateForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      manufactureTime: new FormControl('', [Validators.required]),
      origin: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
      warrantyPeriod: new FormControl('', [Validators.required]),
      discountPercent: new FormControl(),
      specifications: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required])
    })
  }

  onCreateProduct() {
    if (this.productCreateForm.valid) {
      this.product = this.productCreateForm.value;
      const nameImg = ProductCreateComponent.getCurrentDateTime() + this.selectedImage.name;
      const fileRef = this.storage.ref(nameImg);
      this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe((url) => {
            this.product.image = url;
            this.productService.createNewProduct(this.product).subscribe(value => {
              this.router.navigateByUrl('/product/list').then(() => {
                this.toastrService.success("Thêm mới thành công!");
              })
            });
          });
        })
      ).subscribe();
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

  showPreview(event: any) {
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
  private static getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }

  checkErrorName() {
    let dataToggle = $('[data-toggle="name"]');
    if (this.productCreateForm.controls.name.hasError('required')) {
      dataToggle.attr('data-content', 'Tên sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorPrice() {
    let dataToggle = $('[data-toggle="price"]');
    if (this.productCreateForm.controls.price.hasError('required')) {
      dataToggle.attr('data-content', 'Giá sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorOrigin() {
    let dataToggle = $('[data-toggle="origin"]');
    if (this.productCreateForm.controls.origin.hasError('required')) {
      dataToggle.attr('data-content', 'Xuất xứ sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorQuantity() {
    let dataToggle = $('[data-toggle="quantity"]');
    if (this.productCreateForm.controls.quantity.hasError('required')) {
      dataToggle.attr('data-content', 'Số lượng sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorManufactureTime() {
    let dataToggle = $('[data-toggle="releaseTime"]');
    if (this.productCreateForm.controls.manufactureTime.hasError('required')) {
      dataToggle.attr('data-content', 'Ngày sản xuất sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorCategory() {
    let dataToggle = $('[data-toggle="category"]');
    if (this.productCreateForm.controls.category.hasError('required')) {
      dataToggle.attr('data-content', 'Vui lòng chọn danh mục.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  chooseFile() {
    $(".custom-file-input").on("change", function() {
      const fileName = $(this).val().split('\\').pop();
      $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
    let dataToggle = $('[data-toggle="image"]');
    if (this.productCreateForm.controls.image.hasError('required')) {
      dataToggle.attr('data-content', 'Ảnh sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorWarrantyPeriod() {
    let dataToggle = $('[data-toggle="warrantyPeriod"]');
    if (this.productCreateForm.controls.warrantyPeriod.hasError('required')) {
      dataToggle.attr('data-content', 'Thời hạn bảo hành không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorDescription() {
    let dataToggle = $('[data-toggle="description"]');
    if (this.productCreateForm.controls.description.hasError('required')) {
      dataToggle.attr('data-content', 'Mô tả sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorSpecifications() {
    let dataToggle = $('[data-toggle="specifications"]');
    if (this.productCreateForm.controls.specifications.hasError('required')) {
      dataToggle.attr('data-content', 'Thông số kỹ thuật không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }
  ngOnDestroy(): void {
  }
}
