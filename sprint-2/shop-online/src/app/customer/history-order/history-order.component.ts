import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Customer} from "../../model/customer";
import {Order} from "../../model/order";
import {CookieService} from "../../login/service/cookie.service";
import {CommonService} from "../../login/service/common.service";
import {CustomerService} from "../../service/customer.service";
import {ProductService} from "../../service/product.service";
import {OrderService} from "../../service/order.service";
import html2canvas from "html2canvas";
import {jsPDF} from "jspdf";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-history-order',
  templateUrl: './history-order.component.html',
  styleUrls: ['./history-order.component.css']
})
export class HistoryOrderComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';
  messageReceived: any;
  private subscriptionName: Subscription;
  customer: Customer;
  productOrders: Order[] = [];
  isLoading: Boolean = false;
  productOrderByCode:  Order[] = [];
  totalMoney: number = 0;
  constructor(private cookieService: CookieService,
              private commonService: CommonService,
              private customerService: CustomerService,
              private orderService: OrderService,
              private toast: ToastrService,
              private router: Router,
              private active: ActivatedRoute) {
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    // subscribe to sender component messages
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
      this.role = this.readCookieService('role');
      this.username = this.readCookieService('username');
      this.token = this.readCookieService('jwToken');
      this.getCustomerByUsername(this.username)
    });
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getCustomerByUsername(this.username)
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      this.customer = value;
      this.orderService.getOrderByCustomer(this.customer).subscribe((pos: Order[]) => {
        console.log(pos)
        if (pos != null) {
          // @ts-ignore
          this.productOrders = pos;
        } else {
          this.productOrders = [];
        }
      });
    });
  }
  generatePDF(username) {
    this.toggleLoading();
    let data = document.getElementById('pdf');
    html2canvas(data).then(canvas => {
      const contentDataURL = canvas.toDataURL('image/png')
      // @ts-ignore
      let doc = new jsPDF('p', 'pt', 'a4');
      let position = 0;
      // @ts-ignore
      const imgProps = doc.getImageProperties(canvas);
      const pdfWidth = doc.internal.pageSize.getWidth();
      const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;

      doc.addImage(contentDataURL, 'PNG', 0, 0, pdfWidth, pdfHeight);
      // doc.addImage(contentDataURL,0,0, 800, 600);
      doc.save('History-FateShop by-' + username + '.pdf');
      this.toast.success("Xuất File Lịch Sử Của Bạn Thành Công!", "Thông Báo");
    });
  }
  toggleLoading() {
    this.isLoading = true;
    setTimeout(() => {
      this.isLoading = false;
    }, 2600)
  }
  getBillId(id: number) {
    this.getAllProduct(id);
  }
  getAllProduct(id: number) {
    this.customerService.getProductById(id).subscribe((data: Order[]) => {
      this.productOrderByCode = data
      console.log(data)
      this.totalMoney = 0;
      for (let i = 0; i < data.length; i++) {
        // @ts-ignore
        this.totalMoney += ((pos[i].product.price - (pos[i].product.price * (pos[i].product.discount / 100))) * pos[i].quantity);
      }
    }, error => {
    });
  }

  generatePDF2(username) {
    this.toggleLoading();
    let data = document.getElementById('pdf');
    html2canvas(data).then(canvas => {
      const contentDataURL = canvas.toDataURL('image/png')
      // @ts-ignore
      let doc = new jsPDF('p', 'pt', 'a4');
      let position = 0;
      // @ts-ignore
      doc.addImage(contentDataURL, 130, 0);
      doc.save('History-FateShop by-' + username + '.pdf');
      this.toast.success("Xuất File Lịch Sử Của Bạn Thành Công!", "Thông Báo");
    });
  }
}
