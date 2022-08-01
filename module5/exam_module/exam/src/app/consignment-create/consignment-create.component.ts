import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ConsignmentService} from '../service/consignment.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Consignment} from '../model/consignment';
import {Product} from '../model/product';

@Component({
  selector: 'app-consignment-create',
  templateUrl: './consignment-create.component.html',
  styleUrls: ['./consignment-create.component.css']
})
export class ConsignmentCreateComponent implements OnInit {
  consignmentForm: FormGroup;
  // @ts-ignore
  consignment: Consignment = {};
  product: Product[] = [];
  constructor(private consignmentService: ConsignmentService, private router: Router, private toastr: ToastrService) {
  }

  showToastr() {
    this.toastr.success('Create success', 'tittle', {timeOut: 800, progressBar: false});
  }

  ngOnInit(): void {
    this.consignmentService.getAllProduct().subscribe(data => {
      // @ts-ignore
      this.product = data;
      console.log(data);
    }, error => {
    }, () => {
      this.consignmentForm = new FormGroup({
        codeProduct: new FormControl('', [Validators.required, Validators.pattern('^(LH-)([0-9]{4})$')]),
        product: new FormControl(''),
        quantity: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{1,}')]),
        dateIn: new FormControl('', [Validators.required]),
        dateCheckIn: new FormControl('', [Validators.required]),
        dateCheckOut: new FormControl('', [Validators.required]),
      });
    });
  }

  get codeProduct() {
    return this.consignmentForm.get('codeProduct');
  }

  get quantity() {
    return this.consignmentForm.get('quantity');
  }

  get dateIn() {
    return this.consignmentForm.get('dateIn');
  }

  get dateCheckIn() {
    return this.consignmentForm.get('dateCheckIn');
  }

  get dateCheckOut() {
    return this.consignmentForm.get('dateCheckOut');
  }

  createConsignment() {
    if (this.consignmentForm.valid) {
      // tslint:disable-next-line:radix
      this.consignmentForm.value.id = parseInt(this.consignmentForm.value.id);
      this.consignmentService.createConsignment(this.consignmentForm.value).subscribe(data => {
      }, error => {
      }, () => {
      });
      this.router.navigateByUrl('list');
    }
  }
}
