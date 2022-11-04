import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../service/employee.service";
import {FormControl, FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {IEmployeeDto} from "../model/employee/i-employee-dto";
import {Title} from "@angular/platform-browser";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  employeeList: IEmployeeDto[] = [];
  employee: IEmployeeDto = {};
  searchName: string = '';
  searchPhone: string = '';
  searchAccount: string = '';
  pageCurrent: number = 0;
  totalPages: number;
  arrayPage: number[];
  size: number;
  sort: string = 'name';
  totalElement: number;
  currentElement: number;
  checkSort: boolean = false;
  formSearch: FormGroup;
  formPage: FormGroup;
  pageSearch: number;
  checkSpecialCharacterName: boolean = false;
  checkSpecialCharacterAccount: boolean = false;
  checkSpecialCharacterPhone: boolean = false;

  constructor(private employeeService: EmployeeService, private toast: ToastrService, private tile: Title, private router: Router) {
    this.tile.setTitle("Danh sách nhân viên");
  }

  /**
   * /**
   * Create by TuyenTN
   * Date: 13/8/2022
   */

  ngOnInit(): void {
    this.getAllSearch(0, '', '', '', 'id,DESC');
    this.searchEmployeeForm();
    this.searchPageForm();
  }

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * method use get info all employee flow property match conditional in form search
   * @param pageCurrent
   * @param searchName
   * @param searchPhone
   * @param searchAccount
   * @param sort
   */
  getAllSearch(pageCurrent: number, searchName: string, searchPhone: string, searchAccount: string, sort: string) {
    this.employeeService.getAllEmployee(pageCurrent, searchName, searchPhone, searchAccount, sort).subscribe(data => {
      if (data != null) {
        // @ts-ignore
        this.employeeList = data.content;
        // @ts-ignore
        this.totalPages = data.totalPages;
        // @ts-ignore
        this.arrayPage = new Array(data.totalPages);
        // @ts-ignore
        this.pageCurrent = data.number;
        // @ts-ignore
        this.size = data.size;
        // @ts-ignore
        this.totalElement = data.totalElements;
        // @ts-ignore
        this.currentElement = data.numberOfElements;
      } else {
        this.employeeList = [];
      }
    })
  }


  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * method use create search form
   */
  searchEmployeeForm() {
    this.formSearch = new FormGroup({
      nameForm: new FormControl(''),
      phoneForm: new FormControl(''),
      accountForm: new FormControl('')
    });
  }
  searchPageForm(){
    this.formPage = new FormGroup({
      pageForm: new FormControl('')
    })
  }

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use
   */
  searchEmployeeFormByProperty() {
    this.formPage.value.pageForm ='';
    this.formSearch.value.nameForm = this.formSearch.value.nameForm.trim();
    this.formSearch.value.phoneForm = this.formSearch.value.phoneForm.trim();
    this.formSearch.value.accountForm = this.formSearch.value.accountForm.trim();
    if (this.formSearch.value.nameForm == null) {
      this.searchName = '';
      this.checkSpecialCharacterName = false;
    } else {
      if (this.formSearch.value.nameForm.search("[#+&%]") >= 0) {
        this.checkSpecialCharacterName = true;
        this.searchName = this.formSearch.value.nameForm;
      } else {
        this.checkSpecialCharacterName = false;
        this.searchName = this.formSearch.value.nameForm;
      }
    }
    if (this.formSearch.value.phoneForm == null) {
      this.searchPhone = '';
      this.checkSpecialCharacterPhone = false;
    } else {
      if (this.formSearch.value.phoneForm.search("[#%&+]") >= 0) {
        this.checkSpecialCharacterPhone = true;
        this.searchPhone = this.formSearch.value.phoneForm;
      } else {
        this.checkSpecialCharacterPhone = false;
        this.searchPhone = this.formSearch.value.phoneForm;
      }
    }
    if (this.formSearch.value.accountForm == null) {
      this.searchAccount = '';
      this.checkSpecialCharacterAccount = false;
    } else {
      if (this.formSearch.value.accountForm.search("[#%+&]") >= 0) {
        this.checkSpecialCharacterAccount = true;
        this.searchAccount = this.formSearch.value.accountForm;
      } else {
        this.checkSpecialCharacterAccount = false;
        this.searchAccount = this.formSearch.value.accountForm;
      }
    }
    if (this.searchName =="",this.searchPhone=="",this.searchAccount==""){
      this.getAllSearch(0,this.searchName,this.searchPhone,this.searchAccount,'id,DESC');
      this.searchPageForm();
    }else{
      this.getAllSearch(this.pageCurrent,this.searchName,this.searchPhone,this.searchAccount,this.sort)
      this.searchPageForm();
    }
  }


  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * method use transmission object to modal
   * @param item
   */
  modalDelete(item: IEmployeeDto) {
    this.employee = item;
  }

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use delete employee
   * @param id
   */
  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(d => {
      // @ts-ignore
      this.toast.success('Xóa thành công!!!', 'Xóa Nhân Viên', 600);
      // if (this.checkSort) {
        if (this.totalElement - 1 == this.size * (this.totalPages - 1)) {
          this.getAllSearch(this.pageCurrent - 1, this.searchName, this.searchPhone, this.searchAccount, this.sort);
        } else {
          this.getAllSearch(this.pageCurrent, this.searchName, this.searchPhone, this.searchAccount, this.sort);
        }
    }, error => {
      if (error.status == 404) {
        // @ts-ignore
        this.toast.error('Xóa thất bại!!!', 'Xóa Nhân Viên', 600);
      }
    })
  }
  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   *Method use back page start
   */
  goStart() {
    this.getAllSearch(0,this.searchName,this.searchPhone,this.searchAccount,this.sort);
    this.searchPageForm();
  }
  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   *Method use back page start
   */
  goEnd() {
    if (this.totalPages>0){
      this.getAllSearch(this.totalPages-1,this.searchName,this.searchPhone,this.searchAccount,this.sort);
      this.searchPageForm();
    }
  }

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use back page previous
   */

  goPrevious() {
    let numberPage: number = this.pageCurrent;
    if (numberPage > 0) {
      numberPage--;
      this.getAllSearch(numberPage, this.searchName, this.searchPhone, this.searchAccount, this.sort);
      this.searchPageForm();
    }
  }

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use next page previous
   */
  goNext() {
    let numberPage: number = this.pageCurrent;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllSearch(numberPage, this.searchName, this.searchPhone, this.searchAccount, this.sort);
      this.searchPageForm();
    }
  }

  /**
   * /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use come page i
   * @param i
   */

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use sort by name
   */
  sortByName() {
    this.checkSort = !this.checkSort;
    if (this.checkSort) {
      this.sort = 'name,DESC';
      this.getAllSearch(0, this.searchName, this.searchPhone, this.searchAccount, this.sort);
    } else {
      this.sort = 'name';
      this.getAllSearch(0, this.searchName, this.searchPhone, this.searchAccount, this.sort);
    }
  }

  searchPageCurrent() {
    this.pageSearch = parseInt(this.formPage.value.pageForm.trim());
    if (this.pageSearch > 0 && this.pageSearch <= this.totalPages){
      this.getAllSearch(this.pageSearch-1,this.searchName,this.searchPhone,this.searchAccount,this.sort)
    }else{
  // @ts-ignore
      this.toast.error("Trang bạn tìm không tồn tại","",300)
    }
  }
}
