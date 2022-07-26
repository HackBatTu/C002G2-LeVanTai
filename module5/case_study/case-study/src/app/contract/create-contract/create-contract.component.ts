import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Contract} from "../contract";

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {
  contractForm: FormGroup;
  contract: Contract = {};

  constructor() {

    this.contractForm = new FormGroup({
        id: new FormControl('',[Validators.required]),
        startDate: new FormControl('',[Validators.required]),
        endDate: new FormControl('',[Validators.required]),
        deposit: new FormControl('',[Validators.required]),
        customer: new FormControl('',[Validators.required]),
        facility: new FormControl('',[Validators.required])
      })
  }

  ngOnInit(): void {
  }

}
