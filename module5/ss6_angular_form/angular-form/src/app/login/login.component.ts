import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor() {
    this.loginForm = new FormGroup({
      email: new FormControl('',[Validators.email]),
      password: new FormControl('',[Validators.minLength(6)]),
    });
  }

  ngOnInit(): void {
  }

  message: string = '';

  checkLogin() {
    if(this.loginForm.valid) {
      this.message = "Success";
    }else {
      this.message = "Fail";
    }
  }


}
