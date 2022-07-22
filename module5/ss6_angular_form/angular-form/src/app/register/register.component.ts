import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerFormReactive: FormGroup;
  @Output() submitRegister = new EventEmitter()

  constructor() {
    this.registerFormReactive = new FormGroup({
      email: new FormControl('',[Validators.required]),
      pass: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        confirmPassword: new FormControl('',[Validators.required,Validators.minLength(6)]),
      }),

      country: new FormControl('',[Validators.required]),
      age: new FormControl('',[Validators.min(18)]),
      gender: new FormControl(),
      phone: new FormControl('',[Validators.pattern("^\\+84\\d{9,10}$")])
    });
  }

  ngOnInit(): void {
  }

  registerWithReactive() {
    if(this.registerFormReactive.valid){
      this.submitRegister.emit(this.registerFormReactive.value)
    }
  }
}
