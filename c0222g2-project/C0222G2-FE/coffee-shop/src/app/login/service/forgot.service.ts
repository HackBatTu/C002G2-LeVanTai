import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ForgotService {
  private SEND_MAIL_URL = "http://localhost:8080/sendSimpleEmail";
  private FIND_PASSWORD_URL = "http://localhost:8080/findPassword";

  constructor(private httpClient: HttpClient) {
  }

  onForgot(username: string): Observable<any> {
    return this.httpClient.post(this.SEND_MAIL_URL, {username: username});
  }

  onFindPassword(value: any): Observable<any> {
    console.log(value)
    return  this.httpClient.post(this.FIND_PASSWORD_URL, {
      password: value.pass.password,
      confirmPassword: value.pass.confirmPassword,
      token: value.token
    })
  }
}
