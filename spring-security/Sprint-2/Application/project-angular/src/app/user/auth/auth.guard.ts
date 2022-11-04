import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from '../service/auth.service';
import {ToastrService} from 'ngx-toastr';
import {map} from 'rxjs/operators';
import {CommonService} from '../service/common.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService,
              private router: Router,
              private toastrService: ToastrService,
              private commonService: CommonService) {
  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.authService.checkLogin().pipe(map(value => {
      if (value) {
        return true;
      } else {
        this.router.navigateByUrl("/401").then(() => {
          this.toastrService.warning("Vui lòng đăng nhập để thực hiện chức năng này!");
          this.sendMessage();
        });
        return false;
      }
    }))
  }
  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }
}
