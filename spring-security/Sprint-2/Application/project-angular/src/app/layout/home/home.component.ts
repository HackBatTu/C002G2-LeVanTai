import {Component, OnDestroy, OnInit} from '@angular/core';
import {CategoryService} from '../../product/service/category.service';
import {Category} from '../../product/model/category';
import {ProductService} from '../../product/service/product.service';
import {Product} from '../../product/model/product';
import {AuthService} from '../../user/service/auth.service';
import {ProductOrder} from '../../product/model/productOrder';
import {CartService} from '../../user/service/cart.service';
import {Customer} from '../../user/model/customer';
import {CustomerService} from '../../user/service/customer.service';
import {ToastrService} from 'ngx-toastr';
import {CommonService} from '../../user/service/common.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {
  categories: Category[] = [];
  newProducts: Product[] = [];
  public role: string;
  public username: string = '';
  public loginStatus: any;
  categoriesDiscount: Category[] = [];
  categorySize: number;
  categoryTotalElements: number;
  customer: Customer;
  public infoStatus: boolean = true;
  searchForm: FormGroup;

  constructor(private categoryService: CategoryService,
              private productService: ProductService,
              private authService: AuthService,
              private customerService: CustomerService,
              private toastrService: ToastrService,
              private cartService: CartService,
              private commonService: CommonService,
              private router: Router) {
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
    $('#home-page').attr('class', 'nav-item nav-link active');
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
    this.getAllCategories(3);
    this.getNewProducts();
    this.getCategoriesDiscount();
    this.sendMessage();
    this.createSearchForm();
  }

  createSearchForm() {
    this.searchForm = new FormGroup({
      name: new FormControl()
    })
  }

  getAllCategories(size: number) {
    this.categoryService.getAllCategoriesPage(size).subscribe(value => {
      // @ts-ignore
      if (value.totalElements >= 0) {
        // @ts-ignore
        this.categories = value.content;
        // @ts-ignore
        this.categorySize = value.size;
        // @ts-ignore
        this.categoryTotalElements = value.totalElements;
      }
    });
  }

  getNewProducts() {
    this.productService.getNewProducts().subscribe(value => {
      this.newProducts = value;
    });
  }

  getCategoriesDiscount() {
    this.categoryService.getCategoriesDiscount().subscribe(value => {
      this.categoriesDiscount = value;
    });
  }

  seeCategoryMore() {
    if (this.categorySize < this.categoryTotalElements) {
      this.categorySize += 3;
      this.getAllCategories(this.categorySize);
    }
  }

  ngOnDestroy(): void {
    $('#home-page').attr('class', 'nav-item nav-link');
  }

  addToCart(product: Product) {
    let productOrder: ProductOrder = {
      customer: this.customer,
      product: product,
      quantity: 1
    };
    this.cartService.addOrder(productOrder).subscribe((po: ProductOrder) => {
      this.toastrService.success("Thêm thành công sản phẩm " + po.product.name);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'quantity') {
        this.toastrService.warning("Bạn đã thêm vượt quá số lượng sản phẩm!");
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

  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }

  addToCartMessage() {
    this.toastrService.warning("Vui lòng đăng nhập để thực hiện chức năng này!")
  }

  updateInfoMessage() {
    this.router.navigateByUrl("/checkout").then(value => {
      this.toastrService.warning("Vui lòng cập nhật thông tin!");
    })
  }

  deleteProduct(product: Product) {
    this.productService.deleteProduct(product.id).subscribe(value => {
      this.ngOnInit();
      $('#exampleModalDelete' + product.id).modal('hide');
      this.toastrService.success("Xóa thành công sản phẩm " + product.name);
    });
  }

  onSearchName() {
    let name = this.searchForm.controls.name.value;
    this.router.navigate(['/product/list', name]).then(value => {
      this.searchForm.reset();
    })
  }
}
