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
  consigment: Consignment[] = [];
  p: number = 1;
  searchForm: FormGroup;


  constructor(private consigmentService: ConsignmentService, private router: Router, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.consigmentService.getAll().subscribe(data => {
      this.consigment = data;
    }, error => {
    });
    this.searchForm = new FormGroup({
      searchName: new FormControl(''),
      searchDateCheckOut: new FormControl('')
    });
  }


  getSearch() {
    this.consigmentService.consignmentListBySearch(this.searchForm.value.searchName, this.searchForm.value.searchDateCheckOut).subscribe(data => {
      this.consigment = data;
      console.log(data);
    }, error => {
    }, () => {
    });
  }

  deleteConsignment(id: number) {
    this.consigmentService.deleteConsignment(id).subscribe(data => {
    }, error => {
    }, () => {

      this.ngOnInit();
      this.router.navigateByUrl('/list').then(() => {
        this.toastr.error('deleted', 'SOS!!!');
      });
    });
  }
}
