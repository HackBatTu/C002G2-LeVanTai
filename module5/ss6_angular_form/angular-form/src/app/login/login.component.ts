import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Output() submitLogin = new EventEmitter()
  constructor() { }

  ngOnInit(): void {
  }

  loginFormWithTemplates(loginForm: NgForm) {
    this.submitLogin.emit(loginForm.value)
  }

}
