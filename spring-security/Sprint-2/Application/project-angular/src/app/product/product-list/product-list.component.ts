import {Component, OnDestroy, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Category} from '../model/category';
import {CategoryService} from '../service/category.service';
import {AuthService} from '../../user/service/auth.service';
import {ProductOrder} from '../model/productOrder';
import {Customer} from '../../user/model/customer';
import {CustomerService} from '../../user/service/customer.service';
import {CartService} from '../../user/service/cart.service';
import {CommonService} from '../../user/service/common.service';
import {FormControl, FormGroup} from '@angular/forms';
import {OriginDto} from '../model/originDto';

declare var $: any;

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit, OnDestroy {
  products: Product[] = [];
  categories: Category[] = [];
  public role: string;
  public username: string = '';
  public loginStatus: any;
  public totalProducts: number;
  customer: Customer;
  public infoStatus: boolean = true;
  searchByNameForm: FormGroup;
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
  sortTitle: string = 'Sắp xếp theo';
  totalPages: number = 0;
  currentPage: number = 0;

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router,
              private authService: AuthService,
              private toastrService: ToastrService,
              private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private cartService: CartService,
              private commonService: CommonService) {
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
    $('#product-list').attr('class', 'nav-item nav-link active');
    this.authService.checkLogin().subscribe(value => {
      this.loginStatus = value;
      if (value) {
        this.authService.getRoles().subscribe(resp => {
          this.getCustomerByUsername(resp.username);
          this.getRole(resp);
        }, error => {
        });
      } else {

      }
    }, error => {
    });
    this.createSearchByNameForm();
    this.getAllCategories();
    this.activatedRoute.paramMap.subscribe(value => {
      if (value.get('id') != null) {
        this.loadProductByCategory(value.get('id'));
      } else {
        this.loadProductByCategory('');
      }
      if (value.get('name') != null) {
        this.getAllProductPage(this.currentPage, this.categoryId, value.get('name'), this.beginPrice, this.endPrice, this.originName, this.sort);
      }
    });
    this.sendMessage();
  }

  getAllCategories() {
    this.categoryService.getAllCategoriesList().subscribe(value => {
      // @ts-ignore
      this.categories = value;
    });
  }

  getAllProductPage(pageNumber: number, categoryId: string, productName: string, beginPrice: string, endPrice: string, originName: string, sort: string) {
    this.productService.getAllPageProducts(pageNumber, categoryId, productName, beginPrice, endPrice, originName, sort).subscribe((value: any) => {
      if (value != null) {
        if (value.totalElements >= 0) {
          this.totalPages = value.totalPages;
          this.currentPage = value.number;
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
        this.totalProducts = value.length;
        if (this.totalProductsFilter == undefined) {
          this.totalProductsFilter = value.length;
        }
      } else {
        this.totalProducts = 0;
      }
    });
  }

  ngOnDestroy(): void {
    $('#product-list').attr('class', 'nav-item nav-link');
  }

  loadProductByCategory(id: string) {
    this.categoryId = id;
    this.searchByName();
    $('[data-toggle="reset-active-category"]').attr('class', 'nav-item nav-link');
    $('#category' + id).attr('class', 'nav-item nav-link active');
    this.getTotalFilterPrice(id);
  }

  addToCart(product: Product) {
    let productOrder: ProductOrder = {
      customer: this.customer,
      product: product,
      quantity: 1
    };
    this.cartService.addOrder(productOrder).subscribe((po: ProductOrder) => {
      this.toastrService.success('Thêm thành công sản phẩm ' + po.product.name);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'quantity') {
        this.toastrService.warning('Bạn đã thêm vượt quá số lượng sản phẩm!');
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
    let productName;
    if (this.searchByNameForm.value.productName != null) {
      productName = this.searchByNameForm.value.productName;
    } else {
      productName = '';
    }
    this.productName = productName;
    this.getAllProductPage(0, this.categoryId, productName, this.beginPrice, this.endPrice, this.originName, this.sort);
  }

  resetSearchForm() {
    this.searchByNameForm.reset();
    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, this.sort);
  }

  closeModal(id: number) {
    $('#exampleModalDelete' + id).modal('hide');
  }


  deleteProduct(product: Product) {
    this.productService.deleteProduct(product.id).subscribe(value => {
      this.ngOnInit();
      $('#exampleModalDelete' + product.id).modal('hide');
      this.toastrService.success('Xóa thành công sản phẩm ' + product.name);
    });
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
    this.productService.getAllPageProducts(this.currentPage, categoryId, '', '1000001', '3000000', '', this.sort).subscribe((value: any) => {
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
    this.sort = sortValue;
    this.sortTitle = "Ngày phát hành"
    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, sortValue);
  }

  sortByPriceDESC(sortValue: string) {
    this.sort = sortValue;
    this.sortTitle = "Giá cao đến thấp"
    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, sortValue);
  }

  sortByPriceASC(sortValue: string) {
    this.sort = sortValue;
    this.sortTitle = "Giá thấp đến cao"
    this.getAllProductPage(0, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, sortValue);
  }

  goPrevious() {
    if (this.currentPage > 0) {
      this.currentPage--;
    }
    this.getAllProductPage(this.currentPage, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, this.sort);
  }

  goNext() {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++;
    }
    this.getAllProductPage(this.currentPage, this.categoryId, this.productName, this.beginPrice, this.endPrice, this.originName, this.sort);
  }
}
