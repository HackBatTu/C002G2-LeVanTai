import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../user/service/auth.service';
import {Customer} from '../../user/model/customer';
import {CustomerService} from '../../user/service/customer.service';
import {CartService} from '../../user/service/cart.service';
import {ProductOrder} from '../model/productOrder';
import {ToastrService} from 'ngx-toastr';
import {CommonService} from '../../user/service/common.service';
import {render} from 'creditcardpayments/creditCardPayments';
import {Router} from '@angular/router';

declare var $: any;

@Component({
  selector: 'app-product-cart',
  templateUrl: './product-cart.component.html',
  styleUrls: ['./product-cart.component.css']
})
export class ProductCartComponent implements OnInit {
  public role: string;
  public username: string = '';
  public loginStatus: any;
  customer: Customer;
  productOrders: ProductOrder[] = [];
  totalMoney: number = 0;

  constructor(private authService: AuthService,
              private customerService: CustomerService,
              private cartService: CartService,
              private toastrService: ToastrService,
              private commonService: CommonService,
              private router: Router) {
    this.authService.checkLogin().subscribe(value => {
      this.loginStatus = value;
      if (value) {
        this.authService.getRoles().subscribe(resp => {
          this.getCustomerByUsername(resp.username);
        }, error => {
        });
      } else {

      }
    }, error => {
    });
  }

  ngOnInit(): void {
    this.sendMessage();
  }

  getProductInCardByCustomer(customer: Customer) {
    this.cartService.getProductInCardByCustomer(customer).subscribe((pos: ProductOrder[]) => {
      if (pos != null) {
        this.productOrders = pos;
        this.caculateTotalMoney(pos);
      } else {
        this.productOrders = [];
      }
    });
  }

  private caculateTotalMoney(pos: ProductOrder[]) {
    this.totalMoney = 0;
    for (let i = 0; i < pos.length; i++) {
      this.totalMoney += ((pos[i].product.price - (pos[i].product.price * (pos[i].product.category.discountPercent / 100))) - ((pos[i].product.price - (pos[i].product.price * (pos[i].product.category.discountPercent / 100))) * pos[i].product.discountPercent / 100)) * pos[i].quantity;
    }
    if (this.totalMoney >= 0) {
      render(
        {
          id: '#payments',
          currency: 'USD',
          value: String(((this.totalMoney + 50000) / 23000).toFixed(2)),
          onApprove: (details) => {
            console.log(details);
            if (details.status == 'COMPLETED') {
              this.onPaymentSuccess();
            }
          }
        }
      );
    }
  }

  onPaymentSuccess() {
    $('#exampleModalPayment').modal('hide');
    this.router.navigateByUrl('/loading').then(() => {
      this.cartService.goPayment(this.customer).subscribe(() => {
        setTimeout(() => {
          this.router.navigateByUrl("/product/list").then(() => {
            this.toastrService.success('Thanh toán thành công!');
          })
        }, 500);
      });
      this.sendMessage();
    });
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUsername(username).subscribe(value => {
      this.customer = value;
      this.getProductInCardByCustomer(value);
    });
  }

  minusQuantity(productOrder: ProductOrder) {
    this.cartService.minusQuantity(productOrder).subscribe(value => {
      this.productOrders = value;
      this.caculateTotalMoney(value);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'minimum') {

      }
    });
  }

  closeModal(id: number) {
    $('#exampleModalCenter' + id).modal('hide');
  }

  plusQuantity(productOrder: ProductOrder) {
    this.cartService.plusQuantity(productOrder).subscribe(value => {
      this.productOrders = value;
      this.caculateTotalMoney(value);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'maximum') {
        this.toastrService.warning('Số lượng sản phẩm đã tối đa.');
      }
    });
  }

  maximumQuantity() {
    this.toastrService.warning('Số lượng sản phẩm đã tối đa.');
  }

  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }

  deleteProductInCart(po: ProductOrder) {
    this.cartService.deleteProductInCard(po).subscribe((value: ProductOrder[]) => {
      this.productOrders = value;
      this.caculateTotalMoney(value);
      this.toastrService.success('Xóa thành công sản phẩm ' + po.product.name + ' khỏi giỏ hàng.');
      $('#deleteMinusModal' + po.product.id).modal('hide');
      $('#exampleModalDeleteButton' + po.product.id).modal('hide');
      this.sendMessage();
    }, error => {
      if (error.error.message == 'notfound') {
        this.toastrService.warning('Không tìm thấy sản phẩm!');
      }
    });
  }
}
