import {Injectable} from '@angular/core';
import {Feedback} from "../model/feedback";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CookieService} from "../../login/service/cookie.service";

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private URL_FEEDBACK = "http://localhost:8080/feedback";
  private header = 'Bearer ' + this.cookieService.getCookie('jwToken');
  feedback: Feedback;

  constructor(private httpClient: HttpClient, private cookieService: CookieService) {
  }


  /**
   * Creator : LuanTV
   * Date : 13/08/2022
   * Function : page, search, sort
   *
   * @param page
   * @param searchName
   * @param searchStartDate
   * @param searchEndDate
   * @param sortRating
   */
  getAllFeedback(page: number, searchName, searchStartDate, searchEndDate, sortRating){
    let creator;
    let startDate;
    let endDate;
    if (searchName == null) {
      creator = '';
    } else {
      creator = searchName;
    }
    if (searchStartDate == null) {
      startDate = '1000-01-01';
    } else {
      startDate = searchStartDate;
    }
    if (searchEndDate == null) {
      endDate = '8000-01-01';
    } else {
      endDate = searchEndDate;
    }
    return this.httpClient.get<Feedback[]>(this.URL_FEEDBACK + '/page?page=' + page + '&searchCreator=' + creator +
      '&searchStartDate=' + startDate + '&searchEndDate=' + endDate + '&sort=' + sortRating, {headers: new HttpHeaders({'authorization': this.header})}).pipe();

  }


  /**
   * Creator : LuanTV
   * Date : 13/08/2022
   * Function : find by id
   *
   * @param id
   */
  findFeedbackById(id: number): Observable<Feedback> {
    return this.httpClient.get(this.URL_FEEDBACK + '/' + id,
      {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  /**
   * Creator : DiepTT
   * Date : 13/08/2022
   * Function : create feedback
   * @param feedback
   */
  createFeedback(feedback: Feedback): Observable<Feedback> {
    return this.httpClient.post<Feedback>(this.URL_FEEDBACK + '/create', feedback, {headers: new HttpHeaders({'authorization': this.header})}).pipe()
  }
}
