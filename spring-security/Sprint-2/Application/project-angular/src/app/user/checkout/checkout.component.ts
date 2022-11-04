import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {AuthService} from '../service/auth.service';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AngularFireStorage} from '@angular/fire/storage';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';
import {AppUser} from '../model/appUser';
import {Subscription} from 'rxjs';
import {CommonService} from '../service/common.service';

declare var $: any;

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  userCheckoutForm: FormGroup;
  public role: string;
  public username: string = '';
  public loginStatus: any;
  customer: Customer;
  selectedImage: any;
  public imgSrc: any = '../../../assets/img/loading.gif';
  appUser: AppUser;
  messageReceived: any;
  private subscriptionName: Subscription;

  constructor(@Inject(AngularFireStorage) private storage: AngularFireStorage,
              private authService: AuthService,
              private customerService: CustomerService,
              private router: Router,
              private toastrService: ToastrService,
              private commonService: CommonService) {
    this.authService.checkLogin().subscribe(value => {
      this.loginStatus = value;
      if (value) {
        this.authService.getRoles().subscribe(resp => {
          this.getRole(resp);
          this.getCustomerByUsername(resp.username);
        }, error => {
        });
      }
    }, error => {
    });
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
    });
  }

  getRole(value: any) {
    if (this.isAdmin(value.grantList)) {
      this.role = 'ROLE_ADMIN';
    } else if (this.isUser(value.grantList)) {
      this.role = 'ROLE_USER';
    }
    this.username = value.username;
  }

  isAdmin(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_ADMIN';
    });
  }

  isUser(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_USER';
    });
  }

  ngOnInit(): void {
    this.sendMessage();
  }

  createForm(customer: Customer, appUser: AppUser) {
    if (customer == null) {
      this.userCheckoutForm = new FormGroup({
        name: new FormControl(),
        phoneNumber: new FormControl(),
        address: new FormControl(),
        email: new FormControl(),
        birthday: new FormControl(),
        image: new FormControl(),
        appUser: new FormControl(appUser)
      });
    } else {
      this.userCheckoutForm = new FormGroup({
        id: new FormControl(customer.id),
        name: new FormControl(customer.name),
        phoneNumber: new FormControl(customer.phoneNumber),
        address: new FormControl(customer.address),
        email: new FormControl(customer.email),
        birthday: new FormControl(customer.birthday),
        image: new FormControl(customer.image),
        appUser: new FormControl(customer.appUser)
      });
    }
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUsername(username).subscribe(c => {
      this.customer = c;
      this.customerService.getAppUserFromUsername(username).subscribe((au: AppUser) => {
        this.appUser = au;
        this.createForm(c, au);
      });
      if (c != null) {
        $('#previewImage').attr('src', c.image);
      }
    });
  }

  onCheckout() {
    if (this.userCheckoutForm.valid) {
      let customerValue: Customer = this.userCheckoutForm.value;
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

  sendMessage(): void {
    // send message to subscribers via observable subject
    this.commonService.sendUpdate('Đăng Nhập thành công!');
  }

  checkErrorName() {

  }

  checkErrorPhoneNumber() {

  }

  checkErrorAddress() {

  }

  checkErrorEmail() {

  }

  checkErrorBirthday() {

  }

  chooseFile() {
    $('.custom-file-input').on('change', function() {
      const fileName = $(this).val().split('\\').pop();
      $(this).siblings('.custom-file-label').addClass('selected').html(fileName);
    });
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

  private getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }
}
