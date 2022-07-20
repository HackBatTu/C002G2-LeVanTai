import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1: number;
  number2: number;
  result: number;
  constructor() { }

  ngOnInit(): void {
  }

  addition() {
    return this.result = this.number1 + this.number2;
  }

  subtraction() {
    return this.result = this.number1 - this.number2;
  }

  multiplication() {
    return this.result = this.number1 * this.number2;
  }
  division() {
    return this.result = this.number1 / this.number2;
  }
}
