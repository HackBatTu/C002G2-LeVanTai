import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer";
import {Subscription} from "rxjs";
import {FormGroup} from "@angular/forms";
import {CookieService} from "../../login/service/cookie.service";
import {CommonService} from "../../login/service/common.service";
import {CustomerService} from "../../service/customer.service";
import {OrderService} from "../../service/order.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {Order} from "../../model/order";
import {StatisticalService} from "../../service/statistical.service";



@Component({
  selector: 'app-history-transaction',
  templateUrl: './history-transaction.component.html',
  styleUrls: ['./history-transaction.component.css']
})
export class HistoryTransactionComponent implements OnInit {
  order: Order[] = [];
  username: string = '';
  role: string = '';
  token: string = '';
  private subscriptionName: Subscription;
  messageReceived: any;
  searchForm: FormGroup;
  size: number;
  // pagination
  number = 0;
  pages: Array<number>;
  previousPageStyle = 'inline-block';
  nextPageStyle = 'inline-block';
  totalElements = 0;
  pageSize = 6;
  displayPagination = 'inline-block';
  numberOfElement = 0;

  constructor(private statisticalService: StatisticalService,
              private toast: ToastrService,
              private commonService: CommonService,
              private title: Title,
              private cookieService: CookieService) {
    this.title.setTitle('Lịch Sử Giao Dịch Web')
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
    this.getListOrder()
  }

  getListOrder() {
    this.statisticalService.getAllOrder(this.number, this.pageSize).subscribe(data => {
      if (data === null) {
        this.pages = new Array(0);
        this.order = [];
        this.displayPagination = 'none';
        this.toast.warning('Không có dữ liệu.', 'Chú ý');
      } else {
        // @ts-ignore
        this.numberOfElement = data.numberOfElements;
        // @ts-ignore
        this.order = data.content;
        // @ts-ignore
        this.size = data.size;
        // @ts-ignore
        this.totalElements = data.totalElements;
        // @ts-ignore
        this.pages = new Array(data.totalPages);
      }
      this.checkPreviousAndNext();
    })
  }

  previousPage(event: any) {
    event.preventDefault();
    this.number--;
    this.getListOrder()
  }

  setPage(i: number, event: any) {
    event.preventDefault();
    this.number = i;
    this.getListOrder()
  }

  nextPage(event: any) {
    event.preventDefault();
    this.number++;
    this.getListOrder()
  }

  // kiem tra hien thi nut tiep theo va truoc
  checkPreviousAndNext() {
    if (this.number === 0) {
      this.previousPageStyle = 'none';
    } else if (this.number !== 0) {
      this.previousPageStyle = 'inline-block';
    }
    if (this.number < (this.pages.length - 1)) {
      this.nextPageStyle = 'inline-block';
    } else if (this.number === (this.pages.length - 1) || this.number > (this.pages.length - 1)) {
      this.nextPageStyle = 'none';
    }
  }
  changePageSize(event: any) {
    switch (event.target.value) {
      case '5' :
        this.pageSize = 5;
        this.number = 0;
        this.getListOrder()
        break;
      case '10' :
        this.pageSize = 10;
        this.number = 0;
        this.getListOrder()
        break;
      case '12':
        this.pageSize = 12;
        this.number = 0;
        this.getListOrder()
        break;

    }
  }
  // // Modal delete
  // codeModal: string;
  // nameModal: string;
  // idModal: number;
  //
  // // search
  // nameSearchForm = new FormControl('');
  // idCardSearchForm = new FormControl('');
  // nameSearch = '';
  // idCardSearch = '';
  // searchOrder() {
  //   this.userNameSearch = this.nameSearchForm.value.trim();
  //   this.emailSearch = this.idCardSearchForm.value.trim();
  //   if (this.checkRegex(this.nameSearch, this.idCardSearch)) {
  //     this.number = 0;
  //     this.pages = new Array(0);
  //     this.order = [];
  //     this.displayPagination = 'none';
  //     this.checkPreviousAndNext();
  //     this.toast.warning('Không được nhập kí tự đặc biệt.', 'Chú ý');
  //   } else {
  //     this.number = 0;
  //     this.displayPagination = 'inline-block';
  //     this.getListOrder();
  //   }
  // }
  // getModal(id: number, code: string, name: string) {
  //   this.codeModal = code;
  //   this.nameModal = name;
  //   this.idModal = id;
  // }
  //
  // deleteEmployee() {
  //   if (this.employeeList.length === 1 && this.indexPagination !== 0) {
  //     this.indexPagination = this.indexPagination - 1;
  //   }
  //   this.employeeService.deleteEmployee(this.idModal).subscribe(() => {
  //   }, error => {
  //     console.log(error);
  //   }, () => {
  //     this.toast.success('Xóa thành công', 'Thông báo');
  //     this.ngOnInit();
  //   });
  // }
  //
  // // kiểm tra nhập kí tự đặc biệt trên ô tìm kiếm.
  // checkRegex(name: string, idCard: string): boolean {
  //   const format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
  //   return format.test(name) || format.test(idCard);
  // }
}
