import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Employee} from '../../model/employee';
import {Position} from '../../model/position';
import {EmployeeService} from '../../service/employee.service';
import {Router} from '@angular/router';
import {AngularFireStorage} from '@angular/fire/storage';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  employeeForm: FormGroup;
  employee: Employee = {};
  position: Position[] = [];
  private selectedImage: any = null;

  constructor(private employeeService: EmployeeService, private router: Router, private storage: AngularFireStorage, private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllPosition();
    this.getEmployeeForm();
  }
  getEmployeeForm() {
    this.employeeForm = new FormGroup({
      img: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      birthDay: new FormControl('', [Validators.required]),
      salary: new FormControl('', [Validators.required]),
      position: new FormControl('')
    });
  }
  getAllPosition() {
    this.employeeService.getAllPosition().subscribe(data =>{
      // @ts-ignore
      this.position = data;
    });
  }
  createEmployee() {
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRel = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRel.getDownloadURL().subscribe((url) => {
          this.employeeForm.patchValue({img: url});
          this.employeeService.saveEmployee(this.employeeForm.value).subscribe(() => {
            this.router.navigateByUrl('/employee-list').then(r => this.toast.success('created success'));
          });
        });
      })
    ).subscribe();
  }

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ssa', 'en-US');
  }

  get name() {
    return this.employeeForm.get('name');
  }
  get email() {
    return this.employeeForm.get('email');
  }
  get address() {
    return this.employeeForm.get('address');
  }
  get img() {
    return this.employeeForm.get('img');
  }
  get gender() {
    return this.employeeForm.get('gender');
  }
  get phone() {
    return this.employeeForm.get('phone');
  }
  get birthDay() {
    return this.employeeForm.get('birthDay');
  }
  get salary() {
    return this.employeeForm.get('salary');
  }

}
