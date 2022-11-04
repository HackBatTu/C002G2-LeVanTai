import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {EmployeeService} from "../service/employee.service";
import {IEmployeeDto} from "../model/employee/i-employee-dto";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrls: ['./detail-employee.component.css']
})
export class DetailEmployeeComponent implements OnInit {
  employeeDetailDTO: IEmployeeDto ={};
  constructor(private employeeService:EmployeeService, private activatedRoute:ActivatedRoute,private toast: ToastrService,
              private router:Router,private title:Title) {
    this.title.setTitle("Chi tiết nhân viên");
  }

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   *
   */
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap)=>{
          const id = parseInt(paramMap.get('id'));
          this.employeeService.findById(id).subscribe(data=>{
            this.employeeDetailDTO = data;
          },error => {
              if (error.status == 404) {
                this.toast.error('Không tìm thấy nhân viên này','Thất bại!!!');
                this.router.navigateByUrl('employee');

              }
            },
            ()=>{})
      });
  }

  /**
   * Create by TuyenTN
   * Date:14-8-2022
   * @param id
   */
  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(d => {
      // @ts-ignore
      this.toast.success('Xóa thành công!!!', 'Xóa Nhân Viên', 600);
      this.router.navigateByUrl("employee");
    }, error => {
      if (error.status == 404) {
        // @ts-ignore
        this.toast.error('Xóa thất bại!!!', 'Xóa Nhân Viên', 600);
        this.router.navigateByUrl("employee");
      }
    })
  }

}
