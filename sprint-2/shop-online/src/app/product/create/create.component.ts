import {Component, Inject, OnInit} from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {AngularFireStorage} from "@angular/fire/storage";
import {ProductService} from "../../service/product.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

declare var $: any;

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  selectedImage: any;
  imgSrc: any;
  public Editor = ClassicEditor;
  productForm: FormGroup;
  product: Product;
  categories: Category[] = [];

  constructor(@Inject(AngularFireStorage) private storage: AngularFireStorage,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router,) { }

  ngOnInit(): void {
    this.productService.getAllCategory().subscribe(value => {
      this.categories = value;
    }, error => {}, () => {
      this.createForm();
    })
  }

  createForm() {
    this.productForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      dateIn: new FormControl('', [Validators.required]),
      manufacturer: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
      guaranteeTime: new FormControl('', [Validators.required]),
      discount: new FormControl(),
      specification: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
      isDeleted: new FormControl(0)
    })
  }

  onCreateProduct() {
    if (this.productForm.valid) {
      this.product = this.productForm.value;
      const nameImg = CreateComponent.getCurrentDateTime() + this.selectedImage.name;
      const fileRef = this.storage.ref(nameImg);
      this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe((url) => {
            this.product.image = url;
            this.productService.createProduct(this.product).subscribe(value => {
              this.router.navigateByUrl("/home").then();
              this.toastrService.success("Thêm mới thành công!")
            });
          });
        })
      ).subscribe();
    } else {
      this.checkErrorName();
      this.checkErrorPrice();
      this.checkErrorOrigin();
      this.checkErrorQuantity();
      this.checkErrorDateTime();
      this.checkErrorCategory();
      this.chooseFile();
      this.checkErrorGuaranteeTime();
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
      document.getElementById('img').style.display = 'block';
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
    if (this.productForm.controls.name.hasError('required')) {
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
    if (this.productForm.controls.price.hasError('required')) {
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
    if (this.productForm.controls.origin.hasError('required')) {
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
    if (this.productForm.controls.quantity.hasError('required')) {
      dataToggle.attr('data-content', 'Số lượng sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorDateTime() {
    let dataToggle = $('[data-toggle="releaseTime"]');
    if (this.productForm.controls.releaseTime.hasError('required')) {
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
    if (this.productForm.controls.category.hasError('required')) {
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
    if (this.productForm.controls.image.hasError('required')) {
      dataToggle.attr('data-content', 'Ảnh sản phẩm không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorGuaranteeTime() {
    let dataToggle = $('[data-toggle="warrantyPeriod"]');
    if (this.productForm.controls.warrantyPeriod.hasError('required')) {
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
    if (this.productForm.controls.description.hasError('required')) {
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
    if (this.productForm.controls.specifications.hasError('required')) {
      dataToggle.attr('data-content', 'Thông số kỹ thuật không được để trống.');
      setTimeout(()=>{
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

}
