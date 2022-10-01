import {Component, ElementRef, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup} from "@angular/forms";
import {AppUser} from "../../model/app-user";
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {AngularFireStorage} from "@angular/fire/storage";
import {Title} from "@angular/platform-browser";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";
import {CookieService} from "../../login/service/cookie.service";
import {CommonService} from "../../login/service/common.service";
import {Subscription} from "rxjs";
declare var $: any;
@Component({
  selector: 'app-add-info-user',
  templateUrl: './add-info-user.component.html',
  styleUrls: ['./add-info-user.component.css']
})
export class AddInfoUserComponent implements OnInit {
  userForm: FormGroup;
  customer: Customer;
  appUser: AppUser;
  public role: string;
  public username: string = '';
  public imgSrc: any = 'assets/img/loading-symbol.gif';
  selectedImage: any = null;
  isLoading: Boolean = false;
  private subscriptionName: Subscription;
  token: string = '';
  picture: any;

  constructor(private cookieService: CookieService,
              private toastrService: ToastrService,
              private storage: AngularFireStorage,
              private router: Router,
              private commonService: CommonService,
              private customerService: CustomerService,
              private title: Title,
              private el: ElementRef) {
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    this.title.setTitle("Thêm Thông Tin Tài Khoản")
    // subscribe to sender component messages
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      // this.messageReceived = message;
      this.role = this.readCookieService('role');
      this.username = this.readCookieService('username');
      this.token = this.readCookieService('jwToken');
    });

  }
  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.sendMessage();
    this.getCustomerByUsername();
  }

  getCustomerByUsername() {
    this.customerService.getCustomerByUserName(this.username).subscribe(data => {
      this.customer = data;
      this.customerService.getAppUserFromUsername(this.username).subscribe((value: AppUser) => {
        this.appUser = value;
        this.getForm(data, value);
      });
      if (data != null) {
        $('#previewImage').attr('src', data.image);
      }
    });
    console.log(this.customer)
    console.log(this.appUser)
  }

  getForm(customer: Customer, appUser: AppUser){
    if(customer == null){
      this.userForm = new FormGroup({
        name: new FormControl('',this.checkName),
        image: new FormControl('',this.checkImage),
        birthday: new FormControl('',this.checkBirthday),
        phone: new FormControl('',this.checkPhone),
        email: new FormControl('',this.checkMail),
        address: new FormControl(''),
        hobbies: new FormControl('',this.checkHobbies),
        appUser: new FormControl(appUser),
        isDeleted: new FormControl(0)
      })
    }else {
      this.userForm = new FormGroup({
        id: new FormControl(customer.id),
        name: new FormControl(this.customer.name,this.checkName),
        image: new FormControl(this.customer.image,this.checkImage),
        birthday: new FormControl(this.customer.birthday.slice(0, 10),this.checkBirthday),
        phone: new FormControl(this.customer.phone,this.checkPhone),
        email: new FormControl(this.customer.email,this.checkMail),
        address: new FormControl(this.customer.address),
        hobbies: new FormControl(this.customer.hobbies,this.checkHobbies),
        appUser: new FormControl(this.customer.appUser),
        isDeleted: new FormControl(this.customer.isDeleted)
      })
    }
  }
  chooseFile() {
    $('.custom-file-input').on('change', function() {
      const fileName = $(this).val().split('\\').pop();
      $(this).siblings('.custom-file-label').addClass('selected').html(fileName);
    });
  }


  sendMessage(): void {
    // send message to subscribers via observable subject
    this.commonService.sendUpdate('Đăng Nhập thành công!');
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
  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ssa', 'en-US');
  }

  onEditInfo() {
    this.toggleLoading();
    if (this.userForm.valid) {
      let customerValue: Customer = this.userForm.value;
      console.log(customerValue)
      if (this.selectedImage == undefined) {
        this.customerService.saveCustomer(customerValue).subscribe(value => {
          this.router.navigateByUrl('/info').then(() => {
            this.toastrService.success('Cập nhật thông tin thành công!');
            this.sendMessage();
          });
        });
      } else {
        const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
        const fileRef = this.storage.ref(nameImg);
        this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
          finalize(() => {
            fileRef.getDownloadURL().subscribe((url) => {
              customerValue.image = url;
              this.customerService.saveCustomer(customerValue).subscribe(value => {
                this.router.navigateByUrl('/info').then(() => {
                  this.toastrService.success('Cập nhật thông tin thành công!');
                  this.sendMessage();
                });
              });
            });
          })
        ).subscribe();
      }
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
