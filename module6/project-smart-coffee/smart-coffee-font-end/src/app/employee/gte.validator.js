import {AbstractControl, ValidationErrors} from "@angular/forms";

export function gte1(control: AbstractControl): ValidationErrors | null {
  const user = ['admin', 'root'];
  return (user.includes(control.value)) ? {
    invalidUsername: true
  } : null;
}

export function gte2(control: AbstractControl): ValidationErrors | null {
  const v =+ control.value
  if(v%100000){
    return {'gte2': true, 'requiredValue': 100000}
  }
  return null;
}
