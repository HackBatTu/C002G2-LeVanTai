import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Product} from '../model/product';
import {Consignment} from '../model/consignment';
import {ConsignmentService} from '../service/consignment.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-consignment-edit',
  templateUrl: './consignment-edit.component.html',
  styleUrls: ['./consignment-edit.component.css']
})
export class ConsignmentEditComponent implements OnInit {
  consignmentForm: FormGroup;
  product: Product[] = [];
  consignment: Consignment = {};

  constructor(private consignmentService: ConsignmentService, private router: Router, private activatedRouter: ActivatedRoute, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.activatedRouter.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id');
      this.consignmentService.findById(parseInt(id)).subscribe(data => {
        console.log(data);
        this.consignmentService.getAllProduct().subscribe(value => {
          this.product = value;
        }, error => {
        }, () => {
          this.consignment = data,
            this.consignmentForm = new FormGroup({
              id: new FormControl(this.consignment.id, [Validators.required]),
              codeProduct: new FormControl(this.consignment.codeProduct, [Validators.required, Validators.pattern('^(LH-)([0-9]{4})$')]),
              product: new FormControl(this.consignment.product),
              quantity: new FormControl(this.consignment.quantity, [Validators.required, Validators.pattern('^[0-9]{1,}')]),
              dateIn: new FormControl(this.consignment.dateIn, [Validators.required]),
              dateCheckIn: new FormControl(this.consignment.dateCheckIn, [Validators.required]),
              dateCheckOut: new FormControl(this.consignment.dateCheckOut, [Validators.required]),
            });
        });
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

  updateConsignment() {
    const edit = this.consignmentForm.value;
    this.consignmentService.updateConsignment(edit).subscribe(data => {
    }, error => {
    }, () => {
      this.router.navigateByUrl('/list');
    });
  }

  compareProduct(c1: Product, c2: Product): boolean {
    return c1.id === c2.id;
  }

  showToastr() {
    this.toastr.success('Create success', 'tittle', {timeOut: 800, progressBar: false});

  }
}
