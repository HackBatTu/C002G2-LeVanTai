import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {Customer} from "../../model/customer";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../login/service/auth.service";
import {ToastrService} from "ngx-toastr";
import {CustomerService} from "../../service/customer.service";
import {OrderService} from "../../service/order.service";
import {CommonService} from "../../login/service/common.service";
import {Order} from "../../model/order";
import {CookieService} from "../../login/service/cookie.service";
import {Subscription} from "rxjs";
import {FormControl, FormGroup} from "@angular/forms";
import {OriginDto} from "../../model/origin-dto";

declare var $: any;

@Component({
  selector: 'app-all-product',
  templateUrl: './all-product.component.html',
  styleUrls: ['./all-product.component.css']
})
export class AllProductComponent implements OnInit {
  products: Product[] = [];
  categories: Category[] = [];
  public role: string;
  public username: string = '';
  public token: string;
  public loginStatus: any;
  public totalProducts: number;
  customer: Customer;
  public infoStatus: boolean = true;
  searchByNameForm: FormGroup;
  messageReceived: any;
  private subscriptionName: Subscription;
  categoryId: string = '';
  beginPrice: string = '0';
  endPrice: string = '400000000000';
  originDtos: OriginDto[] = [];
  public totalProductsFilter: number;
  public originName = '';
  public productName = '';
  public totalOneMi: number = 0;
  public totalThreeMi: number = 0;
  public totalFiveMi: number = 0;
  public totalTenMi: number = 0;
  public totalLetThanTenMi: number = 0;
  sort: string = 'id';
  constructor(private productService: ProductService,
              private router: Router,
              private cookieService: CookieService,
              private toastrService: ToastrService,
              private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private orderService: OrderService,
              private commonService: CommonService,
              private authService: AuthService,) {
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    // subscribe to sender component messages
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
      this.role = this.readCookieService('role');
      this.username = this.readCookieService('username');
      this.token = this.readCookieService('jwToken');
    });
  }
  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }
  ngOnInit(): void {
    // $('#product-list').attr('class', 'nav-item nav-link active');
    // this.authService.checkLogin().subscribe(value => {
    //   this.loginStatus = value;
    //   if (value) {
    //     this.authService.getRoles().subscribe(resp => {
          this.getCustomerByUsername(this.username);
    //       this.getRole(resp);
    //     }, error => {
    //     });
    //   } else {
    //
    //   }
    // }, error => {
    // });
    this.getAllCategories();
    this.activatedRoute.paramMap.subscribe(value => {
      if (value.get('id') != null) {
        this.loadProductByCategory(value.get('id'));
      } else {
        this.loadProductByCategory('');
      }
    });
    this.sendMessage();
    this.createSearchByNameForm();
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

  getAllCategories() {
    this.productService.getAllCategory().subscribe(value => {
      // @ts-ignore
      this.categories = value;
    });
    this.getAllProductPage(0,this.categoryId,'','0','200000000','',this.sort)
  }

  getAllProductPage(pageNumber: number, categoryId: string, productName: string, beginPrice: string, endPrice: string, originName: string, sort: string) {
    this.productService.getAllPageProducts(pageNumber, categoryId, productName, beginPrice, endPrice, originName, sort).subscribe((value: any) => {
      if (value != null) {
        if (value.totalElements >= 0) {
          this.products = value.content;
          this.totalProductsFilter = value.content.length;
          if (originName == '') {
            this.originDtos = [];
          }
          for (let i = 0; i < value.content.length; i++) {
            let o = {
              name: value.content[i].origin,
              quantity: 1
            };
            this.originDtos.push(o);
          }
          for (let i = 0; i < this.originDtos.length; i++) {
            for (let j = i + 1; j < this.originDtos.length; j++) {
              if (this.originDtos[i].name == this.originDtos[j].name) {
                if (this.originDtos[i].name != originName) {
                  this.originDtos[i].quantity = this.originDtos[i].quantity + 1;
                }
                this.originDtos.splice(j, 1);
                j--;
              }
            }
          }
        }
      } else {
        this.products = [];
      }
    });
    this.productService.getAllListProducts().subscribe(value => {
      if (value != null) {
        // @ts-ignore
        this.totalProducts = value.length;
        if (this.totalProductsFilter == undefined) {
          // @ts-ignore
          this.totalProductsFilter = value.length;
        }
      } else {
        this.totalProducts = 0;
      }
    });
  }


  loadProductByCategory(id: string) {
    this.categoryId = id;
    this.searchByName();
    $('[data-toggle="reset-active-category"]').attr('class', 'nav-item nav-link');
    $('#category' + id).attr('class', 'nav-item nav-link active');
    this.getTotalFilterPrice(id);
  }

  addToCart(product: Product) {
    let order: Order = {
      customer: this.customer,
      product: product,
      quantity: 1
    };
    this.orderService.addOrder(order).subscribe((po: Order) => {
      this.toastrService.success('Thêm thành công sản phẩm ' + po.product.name);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'quantity') {
        this.toastrService.warning('Bạn đã thêm vượt quá số lượng sản phẩm!');
      }
    });
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      this.customer = value;
      if (value == null) {
        this.infoStatus = false;
      } else {
        this.infoStatus = value.appUser.isDeleted;
      }
    });
  }

  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }

  addToCartMessage() {
    this.toastrService.warning('Vui lòng đăng nhập để thực hiện chức năng này!');
  }

  updateInfoMessage() {
    this.router.navigateByUrl('/checkout').then(value => {
      this.toastrService.warning('Vui lòng cập nhật thông tin!');
    });
  }

  createSearchByNameForm() {
    this.searchByNameForm = new FormGroup({
      productName: new FormControl()
    });
  }

  searchByName() {
    const productName = this.searchByNameForm.value.productName
    this.getAllProductPage(0, this.categoryId, productName, this.beginPrice, this.endPrice, this.originName, this.sort);
  }

  resetSearchForm() {
    this.searchByNameForm.reset();
    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, this.sort);
  }

  closeModal(id: number) {
    $('#exampleModalDelete' + id).modal('hide');
  }


  deleteProduct(id: number) {
    // @ts-ignore
    this.productService.deleteProduct(id).subscribe(value => {
      // @ts-ignore
      $('#exampleModal' + id).modal('hide');
      this.toastrService.success('Xóa thành công !!!', 'SOS!!!');
      this.ngOnInit();
      this.router.navigateByUrl('/home').then();
    }, error => {
    }, () => {
    })
  }

  filterPrice(begin: string, end: string) {
    this.beginPrice = begin;
    this.endPrice = end;
    this.getAllProductPage(0, this.categoryId, this.productName, begin, end, this.originName, this.sort);
  }

  filterOrigin(originName: string) {
    this.originName = originName;
    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, originName, this.sort);
  }

  getTotalFilterPrice(categoryId: string) {
    this.productService.getAllPageProducts(0, categoryId, '', '0', '1000000', '', this.sort).subscribe((value: any) => {
      if (value != null) {
        this.totalOneMi = value.content.length;
      } else {
        this.totalOneMi = 0;
      }
    });
    this.productService.getAllPageProducts(0, categoryId, '', '1000001', '3000000', '', this.sort).subscribe((value: any) => {
      if (value != null) {
        this.totalThreeMi = value.content.length;
      } else {
        this.totalThreeMi = 0;
      }
    });
    this.productService.getAllPageProducts(0, categoryId, '', '3000001', '5000000', '', this.sort).subscribe((value: any) => {
      if (value != null) {
        this.totalFiveMi = value.content.length;
      } else {
        this.totalFiveMi = 0;
      }
    });
    this.productService.getAllPageProducts(0, categoryId, '', '5000001', '10000000', '', this.sort).subscribe((value: any) => {
      if (value != null) {
        this.totalTenMi = value.content.length;
      } else {
        this.totalTenMi = 0;
      }
    });

    this.productService.getAllPageProducts(0, categoryId, '', '10000000', '400000000000', '', this.sort).subscribe((value: any) => {
      if (value != null) {
        this.totalLetThanTenMi = value.content.length;
      } else {
        this.totalLetThanTenMi = 0;
      }
    });
  }

  sortByDate(sortValue: string) {

    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, sortValue);
  }

  sortByPriceDESC(sortValue: string) {
    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, sortValue);
  }

  sortByPriceASC(sortValue: string) {
    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, sortValue);
  }
}
