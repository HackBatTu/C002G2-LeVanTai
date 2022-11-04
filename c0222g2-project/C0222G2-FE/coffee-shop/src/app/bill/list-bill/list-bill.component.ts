import {Component, OnInit} from '@angular/core';
import {Bill} from "../model/bill";
import {AbstractControl, FormControl, FormGroup} from "@angular/forms";
import {BillService} from "../service/bill.service";
import {ToastrService} from "ngx-toastr";
import html2canvas from 'html2canvas';
import {jsPDF} from 'jspdf';
import {formatDate} from "@angular/common";
import {Title} from "@angular/platform-browser";


@Component({
  selector: 'app-list-bill',
  templateUrl: './list-bill.component.html',
  styleUrls: ['./list-bill.component.css']
})
export class ListBillComponent implements OnInit {
  bills: Bill[] = [];
  dishs: Bill[] = [];
  searchForm: FormGroup;
  p: number = 0;
  totalPages: number;
  number: number;
  countTotalPages: number[];
  code: string;
  creationDate: string;
  billFormReactive: FormGroup;
  size: number;
  isLoading: Boolean = false;
  billCode: Boolean = false;
  formPage: FormGroup;
  pageSearch: number;


  constructor(private billService: BillService,
              private toastrService: ToastrService,
              private title: Title) {
    this.title.setTitle("Danh sách hóa đơn")

    this.billFormReactive = new FormGroup({
      creationDate: new FormControl()
    })
  }

  ngOnInit(): void {
    this.getAllBill(0, this.code, this.creationDate);
    this.searchForm = new FormGroup({
      searchCode: new FormControl(''),
      searchDate: new FormControl('', this.checkDate),
    });
    this.formPage = new FormGroup({
      pageForm: new FormControl('')
    });
  }

  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: get error
   */

  get searchDate() {
    return this.searchForm.get('searchDate')
  };


  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: Get bill list, with pagination,search by bill number and creation date
   *
   * @param page
   * @param searchCode
   * @param searchDate
   */

  getAllBill(page: number, searchCode: string, searchDate: string) {
    this.billService.getAllBill(page, searchCode, searchDate).subscribe((data: Bill[]) => {
      if (data != null) {
        // @ts-ignore
        this.bills = data.content
      } else {
        this.bills = [];
      }
      if (this.bills.length !== 0) {
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.countTotalPages = new Array(data.totalPages);
        // @ts-ignore
        this.number = data.number;
        // @ts-ignore
        this.size = data.size
      }
    });
  }

  /**
   *
   * Created by: HauLT
   * Date created: 17/08/2022
   * function: Get dish list
   * @param id
   */

  getAllDish(id: number) {
    // @ts-ignore
    this.billService.getAllDish(id).subscribe((data: Bill[]) => {
      this.dishs = data
      console.log(data)
    }, error => {
    });
  }

  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: Get bill list, with pagination,search by bill number and creation date
   *
   */


  getFormSearch() {
    this.searchForm.value.searchCode = this.searchForm.value.searchCode.trim();
    console.log(this.searchForm.value)
    if (this.searchForm.value.searchCode === '') {
      this.code = '';
      this.billCode = false
    } else {
      if (this.searchForm.value.searchCode.search(["#+&%"]) >= 0) {
        this.billCode = true;
        this.code = this.searchForm.value.searchCode;
      } else {
        this.billCode = false;
        this.code = this.searchForm.value.searchCode;
      }
    }
    if (this.searchForm.value.searchDate === '') {
      this.creationDate = '';
    } else {
      this.creationDate = this.searchForm.value.searchDate
    }
    this.getAllBill(0, this.code, this.creationDate)
  }

  /**
   * Created by: HauLT
   * Date created: 17/08/2022
   * function: toggleLoading, set timeout
   */

  toggleLoading() {
    this.isLoading = true;
    setTimeout(() => {
      this.isLoading = false;
    }, 4000)
  }


  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: previous page switch button
   */

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAllBill(numberPage, this.code, this.creationDate);
    }
  }

  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: next page switch button
   */

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllBill(numberPage, this.code, this.creationDate);
    }
  }

  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: page switch button
   */

  goItem(i: number) {
    this.getAllBill(i, "", "");
  }


  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: export invoice to pdf file
   * @param id
   * @param code
   */

  generatePDF(id, code) {
    this.toggleLoading();
    let data = document.getElementById('contentToConvert' + id);
    html2canvas(data).then(canvas => {
      const contentDataURL = canvas.toDataURL('image/png')
      // @ts-ignore
      let doc = new jsPDF('p', 'pt', 'a4');
      let position = 0;
      // @ts-ignore
      doc.addImage(contentDataURL, 0, 0,600,600);
      doc.save('Bill-' + code + '.pdf');
      this.toastrService.success("Xuất Hóa Đơn Thành Công!", "Thông Báo");
    });
  }

  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: validate date
   * @param creationDate
   */

  checkDate(creationDate: AbstractControl) {
    const value = creationDate.value;
    const curDate = formatDate(new Date(), 'yyyy-mm-yy', 'en-US')
    if (value >= curDate) {
      return {'checkDate': true}
    }
    return null;
  }


  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: get id
   * @param id
   */
  getBillId(id: number) {
    this.getAllDish(id);
  }

  goStart() {
    this.getAllBill(0, this.code, this.creationDate);
  }

  goEnd() {
    this.getAllBill(this.totalPages - 1, this.code, this.creationDate);
  }

  searchPageCurrent() {
    this.pageSearch = parseInt(this.formPage.value.pageForm.trim());
    if (this.pageSearch > 0 && this.pageSearch <= this.totalPages) {
      this.getAllBill(this.pageSearch - 1, this.code, this.creationDate);
    } else {
      // @ts-ignore
      this.toastrService.error("Trang bạn tìm không tồn tại", "", 100);
      this.getAllBill(0, this.code, this.creationDate);
    }
  }
}

