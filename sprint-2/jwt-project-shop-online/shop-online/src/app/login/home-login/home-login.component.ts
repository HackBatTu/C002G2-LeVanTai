import {Component, ElementRef, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Subscription} from 'rxjs';
import {Title} from '@angular/platform-browser';
import { SocialAuthService, SocialUser } from 'angularx-social-login';
import {TokenService} from "../../service/token.service";
import {CheckLogService} from "../../service/security/check-log.service";
import {AuthService} from "../../service/security/auth.service";
import {CommonService} from "../../service/security/common.service";
import {ForgotService} from "../../service/security/forgot.service";
import {OauthService} from "../../service/security/oauth.service";
import {CustomerService} from "../../service/customer/customer.service";

declare var $: any;
declare var FB: any;
@Component({
  selector: 'app-home-login',
  templateUrl: './home-login.component.html',
  styleUrls: ['./home-login.component.css']
})
export class HomeLoginComponent implements OnInit, OnDestroy {
  @ViewChild('loginRef', {static: true }) loginElement: ElementRef;
  loginForm: FormGroup;
  forgotForm: FormGroup;
  messageReceived: any;
  private subscriptionName: Subscription;
  public passwordStatus: string = 'SHOW';
  public buttonLoginStatus: boolean = true;
  public activeLogin: boolean = false;
  public LoginFailCount: number = 0;
  public realTimeSecond: number = 0;
  public realTimeMinute: number = 2
  registerForm: FormGroup;
  public confirmPasswordStatus: string = 'SHOW';
  public buttonRegisterStatus: boolean = true;
  auth2: any;
  socialUser: SocialUser;
  userLogged: SocialUser;
  isLogged: boolean;
  constructor(private router: Router,
              private toastrService: ToastrService,
              private loginService: CheckLogService,
              private authService: AuthService,
              private authServices: SocialAuthService,
              private oauthService: OauthService,
              private tokenService: TokenService,
              private forgotService: ForgotService,
              private commonService: CommonService,
              private title: Title,
              private customerService: CustomerService,
              private el: ElementRef) {
    this.title.setTitle('Đăng Nhập');
    const timePrevious = Number(localStorage.getItem("time"));
    if (timePrevious != 0) {
      let realTimeInterval = setInterval(() => {
        const d = new Date();
        let hours: number = d.getHours();
        let minutes: number = d.getMinutes();
        let seconds: number = d.getSeconds();
        const timeNext = hours * 60 * 60 + minutes * 60 + seconds;
        if (timeNext - timePrevious >= 120) {
          this.activeLogin = true;
          clearInterval(realTimeInterval);
          this.realTimeSecond = 0;
          this.realTimeSecond = 0;
          localStorage.setItem("time", "0");
        }
        let realTime = ((timePrevious - timeNext) + 120)
        this.realTimeMinute = Math.floor(realTime / 60);
        this.realTimeSecond = realTime % 60;
      }, 1000)
    } else {
      this.activeLogin = true;
    }

    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
    });
  }

  ngOnInit(): void {
    this.authServices.authState.subscribe(
      data => {
        this.userLogged = data;
        this.isLogged = (this.userLogged != null && this.tokenService.getToken() != null);
      }
    );
    this.createLoginForm();
    this.createForgotForm();
    this.createRegisterForm();
  }

  createLoginForm() {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      stayLogged: new FormControl()
    });
  }

  createForgotForm() {
    this.forgotForm = new FormGroup({
      username: new FormControl('', [Validators.required])
    });
  }

  onLogin() {
    this.buttonLoginStatus = false;
    const account = this.loginForm.value;
    if (this.loginForm.valid && this.activeLogin) {
      this.loginService.onLogin(account).subscribe(value => {
        setTimeout(()=>{
          this.router.navigateByUrl('/home').then(() => {
            this.toastrService.success('Đăng nhập thành công!');
            this.buttonLoginStatus = true;
            this.sendMessage();
          });
        }, 2000)
        this.router.navigateByUrl('/loading').then(() => {
        });
      }, error => {
        this.buttonLoginStatus = true;
        this.LoginFailCount++;
        if (this.LoginFailCount >= 3) {
          const d = new Date();
          let hours = d.getHours();
          let minutes = d.getMinutes();
          let seconds: number = d.getSeconds();
          localStorage.setItem("time", String(hours * 60 * 60 + minutes * 60 + seconds));
          this.activeLogin = false;
          this.toastrService.error("Bạn nhập sai quá 3 lần hãy thử lại sau ít phút!");
          this.router.navigateByUrl('/home', { skipLocationChange: true }).then(() => {
            this.router.navigate([window.location.pathname]);
          });
        } else {
          this.toastrService.error('Tên đăng nhập hoặc mật khẩu không chính xác! ' + this.LoginFailCount + " lần");
        }
      }, () => {
      });
    } else {
      this.buttonLoginStatus = true;
      this.checkErrorPassword();
      this.checkErrorUsername();
      if (this.loginForm.controls.username.invalid) {
        $('#username').focus();
        $('#field-username').css('border', '1px solid red');
        $('#field-password').css('border', 'none');
      } else if (this.loginForm.controls.password.invalid) {
        $('#password').focus();
        $('#field-password').css('border', '1px solid red');
        $('#field-username').css('border', 'none');
      }
    }
  }

  onForgot() {
    if (this.forgotForm.valid) {
      this.router.navigateByUrl('/loading').then(() => {
        // @ts-ignore
        $('#staticBackdropForgot').modal('hide');
      });
      this.forgotService.onForgot(this.forgotForm.value.username).subscribe(value => {
      }, error => {
        // @ts-ignore
        $('#staticBackdropForgot').modal('hide');
        this.router.navigateByUrl('/login').then(() => {
          this.toastrService.warning('Tên tài khoản không tồn tại!');
          // @ts-ignore
          $('#staticBackdropForgot').modal('show');
        });
      }, () => {
        this.router.navigateByUrl('/login').then(() => {
          // @ts-ignore
          $('#staticBackdropForgot').modal('hide');
          this.toastrService.success('Gửi yêu cầu thành công. Vui lòng kiểm tra email của bạn!');
          this.forgotForm.reset();
        });
      });
    } else {
      this.toastrService.warning('Thông tin bạn nhập chưa chính xác!');
    }
  }

  openSignIn() {
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    signUpButton.addEventListener('click', () => {
      container.classList.add('right-panel-active');
    });

    signInButton.addEventListener('click', () => {
      container.classList.remove('right-panel-active');
    });
  }

  sendMessage(): void {
    // send message to subscribers via observable subject
    this.commonService.sendUpdate('Đăng Nhập thành công!');
  }

  closeForgot() {
    this.forgotForm.reset();
  }

  onRegister() {
    this.buttonRegisterStatus = false;
    if (this.registerForm.valid) {
      $('#field-username').css('border', 'none');
      $('#field-password').css('border', 'none');
      $('#field-confirmPassword').css('border', 'none');
      let userRegister = {
        username: this.registerForm.value.username,
        password: this.registerForm.value.pass.password,
        confirmPassword: this.registerForm.value.pass.confirmPassword
      };
      // @ts-ignore
      this.authService.goRegister(userRegister).subscribe(() => {
        setTimeout(() => {
          this.router.navigateByUrl("/login").then(() => {
            this.toastrService.success("Đăng ký thành công!");
            this.buttonRegisterStatus = true;
          })
        }, 2000)
      }, error => {
        this.buttonRegisterStatus = true;
        switch (error.error.defaultMessage) {
          case "usernameExists":
            this.registerForm.controls.username.setErrors({'usernameExists': true});
            this.toastrService.error("Tên đăng nhập đã tồn tại!")
            break;
          case "passwordNotSame":
            this.registerForm.controls.pass.setErrors({'confirmPass': true})
            this.toastrService.error("Tên nhập lại mật khẩu phải trùng với mật khẩu!")
            break;
          default:
            this.toastrService.error("Vui lòng nhập đúng thông tin!")
            break;
        }
        this.focusErrorInput();
      });
    } else {
      this.buttonRegisterStatus = true;
      this.checkErrorUsername();
      this.checkErrorPassword();
      this.checkErrorConfirmPassword();
      this.focusErrorInput();
    }
  }

  createRegisterForm() {
    this.registerForm = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.pattern('^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$')]),
      pass: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.pattern('^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$')]),
        confirmPassword: new FormControl('', [Validators.required, Validators.pattern('^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$')])
      }, this.checkSamePassword)
    });
  }

  checkSamePassword(pass: AbstractControl) {
    let value = pass.value;
    if (value.password != value.confirmPassword) {
      return {'confirmPass': true};
    }
    return null;
  }

  focusErrorInput() {
    for (const key of Object.keys(this.registerForm.controls)) {
      if (this.registerForm.controls[key].invalid) {
        const invalidControl = this.el.nativeElement.querySelector('[formcontrolname="' + key + '"]');
        invalidControl.focus();
        this.toastrService.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
        break;
      }
    }
    return this.toastrService.warning('Vui lòng nhập đầy đủ và đúng dữ liệu!!!', 'Thông báo!!!');
  }

  showPassword() {
    if (this.passwordStatus == 'SHOW') {
      $('#password').attr('type', 'text');
      this.passwordStatus = 'HIDE';
    } else if (this.passwordStatus == 'HIDE') {
      $('#password').attr('type', 'password');
      this.passwordStatus = 'SHOW';
    }
  }

  showConfirmPassword() {
    if (this.confirmPasswordStatus == 'SHOW') {
      $('#confirmPassword').attr('type', 'text');
      this.confirmPasswordStatus = 'HIDE';
    } else if (this.confirmPasswordStatus == 'HIDE') {
      $('#confirmPassword').attr('type', 'password');
      this.confirmPasswordStatus = 'SHOW';
    }
  }

  checkErrorUsername() {
    let dataToggleUsername = $('[data-bs-toggle="username"]');
    if (this.registerForm.controls.username.hasError('required')) {
      dataToggleUsername.attr('data-bs-content', 'Tên đăng nhập không được để trống.');
      setTimeout(() => {
        dataToggleUsername.popover('hide');
      }, 2000)
      dataToggleUsername.popover('show');
    } else if (this.registerForm.controls.username.hasError('pattern')) {
      dataToggleUsername.attr('data-bs-content', 'Tên đăng nhập từ 8 - 20 ký tự bắt đầu bằng chữ cái và không được chứa ký tự đặc biệt.');
      setTimeout(() => {
        dataToggleUsername.popover('hide');
      }, 2000)
      dataToggleUsername.popover('show');
    } else if (this.registerForm.controls.username.hasError('usernameExists')) {
      dataToggleUsername.attr('data-bs-content', 'Tên đăng nhập đã tồn tại.');
      setTimeout(() => {
        dataToggleUsername.popover('hide');
      }, 2000)
      dataToggleUsername.popover('show');
    } else {
      dataToggleUsername.popover('hide');
    }
  }

  checkErrorPassword() {
    let dataTogglePassword = $('[data-bs-toggle="password"]');
    if (this.registerForm.controls.pass.get('password').hasError('required')) {
      dataTogglePassword.attr('data-bs-content', 'Mật khẩu không được để trống.');
      setTimeout(() => {
        dataTogglePassword.popover('hide');
      }, 2000)
      dataTogglePassword.popover('show');
    } else if (this.registerForm.controls.pass.get('password').hasError('pattern')) {
      dataTogglePassword.attr('data-bs-content', 'Mật khẩu tối thiểu tám ký tự, ít nhất một chữ cái, một số và một ký tự đặc biệt.');
      setTimeout(() => {
        dataTogglePassword.popover('hide');
      }, 2000)
      dataTogglePassword.popover('show');
    } else {
      dataTogglePassword.popover('hide');
    }
  }

  checkErrorConfirmPassword() {
    let dataToggleConfirmPassword = $('[data-bs-toggle="confirmPassword"]');
    let dataToggleSamePass = $('[data-toggle="samePassword"]');
    if (this.registerForm.controls.pass.get('confirmPassword').hasError('required')) {
      dataToggleConfirmPassword.attr('data-bs-content', 'Mật khẩu không được để trống.');
      setTimeout(() => {
        dataToggleConfirmPassword.popover('hide');
      }, 2000)
      dataToggleConfirmPassword.popover('show');
    } else if (this.registerForm.controls.pass.get('confirmPassword').hasError('pattern')) {
      dataToggleConfirmPassword.attr('data-bs-content', 'Mật khẩu tối thiểu tám ký tự, ít nhất một chữ cái, một số và một ký tự đặc biệt.');
      setTimeout(() => {
        dataToggleConfirmPassword.popover('hide');
      }, 2000)
      dataToggleConfirmPassword.popover('show');
    } else if (this.registerForm.controls.pass.get('password').valid && this.registerForm.controls.pass.get('confirmPassword').valid) {
      if (this.registerForm.controls.pass.hasError('confirmPass')) {
        dataToggleSamePass.attr('data-bs-content', 'Mật khẩu và xác nhận mật khẩu phải giống nhau.');
        setTimeout(() => {
          dataToggleSamePass.popover('hide');
        }, 2000)
        dataToggleSamePass.popover('show');
      } else {
        dataToggleSamePass.popover('hide');
      }
    } else {
      dataToggleSamePass.popover('hide');
    }
  }

  ngOnDestroy(): void {
    this.subscriptionName.unsubscribe();
    $('[data-toggle="username"]').popover('hide');
    $('[data-toggle="password"]').popover('hide');
    $('[data-toggle="confirmPassword"]').popover('hide');
    $('[data-toggle="samePassword"]').popover('hide');
  }



}
