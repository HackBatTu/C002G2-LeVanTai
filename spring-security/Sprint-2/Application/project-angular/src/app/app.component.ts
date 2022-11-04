import {Component} from '@angular/core';
import {AuthService} from './user/service/auth.service';
import {Customer} from './user/model/customer';
import {CustomerService} from './user/service/customer.service';

declare var $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'project-angular';
  public role: string;
  public username: string = '';
  public loginStatus: any;
  customer: Customer;

  constructor(private authService: AuthService,
              private customerService: CustomerService) {
    this.authService.checkLogin().subscribe(value => {
      this.loginStatus = value;
      if (value) {
        this.authService.getRoles().subscribe(resp => {
          this.getCustomerByUsername(resp.username);
          this.getRole(resp);
        }, error => {
        });
      }
    }, error => {
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

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUsername(username).subscribe(value => {
      this.customer = value;
    });
  }

  onActivate(event) {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });
  }

}
