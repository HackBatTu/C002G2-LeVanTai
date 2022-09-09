import {Component, ElementRef, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup} from "@angular/forms";
import {AppUser} from "../../model/app-user";
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {AngularFireStorage} from "@angular/fire/storage";
import {Title} from "@angular/platform-browser";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-add-info-user',
  templateUrl: './add-info-user.component.html',
  styleUrls: ['./add-info-user.component.css']
})
export class AddInfoUserComponent implements OnInit {
  userForm: FormGroup;
  customer: Customer;
  appUser: AppUser[] = [];
  imgSrc: any;
  selectedImage: any = null;
  fileUploader: any;
  isLoading: Boolean = false;

  constructor(private customerService: CustomerService,
              private toast: ToastrService,
              private activate: ActivatedRoute,
              private storage: AngularFireStorage,
              private title: Title,
              private el: ElementRef,
              private router: Router) {
    this.title.setTitle("Thêm Thông Tin Tài Khoản")
  }

  ngOnInit(): void {
    this.getParamUserName();
  }

  getParamUserName(){
    this.activate.paramMap.subscribe((paraMap: ParamMap) => {
      const userName =paraMap.get('userName')
      this.customerService.findByUserName(userName).subscribe( data => {
        this.customer =data;
        if(data == null){
          this.toast.error("Bạn đang nhập quá dư liệu")
          this.router.navigateByUrl("/info").then();
        }
        this.getListUser()
        this.getForm()
      })
    })
  }

  getForm(){
    this.userForm = new FormGroup({
      name: new FormControl(this.customer.name,this.checkName),
      image: new FormControl(this.customer.image,this.checkImage),
      birthday: new FormControl(this.customer.birthday,this.checkBirthday),
      phone: new FormControl(this.customer.phone,this.checkPhone),
      email: new FormControl(this.customer.email,this.checkMail),
      hobbies: new FormControl(this.customer.hobbies,this.checkHobbies),
      appUsers: new FormControl(this.customer.appUser.id)
    })
  }

  getListUser(){
    this.customerService.getListUser().subscribe( data => {
      // @ts-ignore
      this.appUser = data;
    })
  }

  showPreview(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (o: any) => this.imgSrc = o.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectedImage = event.target.files[0];
      document.getElementById("img").style.display = "block"
    } else {
      this.imgSrc = "";
      this.selectedImage = null;
    }
  }
  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ss', 'en-US');
  }

  onEditInfo() {
    this.toggleLoading();
    let customer: Customer = this.userForm.value;
    if (this.selectedImage == null) {
      for (const key of Object.keys(this.userForm.controls)) {
        if (this.userForm.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
          invalidControl.focus();
          this.toast.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
          break;
        }
      }
      if (this.userForm.valid) {
        this.customerService.updateCustomer(customer).subscribe((data) => {
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
            customer.image = url;
            if (this.userForm.valid) {
              this.customerService.updateCustomer(customer).subscribe((data) => {
                this.toast.success('Cập nhật thành công', 'Thông báo!!!')
                this.router.navigateByUrl('/info').then()
              });
            } else {
              for (const key of Object.keys(this.userForm.controls)) {
                if (this.userForm.controls[key].invalid) {
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
  compareUser(c1: AppUser, c2: AppUser): boolean {
    if((c1 && c2 ) != undefined){
      return c1.id === c1.id
    }
  }
  toggleLoading() {
    this.isLoading = true;
    setTimeout(() => {
      this.isLoading = false;
    }, 3000)
  }
  checkHobbies(hobbies: AbstractControl){
    const value = hobbies.value
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
  checkPhone(phone: AbstractControl) {
    const value = phone.value
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
  get name() {
    return this.userForm.get('name');
  }

  get image() {
    return this.userForm.get('image');
  }

  get address() {
    return this.userForm.get('address');
  }

  get phone() {
    return this.userForm.get('phone');
  }

  get birthday() {
    return this.userForm.get('birthday');
  }

  get hobbies() {
    return this.userForm.get('hobbies');
  }

  get email() {
    return this.userForm.get('email');
  }
}
