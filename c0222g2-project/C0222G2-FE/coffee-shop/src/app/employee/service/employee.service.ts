import {Injectable} from '@angular/core';

import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {IEmployeeDto} from "../model/employee/i-employee-dto";
import {Employee} from "../model/employee/employee";
import {CookieService} from "../../login/service/cookie.service";
import {environment} from "../../../environments/environment";

const API_URL= `${environment.apiUrl}`

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private URL_EMPLOYEE = API_URL+ "/rest";
  private header = 'Bearer ' + this.cookieService.getCookie('jwToken');
  constructor(private httpClient: HttpClient,
              private cookieService: CookieService) {
  }

  /**
   * /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use connect find by id on API
   * @param id
   */
  findById(id: number): Observable<IEmployeeDto> {
    return this.httpClient.get<IEmployeeDto>(this.URL_EMPLOYEE + '/employee/find/' + id, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use connect get list info flow condition on API
   * @param page
   * @param searchName
   * @param searchPhone
   * @param searchAccount
   * @param sortName
   */
  getAllEmployee(page: number, searchName: string, searchPhone: string, searchAccount: string, sortName: string): Observable<IEmployeeDto[]> {
    return this.httpClient.get<IEmployeeDto[]>
    (this.URL_EMPLOYEE + '/employee/page?page=' + page + '&searchName=' + searchName + '&searchPhone=' +
      searchPhone + '&searchAccount=' + searchAccount + '&sort=' + sortName, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  /**
   * Create by TuyenTN
   * Date: 13/8/2022
   * Method use connect delete employee by id on API
   * @param id
   */
  deleteEmployee(id: number): Observable<string> {
    return this.httpClient.delete<string>(this.URL_EMPLOYEE + '/employee/delete/' + id, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  /**
   * end code TuyenTN
   */

//-------------------------------------------------------------------------------------------------------------------
  /**
   * start code TaiLV
   */

  /**
   * Create by TaiLV
   * Date: 13/8/2022
   * Method use connect create employee on API
   * @param employee
   */
  saveEmployee(employee) {
    return this.httpClient.post(this.URL_EMPLOYEE + '/employee/create', employee, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  /**
   * Create by TaiLV
   * Date: 13/8/2022
   * Method use connect employee by id on API
   * @param id
   */
  findByIdEdit(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(this.URL_EMPLOYEE + '/employee/findId/' + id, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  /**
   * Create by TaiLV
   * Date: 13/8/2022
   * Method use connect edit employee on API
   * @param employee
   */
  updateEmployee(employee) {
    return this.httpClient.patch(this.URL_EMPLOYEE + '/employee/edit', employee, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  /**
   * Create by TaiLV
   * Date: 13/8/2022
   * Method get list position on API
   * @param
   */
  getAllPosition() {
    return this.httpClient.get(this.URL_EMPLOYEE + '/position', {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  /**
   * Create by TaiLV
   * Date: 13/8/2022
   * Method get list user on API
   * @param
   */
  getAllUser() {
    return this.httpClient.get(this.URL_EMPLOYEE + '/user', {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }
}
