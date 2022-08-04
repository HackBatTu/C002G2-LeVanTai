import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Employee} from '../../model/employee';
import {User} from '../../model/user';
import {Position} from '../../model/position';
import {EmployeeService} from '../../service/employee.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrls: ['./employee-update.component.css']
})
export class EmployeeUpdateComponent implements OnInit {
  employeeForm: FormGroup;
  employee: Employee = {};
  userName: User[] = [];
  position: Position[] = [];

  constructor(private employeeService: EmployeeService, private router: Router,
              private activate: ActivatedRoute,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.getParamId();
    this.getAllUser();
    this.getAllPosition();
    this.getEmployeeFormUpdate();
  }

  getParamId() {
    this.activate.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id');
      // tslint:disable-next-line:radix
      this.employeeService.findById(parseInt(id)).subscribe(data => {
        this.employee = data;
      });
    });
  }

  getAllPosition() {
    this.employeeService.getAllPosition().subscribe(data => {
      // @ts-ignore
      this.position = data;
    });
  }

  getAllUser() {
    this.employeeService.getAllUser().subscribe(data => {
      // @ts-ignore
      this.userName = data;
    });
  }

  getEmployeeFormUpdate() {
    this.employeeForm = new FormGroup({
      id: new FormControl(this.employee.id),
      img: new FormControl(this.employee.img),
      userName: new FormControl(this.employee.userName),
      name: new FormControl(this.employee.name, [Validators.required]),
      email: new FormControl(this.employee.email, [Validators.required]),
      address: new FormControl(this.employee.address, [Validators.required]),
      gender: new FormControl(this.employee.gender, [Validators.required]),
      phone: new FormControl(this.employee.phone, [Validators.required]),
      birthDay: new FormControl(this.employee.birthday, [Validators.required]),
      salary: new FormControl(this.employee.salary, [Validators.required]),
      position: new FormControl(this.employee.position)
    });
  }

  updateEmployee() {
    this.employeeService.updateEmployee(this.employeeForm.value).subscribe(data => {
      this.employee = data;
    }, error => {
    }, () => {
      this.router.navigateByUrl('/employee-list').then(value => this.toast.success('updated success'));
    });
  }

  compareUserName(c1: User, c2: User): boolean {
    // tslint:disable-next-line:triple-equals
    if ((c1 && c2) != undefined) {
      return c1.id === c2.id;
    }
  }

  comparePosition(c1: Position, c2: Position): boolean {
    // tslint:disable-next-line:triple-equals
    if ((c1 && c2) != undefined) {
      return c1.id === c2.id;
    }
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
