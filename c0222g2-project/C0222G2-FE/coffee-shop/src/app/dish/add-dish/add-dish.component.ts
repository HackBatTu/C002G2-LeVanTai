import {Component, OnInit} from '@angular/core';
import {DishType} from "../model/dish-type";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {DishService} from "../service/dish.service";
import {AngularFireStorage} from "@angular/fire/storage";
import {Router} from "@angular/router";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";
import {Dish} from "../model/dish";
import {DishTypeService} from "../service/dish-type.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-add-dish',
  templateUrl: './add-dish.component.html',
  styleUrls: ['./add-dish.component.css']
})
export class AddDishComponent implements OnInit {
  dishTypeList: DishType[] = [];
  selectedImage: any = null;
  imgSrc: any;
  formDish: FormGroup;
  dish: Dish;

  constructor(private dishService: DishService,
              private dishTypeService: DishTypeService,
              private router: Router,
              private storage: AngularFireStorage,
              private toastrService: ToastrService) {
  }

  getForm() {
    this.formDish = new FormGroup({
      id: new FormControl(),
      code: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(250), Validators.pattern("^((CF)||(T)||(NE)||(TS))(-)[0-9]{1,}$")]),
      price: new FormControl('', [Validators.required, Validators.min(5000), Validators.max(1000000), Validators.pattern("^([0-9]){1,}$")]),
      name: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(255), Validators.pattern(
        "^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
        "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*( ))*" +
        "([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
        "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*)$")]),
      image: new FormControl('', [Validators.required]),
      dishType: new FormControl('', [Validators.required]),
      isDeleted: new FormControl(),
      creationDate: new FormControl( )
    });
  }

  ngOnInit(): void {
    this.getAllDishType()
    this.getForm()

  }

  getAllDishType() {
    this.dishTypeService.getAll().subscribe(data => {
      this.dishTypeList = data;
    }, error => {

    }, () => {

    });

  }

  createDish() {

    const nameImg = this.getCurrentDateTime() + this.selectedImage;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
            let dish: Dish = this.formDish.value;
            dish.image = url;

            this.dishService.saveDish(dish).subscribe(value => {
                this.toastrService.success("Thành Công", "Thêm Mới")
                this.router.navigateByUrl("/dish")
              },
              error => {
                this.toastrService.warning(' Dữ liệu bạn nhập đang bị lỗi hoặc bạn chưa nhập đủ dữ liệu!', 'Thông báo!!!');

                const codeEr = this.formDish.value.code
                if (codeEr == dish.code) {
                  error.error.defaultMessage = 'codeExists'
                  this.formDish.controls.code.setErrors({'codeExists': true})
                }
              });
          }
        );
      })
    ).subscribe();
  }

  private getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-YYY', 'en-US');
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

  resetForm() {
    this.formDish.reset()
    this.getForm()
    document.getElementById("img").style.display = "none";
    document.getElementById("image").style.display = "none";
    const check: string = document.getElementById("opt").getAttribute("selected");
    if (check != "true") {
      document.getElementById("opt").setAttribute("selected", "true");
      document.getElementById("opt").setAttribute("disabled", "true");
    } else {
      document.getElementById("opt").removeAttribute("selected");
      document.getElementById("opt").removeAttribute("disabled");

      document.getElementById("opt").setAttribute("selected", "true");
      document.getElementById("opt").setAttribute("disabled", "true");
    }
    document.getElementById('img').style.display = 'none'
  }


}
