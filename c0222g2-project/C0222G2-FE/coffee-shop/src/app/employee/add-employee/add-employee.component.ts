import {Component, ElementRef, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AngularFireStorage} from "@angular/fire/storage";
import {Router} from "@angular/router";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";
import {EmployeeService} from "../service/employee.service";
import {Employee} from "../model/employee/employee";
import {AppUser} from "../model/account/app-user";
import {Position} from "../model/employee/position";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']

})

export class AddEmployeeComponent implements OnInit {
  employeeFormCreate: FormGroup;
  employee: Employee = {};
  position: Position[] = [];
  imgSrc: any;
  isLoading: Boolean = false;
  selectedImage: any = null;

  constructor(private employeeService: EmployeeService, private router: Router, private storage: AngularFireStorage,
              private toast: ToastrService, private title: Title, private el: ElementRef) {
    this.title.setTitle("Thêm mới nhân viên")
  }

  ngOnInit(): void {
    this.getAllPosition();
  }

  getEmployeeForm() {
    // @ts-ignore
    this.employeeFormCreate = new FormGroup({
        username: new FormControl('', this.checkUserName),
        image: new FormControl('', this.checkImage),
        name: new FormControl('', this.checkName),
        email: new FormControl('', this.checkMail),
        address: new FormControl('', this.checkAddress),
        gender: new FormControl(''),
        phoneNumber: new FormControl('', this.checkPhoneNumber),
        birthday: new FormControl('', this.checkBirthday),
        salary: new FormControl('', this.checkSalary),
        position: new FormControl(this.position[1])
      }
      // , {updateOn: 'submit'}
    );
  }

  getAllPosition() {
    this.employeeService.getAllPosition().subscribe(data => {
      // @ts-ignore
      this.position = data;
      this.getEmployeeForm();
    });
  }

  createEmployee() {
    this.toggleLoading();
    const employee: Employee = this.employeeFormCreate.value;
    employee.address = employee.address.trim();
    if (this.selectedImage == null) {
      for (const key of Object.keys(this.employeeFormCreate.controls)) {
        if (this.employeeFormCreate.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
          invalidControl.focus();
          this.toast.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
          break;
        }
      }
      return this.toast.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
    }
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRel = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRel.getDownloadURL().subscribe((url) => {
          this.employeeFormCreate.patchValue({image: url});
          const appUser: AppUser = {
            userName: this.employeeFormCreate.value.username
          }
          employee.appUser = appUser;
          if (this.employeeFormCreate.valid) {
            this.employeeService.saveEmployee(employee).subscribe(value => {
              this.router.navigateByUrl('/employee').then(() => {
                this.toast.success('thêm mới thành công', 'Thông báo');
              })
            }, err => {
              if (err.error.field == "appUser") {
                if (err.error.defaultMessage == "userNameExists") {
                  this.employeeFormCreate.controls.username.setErrors({'userNameExists': true});
                }
              }
              if (err.error.field == "phoneNumber") {
                if (err.error.defaultMessage == "phoneNumberExists") {
                  this.employeeFormCreate.controls.phoneNumber.setErrors({'phoneNumberExists': true});
                }
              }
            })
          } else {
            for (const key of Object.keys(this.employeeFormCreate.controls)) {
              if (this.employeeFormCreate.controls[key].invalid) {
                const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
                invalidControl.focus();
                break;
              }
            }
            return this.toast.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!', 'Thông báo!!!');

          }
        })
      })
    ).subscribe();
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

  toggleLoading() {
    this.isLoading = true;
    setTimeout(() => {
      this.isLoading = false;
    }, 2600)
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ss', 'en-US');
  }

  checkBirthday(birthday: AbstractControl) {
    const value = birthday.value
    if (value === '') {
      return null;
    }
    const today = new Date();
    const birthDate = new Date(birthday.value);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    const curDate = formatDate(new Date(), 'yyyy-MM-dd', 'en-US');
    if (value >= curDate) {
      return {'checkDate': true}
    } else if (age < 16) {
      return {'age16': true}
    } else if (value.match("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])" +
      "|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$") == null) {
      return {'pattern': true}
    }
  }

  checkUserName(userName: AbstractControl) {
    const value = userName.value
    if (value == '') {
      return {'required': true};
    } else if (value.match("^[A-Za-z][a-zA-Z0-9]{1,}$") == null) {
      return {'pattern': true}
    } else if (value.length <= 6) {
      return {'minlength': true}
    } else if (value.length >= 30) {
      return {'maxlength': true}
    }
  }

  checkAddress(addressName: AbstractControl) {
    const value = addressName.value
    if (value == '') {
      return {'required': true};
    } else if (value.length <= 6) {
      return {'minlength': true}
    } else if (value.length >= 255) {
      return {'maxlength': true}
    }
  }

  checkImage(image: AbstractControl) {
    const value = image.value
    if (value == '') {
      return {'required': true};
    } else if (value.length >= 255) {
      return {'maxlength': true}
    }
  }

  checkPhoneNumber(phoneNumber: AbstractControl) {
    const value = phoneNumber.value
    if (value == '') {
      return {'required': true};
    } else if (value.match("^(03|08|09|\\(84\\)\\+9)\\d\\d{7}$")== null) {
      return {'pattern': true}
    }
  }

  checkName(name: AbstractControl) {
    const value = name.value
    if (value == '') {
      return {'required': true};
    } else if (value.match("^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
      "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*( )){0,14}" +
      "([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
      "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*)$") == null) {
      return {'pattern': true}
    } else if (value.length <= 6) {
      return {'minlength': true}
    } else if (value.length >= 30) {
      return {'maxlength': true}
    }
  }

  checkMail(mail: AbstractControl) {
    const value = mail.value
    if (value == '') {
      return {'required': true};
    } else if (value.match("^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$") == null) {
      return {'email': true}
    } else if (value.length <= 6) {
      return {'minlength': true}
    } else if (value.length >= 30) {
      return {'maxlength': true}
    }
  }

  checkSalary(salary: AbstractControl) {
    let value = salary.value;
    if (value == '') {
      return {'required': true}
    } else if (value % 100000 != 0) {
      return {'format': true}
    } else if (value >= 100000000) {
      return {'max': true}
    }
  }

  get username() {
    return this.employeeFormCreate.get('username');
  }

  get name() {
    return this.employeeFormCreate.get('name');
  }

  get email() {
    return this.employeeFormCreate.get('email');
  }

  get address() {
    return this.employeeFormCreate.get('address');
  }

  get image() {
    return this.employeeFormCreate.get('image');
  }

  get phoneNumber() {
    return this.employeeFormCreate.get('phoneNumber');
  }

  get birthday() {
    return this.employeeFormCreate.get('birthday');
  }

  get salary() {
    return this.employeeFormCreate.get('salary');
  }

}
