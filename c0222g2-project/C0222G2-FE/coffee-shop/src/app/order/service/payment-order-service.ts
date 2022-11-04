import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CoffeeTable} from "../model/CoffeeTable";
import {Payment} from "../model/Payment";
import {CookieService} from "../../login/service/cookie.service";
import {environment} from "../../../environments/environment";

const API_URL = `${environment.apiUrl}`

@Injectable({
  providedIn: "root"
})


export class PaymentOrderService {

  private header = "Bearer " + this.cookieService.getCookie('jwToken');
  private URL_GET_COFFEE_TABLE_PAGE = API_URL + "/api/payment/page";
  private URL_GET_LIST_BY_ID = API_URL + "/api/payment/list";
  private URL_PAYMENT = API_URL + "/api/payment/total";
  private URL_CREATE_BILL = API_URL + "/api/payment/in-bill";

  constructor(private httpClient: HttpClient,
              private cookieService: CookieService) {
  }

  getCoffeeTablePage(page: number): Observable<CoffeeTable[]> {
    return this.httpClient.get<CoffeeTable[]>(this.URL_GET_COFFEE_TABLE_PAGE + `?page=${page}`, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  getListTableById(id: number): Observable<CoffeeTable[]> {
    return this.httpClient.get<CoffeeTable[]>(this.URL_GET_LIST_BY_ID + `/${id}`, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  payment(id: number): Observable<Payment> {
    return this.httpClient.get<Payment>(this.URL_PAYMENT + '/' + id, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  createBill(idTable: number): Observable<any> {
    return this.httpClient.get(this.URL_CREATE_BILL + '?idTable=' + idTable, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }
}
