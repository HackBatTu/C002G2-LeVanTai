import {Component, OnInit} from '@angular/core';
import { render} from "creditcardpayments/creditCardPayments";

declare var $: any;

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
    this.onPaypal();
  }


  onPaypal() {

    // @ts-ignore
    paypal.Buttons({
      onApprove: function (data, actions) {
        return actions.order.capture().then(function (details) {
          alert(details.payer.name.given_name + 'thanh toán thành công' + '!')
          $('#table-card').hide();
          $('#table-card-1').hide();
        })
      }
    }).render('#myPaypalButtons');
  }
}
