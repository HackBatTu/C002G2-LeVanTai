import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {CookieService} from '../../login/service/cookie.service';
import {ToastrService} from 'ngx-toastr';
import {LogoutService} from '../../login/service/logout.service';
import {Router} from '@angular/router';
import {CommonService} from '../../login/service/common.service';
import {Order} from "../../model/order";
import {Customer} from "../../model/customer";
import {OrderService} from "../../service/order.service";
import {CustomerService} from "../../service/customer.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  role: string = '';
  username: string = '';
  token: string = '';
  messageReceived: any;
  private subscriptionName: Subscription;
  totalProductInCart: number = 0;
  productOrders: Order[] = [];
  customer: Customer;
  public infoStatus: boolean = false;

  constructor(private cookieService: CookieService,
              private toastrService: ToastrService,
              private logoutService: LogoutService,
              private router: Router,
              private commonService: CommonService,
              private orderService: OrderService,
              private customerService: CustomerService) {
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    this.getCustomerByUsername(this.username);
    // subscribe to sender component messages
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
      this.role = this.readCookieService('role');
      this.username = this.readCookieService('username');
      this.token = this.readCookieService('jwToken');
      this.getCustomerByUsername(this.username);
    });
  }

  ngOnInit(): void {
    this.getCustomerByUsername(this.username)
  }

  /**
   * @param key
   */
  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  onLogout() {
    setTimeout(()=> {
      if (this.cookieService.getCookie('jwToken') != null) {
        this.logoutService.onLogout(this.cookieService.getCookie('jwToken')).subscribe(() => {
          this.cookieService.deleteAllCookies();
          this.cookieService.removeAllCookies();
        }, error => {
          switch (error.error) {
            case 'isLogout':
              this.toastrService.warning('Bạn chưa đăng nhập!');
              break;
            case 'LoginExpired':
              this.cookieService.deleteAllCookies();
              this.router.navigateByUrl('/login').then(() => {
                this.toastrService.warning('Hết phiên đăng nhập vui lòng đăng nhập lại!');
                this.sendMessage();
              });
              break;
            default:
              this.cookieService.deleteAllCookies();
              this.cookieService.removeAllCookies();
              this.router.navigateByUrl('/login').then(() => {
                this.toastrService.warning('Hết phiên đăng nhập vui lòng đăng nhập lại!');
                this.sendMessage();
              });
              break;
          }
        }, () => {
          this.router.navigateByUrl('/login').then(() => {
            this.toastrService.success('Đăng xuất thành công!');
            this.sendMessage();
            this.cookieService.deleteAllCookies();
            this.cookieService.removeAllCookies();
            this.totalProductInCart = 0;
          });
        });
      } else {
        this.toastrService.warning('Bạn chưa đăng nhập!');
      }
    }, 1000)
    this.router.navigateByUrl("/loading").then(() => {
    })
  }

  ngOnDestroy(): void {
    this.subscriptionName.unsubscribe();
  }

  sendMessage(): void {
    // send message to subscribers via observable subject
    this.commonService.sendUpdate('Đăng Xuất thành công!');
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

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe((value: Customer) => {
      if (value == null) {
        this.infoStatus = true;
      } else {
        this.getProductInCardByCustomer(value);
        this.infoStatus = value.appUser.isDeleted;
        // this.avatar = value.image;
        // this.name = value.name;
      }
    });
  }
}
