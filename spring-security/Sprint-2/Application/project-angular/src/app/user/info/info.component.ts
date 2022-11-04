import {Component, OnDestroy, OnInit} from '@angular/core';
import {ProductService} from '../../product/service/product.service';
import {ToastrService} from 'ngx-toastr';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../service/auth.service';
import {CustomerService} from '../service/customer.service';
import {Customer} from '../model/customer';
import {ProductOrder} from '../../product/model/productOrder';

declare var $: any;

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit, OnDestroy {
  public role: string;
  public username: string = '';
  public loginStatus: any;
  customer: Customer;
  productOrders: ProductOrder[] = [];
  currentPage: number = 0;
  totalPages: number = 0;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private authService: AuthService,
              private customerService: CustomerService,
              private router: Router,
              private toastrService: ToastrService) {
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

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUsername(username).subscribe(value => {
      this.getOrdersByCustomer(this.currentPage, value);
      this.customer = value;
      if (value == null) {
        this.router.navigateByUrl('/checkout').then(() => {
          this.toastrService.warning('Có vẻ như bạn chưa cập nhật thông tin. Vui lòng cập nhật thông tin!');
        });
      }
    });
  }

  getOrdersByCustomer(page: number, customer: Customer) {
    this.productService.getOrdersByCustomer(page, customer).subscribe(value => {
      if (value != null) {
        this.productOrders = value.content;
        this.totalPages = value.totalPages;
        for (let i = 0; i < this.productOrders.length; i++) {
          let discountPrice = (this.productOrders[i].product.price - (this.productOrders[i].product.price * (this.productOrders[i].product.category.discountPercent / 100))) - ((this.productOrders[i].product.price - (this.productOrders[i].product.price * (this.productOrders[i].product.category.discountPercent / 100))) * this.productOrders[i].product.discountPercent / 100);
          this.productOrders[i].totalMoney = this.productOrders[i].quantity * discountPrice;
        }
      }
    });
  }

  closeModal(id: number) {
    $('#exampleModalCenter' + id).modal('hide');
  }

  goPrevious() {
    if (this.currentPage > 0) {
      this.currentPage--;
    }
    this.getOrdersByCustomer(this.currentPage, this.customer);
  }

  goNext() {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++;
    }
    this.getOrdersByCustomer(this.currentPage, this.customer);
  }
}
