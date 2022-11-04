import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {Dish} from "../dish/model/dish";
import {CookieService} from '../login/service/cookie.service';

@Injectable({
  providedIn: 'root'
})
export class DishService {
  private header = 'Bearer ' + this.cookieService.getCookie('jwToken');
  private URL_DISH = "http://localhost:8080/dish"
  private URL_DISH_TYPE = "http://localhost:8080/dishType"

  constructor(private httpClient: HttpClient,
              private cookieService: CookieService) {}


  getDishPage(page: number,dishName:string,dishCode:String,dishPrice:string,dishTypeId:string): Observable<Dish[]> {

    return this.httpClient.get<Dish[]>(this.URL_DISH + "/searchDish?page=" + page+"&dishName="+dishName+"&dishCode="+dishCode+"&dishPrice="+dishPrice+"&dishTypeId="+dishTypeId, {headers: new HttpHeaders({'authorization': this.header})});
  }


  deleteDishById(id: number): Observable<Dish> {
    // @ts-ignore
    return this.httpClient.patch<Dish>(this.URL_DISH + "/delete/" + id,null,{headers: new HttpHeaders({'authorization': this.header})})
  }

  getAllDishType(): Observable<Dish[]>{
    return this.httpClient.get<Dish[]>(this.URL_DISH_TYPE+"/getDishTypeList",{headers: new HttpHeaders({'authorization': this.header})});
  }

}
