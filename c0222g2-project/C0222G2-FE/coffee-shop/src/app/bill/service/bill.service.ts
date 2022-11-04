import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Bill} from "../model/bill";
import {CookieService} from "../../login/service/cookie.service";


@Injectable({
  providedIn: 'root'
})

export class BillService {
  private URL_BILL = 'http://localhost:8080/rest/bill';
  private URL_DISH = 'http://localhost:8080/rest/bill/dish';
  private header = ' Bearer ' + this.cookieService.getCookie('jwToken');

  constructor(private httpClient: HttpClient,
              private cookieService: CookieService) {
  }


  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: Get bill list, with pagination,search by bill number and creation date
   *
   * @param page
   * @param searchCode
   * @param searchDate
   */

  getAllBill(page: number, searchCode, searchDate) {
    let searchBillCode;
    let searchBillDate
    if (searchCode == null) {
      searchBillCode = '';
    } else {
      searchBillCode = searchCode;
    }
    if (searchDate == null) {
      searchBillDate = '';
    } else {
      searchBillDate = searchDate
    }
    return this.httpClient.get<Bill[]>(this.URL_BILL + "?page=" + page + "&searchParamCode=" + searchBillCode +
      "&searchParamDate=" + searchBillDate, {headers: new HttpHeaders({'authorization': this.header})});
  }


  /**
   *  Created by: HauLT
   *  Date created: 17/08/2022
   *  function: Get dish list
   *
   * @param id
   */

  getAllDish(id: number): Observable<Bill[]> {
    return this.httpClient.get<Bill[]>(this.URL_DISH + '/' + id, {headers: new HttpHeaders({'authorization': this.header})});
  };

  /**
   * Created by: HauLT
   * Date created: 12/08/2022
   * function: get id
   *
   * @param id
   */

  findById(id: number): Observable<Bill> {
    return this.httpClient.get<Bill>(this.URL_BILL + '/' + id, {headers: new HttpHeaders({'authorization': this.header})});
  };


}
