import {Component, ElementRef, Inject, OnInit} from '@angular/core';
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
  isLoading: Boolean = false;
  fileUploader: any;

  constructor(@Inject(AngularFireStorage) private storage: AngularFireStorage,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router,
              private el: ElementRef) {
  }

  ngOnInit(): void {
    this.productService.getAllCategory().subscribe(value => {
      this.categories = value;
    }, error => {
    }, () => {
      this.createForm();
    })
  }

  createForm() {
    this.productForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required]),
      manufacturer: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
      dateIn: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
      discount: new FormControl('',[Validators.required]),
      guaranteeTime: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      specification: new FormControl('', [Validators.required]),
      isDeleted: new FormControl(0)
    })
  }

  onCreateProduct() {
    this.toggleLoading();
    const product: Product = this.productForm.value;
    product.name = product.name.trim()
    product.manufacturer = product.manufacturer.trim()
    product.guaranteeTime = product.guaranteeTime.trim()
    product.discount = product.discount.trim()
    product.specification = product.specification.trim()
    product.description = product.description.trim()
    product.image = product.image.trim()
    if (this.selectedImage == null) {
      this.checkFocusFirstError()
    }
    if (this.productForm.valid) {
      this.product = this.productForm.value;
      const nameImg = CreateComponent.getCurrentDateTime() + this.selectedImage.name;
      const fileRef = this.storage.ref(nameImg);
      this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe((url) => {
            this.product.image = url;
            this.productService.createProduct(product).subscribe(value => {
              this.router.navigateByUrl("/home").then();
              this.toastrService.success("Thêm mới thành công!")
            });
          });
        })
      ).subscribe();
    } else {
      this.checkFocusFirstError()
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

  toggleLoading() {
    this.isLoading = true;
    setTimeout(() => {
      this.isLoading = false;
    }, 2600)
  }

  checkErrorName() {
    let dataToggle = $('[data-bs-toggle="name"]');
    if (this.productForm.controls.name.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorPrice() {
    let dataToggle = $('[data-bs-toggle="price"]');
    if (this.productForm.controls.price.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorOrigin() {
    let dataToggle = $('[data-bs-toggle="manufacturer"]');
    if (this.productForm.controls.manufacturer.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorQuantity() {
    let dataToggle = $('[data-bs-toggle="quantity"]');
    if (this.productForm.controls.quantity.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }
  checkErrorDiscount() {
    let dataToggle = $('[data-bs-toggle="discount"]');
    if (this.productForm.controls.discount.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorDateTime() {
    let dataToggle = $('[data-bs-toggle="dateIn"]');
    if (this.productForm.controls.dateIn.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorCategory() {
    let dataToggle = $('[data-bs-toggle="category"]');
    if (this.productForm.controls.category.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  chooseFile() {
    $(".custom-file-input").on("change", function () {
      const fileName = $(this).val().split('\\').pop();
      $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
    let dataToggle = $('[data-bs-toggle="image"]');
    if (this.productForm.controls.image.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorGuaranteeTime() {
    let dataToggle = $('[data-bs-toggle="guaranteeTime"]');
    if (this.productForm.controls.guaranteeTime.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorDescription() {
    let dataToggle = $('[data-bs-toggle="description"]');
    if (this.productForm.controls.description.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkErrorSpecifications() {
    let dataToggle = $('[data-bs-toggle="specification"]');
    if (this.productForm.controls.specification.hasError('required')) {
      dataToggle.attr('data-bs-content', 'Vui lòng nhập dữ liệu.');
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }

  checkFocusFirstError(){
    for (const key of Object.keys(this.productForm.controls)) {
      if (this.productForm.controls[key].invalid) {
        const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
        invalidControl.focus();
        this.toastrService.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
        break;
      }
    }
    this.checkErrorName();
    this.checkErrorPrice();
    this.checkErrorOrigin();
    this.checkErrorQuantity();
    this.checkErrorDateTime();
    this.checkErrorCategory();
    this.chooseFile();
    this.checkErrorDiscount();
    this.checkErrorGuaranteeTime();
    this.checkErrorDescription();
    this.checkErrorSpecifications();
    return this.toastrService.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
  }

}
