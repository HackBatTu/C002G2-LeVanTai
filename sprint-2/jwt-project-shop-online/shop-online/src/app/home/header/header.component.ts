import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {Order} from "../../model/order";
import {AuthService} from "../../service/security/auth.service";
import {CheckLogService} from "../../service/security/check-log.service";
import {CommonService} from "../../service/security/common.service";
import {CustomerService} from "../../service/customer/customer.service";
import {Customer} from "../../model/customer";
import {OrderService} from "../../service/product/order.service";


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public role: string;
  public username: string;
  public loginStatus: any;
  messageReceived: any;
  private subscriptionName: Subscription;
  public buttonLogoutStatus: boolean = true;
  public infoStatus: boolean = true;
  public avatar: string;
  public name: string = '';
  productOrders: Order[] = [];
  totalProductInCart: number = 0;

  constructor(private logoutService: CheckLogService,
              private toastrService: ToastrService,
              private router: Router,
              private authService: AuthService,
              private orderService: OrderService,
              private customerService: CustomerService,
              private commonService: CommonService) {
    this.authService.checkLogin().subscribe(value => {
      this.loginStatus = value;
      if (value) {
        this.authService.getRoles().subscribe(resp => {
          this.getRole(resp);
          this.getCustomerByUsername(resp.username);
        }, error => {
        });
      }
    }, error => {
    });
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
      this.authService.checkLogin().subscribe(value => {
        this.loginStatus = value;
        if (value) {
          this.authService.getRoles().subscribe(resp => {
            this.getRole(resp);
            this.getCustomerByUsername(resp.username);
          }, error => {
          });
        }
      }, error => {
      });
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

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe((value: Customer) => {
      if (value == null) {
        this.infoStatus = true;
      } else {
        this.getProductInCardByCustomer(value);
        this.infoStatus = value.appUser.isDeleted;
        this.avatar = value.image;
        this.name = value.name;
      }
    });
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

  ngOnInit(): void {
  }

  onLogout() {
    this.buttonLogoutStatus = false;
    this.logoutService.onLogout().subscribe(() => {
      setTimeout(()=>{
        this.router.navigateByUrl("/login").then(() => {
          this.toastrService.success("Đăng xuất thành công!")
          this.buttonLogoutStatus = true;
          this.totalProductInCart = 0;
        })
        this.infoStatus = true;
        this.sendMessage();
      }, 2000)
    }, error => {
      setTimeout(()=>{
        this.router.navigateByUrl("/login").then(() => {
          this.toastrService.warning("Có vẻ như bạn đã hết phiên đăng nhập. Vui lòng đăng nhập lại!")
          this.buttonLogoutStatus = true;
        })
        this.infoStatus = true;
        this.sendMessage();
      }, 2000)
      this.router.navigateByUrl("/loading").then(() => {
      })
    }, () => {
    });
  }

  ngOnDestroy(): void {
    this.subscriptionName.unsubscribe();
  }

  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }

  getProductInCardByCustomer(customer: Customer) {
    this.totalProductInCart = 0;
    this.orderService.getProductInCardByCustomer(customer).subscribe((pos: Order[]) => {
      // console.log(pos)
      if (pos != null) {
        this.productOrders = pos;
        for (let i = 0; i < pos.length; i++) {
          this.totalProductInCart += pos[i].quantity;
        }
      } else {
        this.productOrders = [];
      }
    });
  }
}
