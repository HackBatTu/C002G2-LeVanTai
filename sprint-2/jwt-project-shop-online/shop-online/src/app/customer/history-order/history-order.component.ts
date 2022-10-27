import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Customer} from "../../model/customer";
import {Order} from "../../model/order";

import html2canvas from "html2canvas";
import {jsPDF} from "jspdf";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {CommonService} from "../../service/security/common.service";
import {CustomerService} from "../../service/customer/customer.service";
import {StatisticalService} from "../../service/statistical/statistical.service";

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
  totalPages: number;
  number: number;
  size: number;
  countTotalPages: number[];
  constructor(
              private commonService: CommonService,
              private customerService: CustomerService,
              private statisticalService: StatisticalService,
              private toast: ToastrService,
             private title: Title) {
    this.title.setTitle("Lịch Sử Mua Hàng")
  }


  ngOnInit(): void {
    this.getCustomerByUsername(this.username)

  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      console.log(value)
      this.customer = value;
      this.getListCustomer(0,this.customer)
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
        this.totalMoney += ((data[i].product.price - (data[i].product.price * (data[i].product.discount / 100))) * data[i].quantity);
      }
    }, error => {
    });
  }

  generatePDF2(id: number) {
    this.toggleLoading();
    let data = document.getElementById('pdf2'+ id);
    html2canvas(data).then(canvas => {
      const contentDataURL = canvas.toDataURL('image/png')
      // @ts-ignore
      let doc = new jsPDF('p', 'pt', 'a4');
      let position = 0;
      // @ts-ignore
      const imgProps = doc.getImageProperties(canvas);
      const pdfWidth = doc.internal.pageSize.getWidth();
      const pdfHeight = (imgProps.height * pdfWidth * 0.98) / imgProps.width;

      doc.addImage(contentDataURL, 'PNG', 0, 0, pdfWidth, pdfHeight);
      doc.save('History-FateShop by-' + this.username + '.pdf');
      this.toast.success("Xuất File Lịch Sử Của Bạn Thành Công!", "Thông Báo");
    });
  }

  getListCustomer(page: number,customer: Customer){
    // @ts-ignore
    this.statisticalService.getOrderByCustomer(page,customer).subscribe((pos: Order[]) => {
      if (pos != null) {
        // @ts-ignore
        this.productOrders = pos.content;
      } else {
        this.productOrders = [];
      }
      if (this.productOrders.length !== 0) {
        // @ts-ignore
        this.totalPages = pos.totalPages;
        // @ts-ignore
        this.size = pos.size;
        // @ts-ignore
        this.countTotalPages = new Array(pos.totalPages);
        // @ts-ignore
        this.number = pos.number;
      }
    })
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getListCustomer(numberPage,this.customer);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getListCustomer(numberPage,this.customer);

    }
  }

  goItem(i: number) {
    this.getListCustomer(i,this.customer);

  }
}
