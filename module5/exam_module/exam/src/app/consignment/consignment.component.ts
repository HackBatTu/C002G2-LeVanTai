import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Consignment} from '../model/consignment';
import {ConsignmentService} from '../service/consignment.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-consigment',
  templateUrl: './consignment.component.html',
  styleUrls: ['./consignment.component.css']
})
export class ConsignmentComponent implements OnInit {
  consignment: Consignment[] = [];
  p = 1;
  searchForm: FormGroup;
  totalPages: number;
  number: number;
  countTotalPages: number[];

  constructor(private consignmentService: ConsignmentService, private router: Router, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAll(0);
    this.searchForm = new FormGroup({
      searchName: new FormControl(),
      searchDateCheckOut: new FormControl(),
      searchStartDate: new FormControl(),
      searchEndDate: new FormControl()
    });
  }
  getAll(page: number) {
    this.consignmentService.getAll(page).subscribe((data: Consignment[]) => {
      // @ts-ignore
      this.totalPages = data.totalPages;
      // @ts-ignore
      this.countTotalPages = new Array(data.totalPages);
      // @ts-ignore
      this.number = data.number;
      // @ts-ignore
      this.consignments = data.content;
    });
  }

  getSearch() {
    // @ts-ignore
    this.consignmentService.consignmentListBySearch(this.searchForm.value).subscribe((value: Consignment[]) => {
      this.consignment = value;
    }, error => {
    }, () => {
    });
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
      this.getAll(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAll(numberPage);
    }
  }

  goItem(i: number) {
    this.getAll(i);
  }
}
