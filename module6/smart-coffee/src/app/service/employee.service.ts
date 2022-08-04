import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private URL_EMPLOYEE = 'http://localhost:8080/rest';

  constructor(private httpClient: HttpClient) {
  }

  saveEmployee(employee) {
    return this.httpClient.post(this.URL_EMPLOYEE + '/create', employee);
  }

  findById(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(this.URL_EMPLOYEE + '/findId/' + id);
  }

  updateEmployee(employee) {
    return this.httpClient.patch(this.URL_EMPLOYEE + '/edit', employee);
  }

  getAllPosition() {
    return this.httpClient.get(this.URL_EMPLOYEE + '/position');
  }

  getAllUser() {
    return this.httpClient.get(this.URL_EMPLOYEE + '/user');
  }
}
