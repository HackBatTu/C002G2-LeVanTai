import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AngularFireStorage} from "@angular/fire/storage";
import {ProductService} from "../../service/product.service";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Category} from "../../model/category";
import {Title} from "@angular/platform-browser";
import {formatDate} from "@angular/common";
import {Product} from "../../model/product";
import {finalize} from "rxjs/operators";

declare var $: any;

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  productForm: FormGroup;
  categories: Category[] = [];
  selectedImage: any = null;
  product: Product;
  imgSrc: any;
  isLoading: Boolean = false;
  public Editor = ClassicEditor;
  fileUploader: any;

  constructor(@Inject(AngularFireStorage) private storage: AngularFireStorage,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router,
              private el: ElementRef,
              private activate: ActivatedRoute,
              private title: Title) {
    this.title.setTitle("Sửa Thông Tin Sản Phẩm")
  }

  ngOnInit(): void {
    this.getParamId();
  }

  getParamId() {
    this.activate.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id');
      // @ts-ignore
      this.productService.findById(parseInt(id)).subscribe(data => {
        // @ts-ignore
        this.product = data;
        if (data == null) {
          this.toastrService.error("Không có dữ liệu hoặc bạn đang nhập quá dữ liệu hiện có", "Thông Báo")
          this.router.navigateByUrl('/home').then();
        }
        this.getAllCategory();
        this.editForm();
      });
    });
  }

  getAllCategory() {
    this.productService.getAllCategory().subscribe(data => {
      this.categories = data;
    })
  }
  editForm() {
    this.productForm = new FormGroup({
      id: new FormControl(this.product.id),
      name: new FormControl(this.product.name, [Validators.required]),
      price: new FormControl(this.product.price, [Validators.required]),
      image: new FormControl(this.product.image, [Validators.required]),
      manufacturer: new FormControl(this.product.manufacturer, [Validators.required]),
      quantity: new FormControl(this.product.quantity, [Validators.required]),
      dateIn: new FormControl(this.product.dateIn, [Validators.required]),
      category: new FormControl(this.product.category.id, [Validators.required]),
      discount: new FormControl(this.product.discount),
      guaranteeTime: new FormControl(this.product.guaranteeTime, [Validators.required]),
      description: new FormControl(this.product.description, [Validators.required]),
      specification: new FormControl(this.product.specification, [Validators.required]),
      isDeleted: new FormControl(this.product.isDeleted)
    })
  }

  onEditProduct() {
    this.toggleLoading()
    let product: Product = this.productForm.value;
    if (this.selectedImage == null) {
      for (const key of Object.keys(this.productForm.controls)) {
        if (this.productForm.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
          invalidControl.focus();
          this.toastrService.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
          break;
        }
      }
      if (this.productForm.valid) {
        this.productService.editProduct(product).subscribe((data) => {
          this.toastrService.success('Cập nhật thành công', 'Thông báo!!!')
          this.router.navigateByUrl('/employee').then();
        });
      } else {
        return this.toastrService.warning("Vui lòng nhập đầy đủ và đúng dữ liệu!!!", "Thông báo")
      }
    } else {
      const nameImg = EditComponent.getCurrentDateTime() + this.selectedImage.name;
      const fileRef = this.storage.ref(nameImg);
      this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe((url) => {
            product.image = url;
            if (this.productForm.valid) {
              this.productService.editProduct(product).subscribe((data) => {
                this.toastrService.success('Cập nhật thành công', 'Thông báo!!!')
                this.router.navigateByUrl('/home').then()
              });
            } else {
              for (const key of Object.keys(this.productForm.controls)) {
                if (this.productForm.controls[key].invalid) {
                  const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
                  invalidControl.focus();
                  break;
                }
              }
              return this.toastrService.warning("Vui lòng nhập đầy đủ và đúng dữ liệu!!!", "Thông báo")
            }
          });
        })
      ).subscribe();
    }
  }

  toggleLoading() {
    this.isLoading = true;
    setTimeout(() => {
      this.isLoading = false;
    }, 3000)
  }

  private static getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }
  compareCategory(c1: Category, c2: Category): boolean {
    if ((c1 && c2) != undefined) {
      return c1.id === c2.id;
    }
  }

  showPreview(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (o: any) => this.imgSrc = o.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectedImage = event.target.files[0];
      document.getElementById("image").style.display = "none"
      document.getElementById("img").style.display = "block"
    } else {
      this.imgSrc = "";
      this.selectedImage = null;
    }
  }

  checkErrorName() {
    let dataToggle = $('[data-toggle="name"]');
    if (this.productForm.controls.name.hasError('required')) {
      dataToggle.attr('data-content', 'Tên sản phẩm không được để trống.');
      setTimeout(() => {
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
      setTimeout(() => {
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
      setTimeout(() => {
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
      setTimeout(() => {
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
      setTimeout(() => {
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
    let dataToggle = $('[data-toggle="image"]');
    if (this.productForm.controls.image.hasError('required')) {
      dataToggle.attr('data-content', 'Ảnh sản phẩm không được để trống.');
      setTimeout(() => {
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
      setTimeout(() => {
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
      setTimeout(() => {
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
      setTimeout(() => {
        dataToggle.popover('hide');
      }, 2000)
      dataToggle.popover('show');
    } else {
      dataToggle.popover('hide');
    }
  }
}
