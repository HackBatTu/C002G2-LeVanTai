import {Component, OnInit} from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor() {
    render({
      id: 'myPaypalButtons',
      currency: 'USD',
      value: '100.00',
      onApprove: (details) => {
        alert('Transaction Successful');
      },
      // createOrder: (details) => {
      //   alert('Transaction Successful');
      // }
    });
  }

  ngOnInit(): void {
  }

}
