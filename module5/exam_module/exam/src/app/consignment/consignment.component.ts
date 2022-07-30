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
  p: number = 1;
  searchForm: FormGroup;


  constructor(private consignmentService: ConsignmentService, private router: Router, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.consignmentService.getAll().subscribe(data => {
      this.consignment = data;
    }, error => {
    });
    this.searchForm = new FormGroup({
      searchName: new FormControl(),
      searchDateCheckOut: new FormControl(),
      searchStartDate: new FormControl(),
      searchEndDate: new FormControl()
    });
  }


  getSearch() {
    // @ts-ignore
    this.consignmentService.consignmentListBySearch(this.searchForm.value).subscribe(value => {
      this.consignment = value.content;
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
}
