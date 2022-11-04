import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';
import {AuthService} from '../../user/service/auth.service';
import {ToastrService} from 'ngx-toastr';
import {ProductOrder} from '../model/productOrder';
import {Customer} from '../../user/model/customer';
import {CustomerService} from '../../user/service/customer.service';
import {CartService} from '../../user/service/cart.service';
import {CommonService} from '../../user/service/common.service';

declare var $: any;

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  product: Product;
  public role: string;
  public username: string = '';
  public loginStatus: any;
  choiceQuantity: number = 1;
  customer: Customer;
  public maximumQuantity: number = 1;
  public infoStatus: boolean = true;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private authService: AuthService,
              private customerService: CustomerService,
              private toastrService: ToastrService,
              private cartService: CartService,
              private commonService: CommonService,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe(value => {
      this.findProductById(value.get('id'));
    });
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
    this.sendMessage();
  }

  findProductById(id: string) {
    this.productService.findProductById(id).subscribe(value => {
      this.product = value;
    });
  }

  minusQuantity() {
    if (this.choiceQuantity > 1) {
      this.choiceQuantity--;
    } else {
      this.toastrService.warning('Thêm tối thiếu 1 sản phẩm.');
    }
  }

  plusQuantity(product: Product) {
    if (this.choiceQuantity < product.quantity) {
      this.choiceQuantity++;
    } else {
      this.toastrService.warning('Số lượng sản phẩm đã tối đa.');
    }
  }

  addToCart(product: Product) {
    let productOrder: ProductOrder = {
      customer: this.customer,
      product: product,
      quantity: this.choiceQuantity
    };
    this.cartService.addOrder(productOrder).subscribe((po: ProductOrder) => {
      this.toastrService.success('Thêm thành công sản phẩm ' + po.product.name);
      this.sendMessage();
    }, error => {
      this.maximumQuantity = error.error.productOrder.product.quantity - error.error.productOrder.quantity;
      if (error.error.message == 'quantity') {
        if (this.maximumQuantity > 0) {
          this.toastrService.warning('Bạn chỉ có thể thêm tối đa ' + (this.maximumQuantity) + ' sản phẩm');
        } else {
          this.toastrService.warning('Sản phẩm đã tối đa vui lòng kiểm tra giỏ hàng.');
        }
      }
    });
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUsername(username).subscribe(value => {
      this.customer = value;
      if (value == null) {
        this.infoStatus = false;
      } else {
        this.infoStatus = value.appUser.status;
      }
    });
  }

  maximumProductInCart() {
    this.toastrService.warning('Sản phẩm đã tối đa vui lòng kiểm tra giỏ hàng.');
  }

  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }

  addToCartMessage() {
    this.toastrService.warning("Vui lòng đăng nhập để thực hiện chức năng này!");
  }

  updateInfoMessage() {
    this.router.navigateByUrl("/checkout").then(value => {
      this.toastrService.warning("Vui lòng cập nhật thông tin!");
    })
  }

  deleteProduct(product: Product) {
    this.productService.deleteProduct(product.id).subscribe(() => {
      this.router.navigateByUrl("/product/list").then(() => {
        $('#exampleModalDelete' + product.id).modal('hide');
        this.toastrService.success("Xóa thành công sản phẩm " + product.name);
      })
    });
  }
}
