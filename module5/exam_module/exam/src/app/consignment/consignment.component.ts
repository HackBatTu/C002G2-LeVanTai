import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Consignment} from '../model/consignment';
import {ConsignmentService} from '../service/consignment.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-consignment',
  templateUrl: './consignment.component.html',
  styleUrls: ['./consignment.component.css']
})
export class ConsignmentComponent implements OnInit {
  consignment: Consignment[] = [];
  searchForm: FormGroup;
  totalPages: number;
  number: number;
  countTotalPages: number[];

  constructor(private consignmentService: ConsignmentService, private router: Router, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAll(0, '', '', '0001-01-01', '8000-01-01');
    this.searchForm = new FormGroup({
      searchName: new FormControl(),
      searchDateCheckOut: new FormControl(),
      searchStartDate: new FormControl(),
      searchEndDate: new FormControl()
    });
  }

  getAll(page: number, searchName, searchDateCheckOut, searchStartDate, searchEndDate) {
    this.consignmentService.getAll(page, searchName, searchDateCheckOut, searchStartDate, searchEndDate)
      .subscribe((data: Consignment[]) => {
        if (data != null) {
          // @ts-ignore
          this.consignment = data.content;
        } else {
          this.consignment = [];
        }
        if (this.consignment.length !== 0) {
          // @ts-ignore
          this.totalPages = data.totalPages;
          // @ts-ignore
          this.countTotalPages = new Array(data.totalPages);
          // @ts-ignore
          this.number = data.number;
        }
      });
  }

  getSearch() {
    const productName = this.searchForm.value.searchName;
    const dateCheckOut = this.searchForm.value.searchDateCheckOut;
    const startDate = this.searchForm.value.searchStartDate;
    const endDate = this.searchForm.value.searchEndDate;
    this.getAll(0, productName, dateCheckOut, startDate, endDate);
  }

  deleteConsignment(id: number) {
    this.consignmentService.deleteConsignment(id).subscribe(data => {
    }, error => {
    }, () => {

      this.ngOnInit();
      this.router.navigateByUrl('/list').then(() => {
        this.toastr.error('deleted', 'SOS!!!');
      });
    });
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAll(numberPage, '', '', '0001-01-01', '3000-01-01');
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAll(numberPage, '', '', '0001-01-01', '3000-01-01');
    }
  }

  goItem(i: number) {
    this.getAll(i, '', '', '0001-01-01', '3000-01-01');
  }
}
