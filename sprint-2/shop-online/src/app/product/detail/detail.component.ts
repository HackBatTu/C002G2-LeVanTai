import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  product: Product[] = [];
  constructor() { }

  ngOnInit(): void {
  }

}
