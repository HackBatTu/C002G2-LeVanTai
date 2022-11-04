import {Component, ElementRef, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from "../service/employee.service";
import {Router, ActivatedRoute, ParamMap} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {AngularFireStorage} from "@angular/fire/storage";
import {formatDate} from "@angular/common";
import {finalize} from "rxjs/operators";
import {Employee} from "../model/employee/employee";
import {AppUser} from "../model/account/app-user";
import {Position} from "../model/employee/position";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  employeeFormEdit: FormGroup;
  employee: Employee = {};
  appUser: AppUser[] = [];
  position: Position[] = [];
  selectedImage: any = null;
  imgSrc: any;
  isLoading: Boolean = false;

  constructor(private employeeService: EmployeeService, private router: Router,
              private storage: AngularFireStorage,
              private activate: ActivatedRoute,
              private toast: ToastrService, private title: Title,private el: ElementRef) {
    this.title.setTitle("Sửa thông tin nhân viên")
  }

  ngOnInit(): void {
    this.getParamId();
  }

  getParamId() {
    this.activate.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id');
      // @ts-ignore
      this.employeeService.findByIdEdit(parseInt(id)).subscribe(data => {
        // @ts-ignore
        this.employee = data;
        if (data == null) {
          this.toast.error("Không có dữ liệu hoặc bạn đang nhập quá dữ liệu hiện có", "Thông Báo")
          this.router.navigateByUrl('/employee').then();
        }
        this.getAllUser();
        this.getAllPosition();
        this.getEmployeeFormUpdate();
      });
    });
  }

  getAllPosition() {
    this.employeeService.getAllPosition().subscribe(data => {
      // @ts-ignore
      this.position = data;
    });
  }

  getAllUser() {
    this.employeeService.getAllUser().subscribe(data => {
      // @ts-ignore
      this.appUser = data;
    });
  }

  getEmployeeFormUpdate() {
    this.employeeFormEdit = new FormGroup({
      id: new FormControl(this.employee.id),
      appUser: new FormControl(this.employee.appUser),
      image: new FormControl(this.employee.image, this.checkImage),
      name: new FormControl(this.employee.name, this.checkName),
      email: new FormControl(this.employee.email, this.checkMail),
      address: new FormControl(this.employee.address, this.checkAddress),
      gender: new FormControl(this.employee.gender),
      phoneNumber: new FormControl(this.employee.phoneNumber, this.checkPhoneNumber),
      birthday: new FormControl(this.employee.birthday, this.checkBirthday),
      salary: new FormControl(this.employee.salary, this.checkSalary),
      position: new FormControl(this.employee.position.id),
      isDeleted: new FormControl(this.employee.isDeleted)
    });
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ss', 'en-US');
  }

  updateEmployee() {
    this.toggleLoading();
    let employee: Employee = this.employeeFormEdit.value;
    employee.address = employee.address.trim();
    if (this.selectedImage == null) {
      for (const key of Object.keys(this.employeeFormEdit.controls)) {
        if (this.employeeFormEdit.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
          invalidControl.focus();
          this.toast.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
          break;
        }
      }
      if (this.employeeFormEdit.valid) {
        this.employeeService.updateEmployee(employee).subscribe((data) => {
          this.toast.success('Cập nhật thành công', 'Thông báo!!!')
          this.router.navigateByUrl('/employee').then();
        });
      } else {
        return this.toast.warning("Vui lòng nhập đầy đủ và đúng dữ liệu!!!", "Thông báo")
      }
    } else {
      const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
      const fileRef = this.storage.ref(nameImg);
      this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe((url) => {
            employee.image = url;
            if (this.employeeFormEdit.valid) {
              this.employeeService.updateEmployee(employee).subscribe((data) => {
                this.toast.success('Cập nhật thành công', 'Thông báo!!!')
                this.router.navigateByUrl('/employee').then()
              });
            } else {
              for (const key of Object.keys(this.employeeFormEdit.controls)) {
                if (this.employeeFormEdit.controls[key].invalid) {
                  const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
                  invalidControl.focus();
                  break;
                }
              }
              return this.toast.warning("Vui lòng nhập đầy đủ và đúng dữ liệu!!!", "Thông báo")
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

  compareUserName(c1: AppUser, c2: AppUser): boolean {
    if ((c1 && c2) != undefined) {
      return c1.id === c2.id;
    }
  }

  comparePosition(c1: Position, c2: Position): boolean {
    if ((c1 && c2) != undefined) {
      return c1.id === c2.id;
    }
  }
  checkAddress(addressName: AbstractControl){
    const value = addressName.value
    if(value == ''){
      return {'required': true};
    }
    else if (value.length <= 6) {
      return {'minlength': true}
    }
    else if (value.length >= 255) {
      return {'maxlength': true}
    }
  }
  checkImage(image: AbstractControl) {
    const value = image.value
    if(value == ''){
      return {'required': true};
    }
    else if (value.length >= 255) {
      return {'maxlength': true}
    }
  }
  checkPhoneNumber(phoneNumber: AbstractControl) {
    const value = phoneNumber.value
    if(value == ''){
      return {'required': true};
    }
    else if (value.match("^(03|08|09|\\(84\\)\\+9)\\d\\d{7}$") == null) {
      return {'pattern': true}
    }
  }
  checkName(name: AbstractControl){
    const value = name.value
    if(value == ''){
      return {'required': true};
    } else if(value.match("^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
      "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*( )){0,14}" +
      "([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
      "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*)$") == null){
      return {'pattern': true}
    } else if (value.length <= 6) {
      return {'minlength': true}
    } else if (value.length >= 30) {
      return {'maxlength': true}
    }
  }

  checkMail(mail: AbstractControl){
    const value = mail.value
    if(value == ''){
      return {'required': true};
    } else if(value.match("^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$") == null){
      return {'email': true}
    } else if (value.length <= 6) {
      return {'minlength': true}
    } else if (value.length >= 30) {
      return {'maxlength': true}
    }
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
    }
    else if(age < 16){
      return {'age16': true}
    }
    else if(value.match("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$") == null){
      return {'pattern': true}
    }
  }

  checkSalary(salary: AbstractControl) {
    let value = salary.value;
    if(value == '') {
      return {'required': true}
    }
    else if (value % 100000 != 0) {
      return {'format': true}
    }
    else if(value >=100000000){
      return {'max': true}
    }
  }

  get name() {
    return this.employeeFormEdit.get('name');
  }

  get image() {
    return this.employeeFormEdit.get('image');
  }

  get address() {
    return this.employeeFormEdit.get('address');
  }

  get phoneNumber() {
    return this.employeeFormEdit.get('phoneNumber');
  }

  get birthday() {
    return this.employeeFormEdit.get('birthday');
  }

  get salary() {
    return this.employeeFormEdit.get('salary');
  }

  get email() {
    return this.employeeFormEdit.get('email');
  }


}
