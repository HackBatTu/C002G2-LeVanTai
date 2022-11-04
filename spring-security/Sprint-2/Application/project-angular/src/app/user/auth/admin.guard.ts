import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from '../service/auth.service';
import {map} from 'rxjs/operators';
import {ToastrService} from 'ngx-toastr';
import {CommonService} from '../service/common.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(private authService: AuthService,
              private router: Router,
              private toastrService: ToastrService,
              private commonService: CommonService) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    this.authService.checkAdminRole().subscribe(value => {
      if (value) {
        return true;
      }
    }, error => {
      if (error.status == 403) {
        this.router.navigateByUrl("/403").then(() => {
          this.toastrService.warning("Bạn không có quyền truy cập vào trang này!")
        });
        return false;
      }
      this.router.navigateByUrl("/401").then(() => {
        this.toastrService.warning("Vui lòng đăng nhập để thực hiện chức năng này!");
        this.sendMessage();
      })
    })
    return this.authService.checkAdminRole().pipe(map(value => {
      if (value) {
        return true;
      } else {
        this.router.navigateByUrl("/403").then(() => {
          this.toastrService.error("Bạn không có quyền truy cập vào trang này!")
        });
        return false;
      }
    }))
  }
  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }
}
