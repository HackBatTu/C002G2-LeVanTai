import { Component, OnInit } from '@angular/core';
import {Order} from "../../model/order";
import {Subscription} from "rxjs";
import {FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {StatisticalService} from "../../service/statistical/statistical.service";
import {CommonService} from "../../service/security/common.service";

@Component({
  selector: 'app-yesterday-history',
  templateUrl: './yesterday-history.component.html',
  styleUrls: ['./yesterday-history.component.css']
})
export class YesterdayHistoryComponent implements OnInit {

  order: Order[] = [];
  username: string ='';
  role: string ='';
  token: string ='';
  private subscriptionName: Subscription;
  messageReceived: any;
  searchForm: FormGroup;
  totalPages: number;
  number: number;
  countTotalPages: number[];
  size: number;
  constructor(private statisticalService: StatisticalService,
              private toast: ToastrService,
              private commonService: CommonService,
              private title: Title) {
    this.title.setTitle('Lịch Sử Giao Dịch Hôm Qua')

  }

  ngOnInit(): void {
    this.getAllOrderYesterday(0)
  }

  getAllOrderYesterday(page: number){
    this.statisticalService.getAllOrderYesterday(page).subscribe(value => {
      console.log(value)
      if(value != null){
        // @ts-ignore
        this.order = value.content
      }else {
        this.order = [];
      }
      if (this.order.length !== 0) {
        // @ts-ignore
        this.totalPages = value.totalPages;
        // @ts-ignore
        this.size = value.size;
        // @ts-ignore
        this.countTotalPages = new Array(value.totalPages);
        // @ts-ignore
        this.number = value.number;
      }
    })
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAllOrderYesterday(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllOrderYesterday(numberPage);
    }
  }

  goItem(i: number) {
    this.getAllOrderYesterday(i);
  }

}
