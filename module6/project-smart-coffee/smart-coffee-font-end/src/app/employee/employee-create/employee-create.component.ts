import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {Employee} from '../../model/employee';
import {Position} from '../../model/position';
import {EmployeeService} from '../../service/employee.service';
import {Router} from '@angular/router';
import {AngularFireStorage} from '@angular/fire/storage';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';
import {ToastrService} from 'ngx-toastr';
import {User} from '../../model/user';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  employeeForm: FormGroup;
  employee: Employee = {};
  position: Position[] = [];
  users: User[] = [];
  private selectedImage: any = null;

  constructor(private employeeService: EmployeeService, private router: Router, private storage: AngularFireStorage,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllPosition();
    this.getEmployeeForm();
  }

  getEmployeeForm() {
    // @ts-ignore
    this.employeeForm = new FormGroup({
      user: new FormControl('', [Validators.minLength(6)]),
      image: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      gender: new FormControl(''),
      phone: new FormControl('', [Validators.required, Validators.pattern('^(09|\\(84\\)\\+9)[01]\\d{7}$')]),
      birthDay: new FormControl(''),
      salary: new FormControl('', [Validators.required]),
      position: new FormControl('')
    });
  }

  getAllPosition() {
    this.employeeService.getAllPosition().subscribe(data => {
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
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ss', 'en-US');
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

  get image() {
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

  get user() {
    return this.employeeForm.get('user');
  }
}
