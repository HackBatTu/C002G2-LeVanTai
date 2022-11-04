import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {CookieService} from "../service/cookie.service";
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate {
  constructor(private cookieService: CookieService,
              private router: Router,
              private toastrService: ToastrService) {
  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.cookieService.getCookie("jwToken") != "") {
      this.router.navigateByUrl("/home").then(() => {
        this.toastrService.error("Bạn đã đăng nhập rồi!")
      })
      return false;
    }
    return true;
  }

}
