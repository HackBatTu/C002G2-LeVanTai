import { Component, OnInit } from '@angular/core';
import {DateUtilService} from "../service/date-util.service";

@Component({
  selector: 'app-timelines',
  templateUrl: './timelines.component.html',
  styleUrls: ['./timelines.component.css']
})
export class TimelinesComponent implements OnInit {

  constructor(private dateUtilService: DateUtilService) { }

  ngOnInit(): void {
  }
  output = '';
  onChange(value: string) {
    this.output = this.dateUtilService.getDiffToNow(value);  }
}
