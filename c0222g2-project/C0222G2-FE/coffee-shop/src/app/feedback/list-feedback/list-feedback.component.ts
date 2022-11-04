import {Component, OnInit} from '@angular/core';
import {Feedback} from "../model/feedback";
import {FeedbackService} from "../service/feedback.service";
import {AbstractControl, FormControl, FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {formatDate} from "@angular/common";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-list-feedback',
  templateUrl: './list-feedback.component.html',
  styleUrls: ['./list-feedback.component.css']
})
export class ListFeedbackComponent implements OnInit {
  listFeedback: Feedback[] = [];
  searchForm: FormGroup;
  totalPages: number;
  number: number;
  size: number;
  countTotalPages: number[];
  rating: number;
  code: string;
  creator: string;
  email: string;
  content: string;
  feedbackDate: string;
  image: string;
  id: number;
  name: string;
  startDate: string;
  endDate: Date;
  sortRating: string = 'DESC';
  checkSortOrNot: boolean = false;
  checkSort: boolean = false;
  checkNameCreator: boolean = false;
  formPage: FormGroup;
  pageSearch: number;
  checkPage: boolean = false;


  constructor(private feedbackService: FeedbackService, private toast: ToastrService,
              private title: Title) {
    this.title.setTitle("Quản lý phản hồi");
  }

  ngOnInit(): void {
    this.getAllFeedback(0, this.name, this.startDate, this.endDate, 'ASC');
    this.searchForm = new FormGroup({
      searchName: new FormControl(''),
      searchStartDate: new FormControl('', this.checkInputBirthday),
      searchEndDate: new FormControl('', this.checkInputBirthday)
    });
    this.formPage = new FormGroup({
      pageForm: new FormControl('')
    });
  }


  get searchStartDate() {
    return this.searchForm.get('searchStartDate')
  }

  get searchEndDate() {
    return this.searchForm.get('searchEndDate')
  }

  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : validate date
   *
   *
   * @param startDate
   */
  checkInputBirthday(startDate: AbstractControl) {
    const value = startDate.value
    const curDate = formatDate(new Date(), 'yyyy-MM-dd', 'en-US');
    if (value >= curDate) {
      return {'checkDate': true}
    }
    return null;
  }

  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : message
   *
   */

  showToast() {
    if (!this.searchForm.valid) {
      if (!this.searchStartDate.valid && (this.searchStartDate.value > this.searchEndDate.value)) {
        this.toast.error("Ngày bắt đầu không được hơn ngày hiện tại!", "Lỗi")
      } else if (!this.searchEndDate.valid) {
        this.toast.error("Ngày kết thúc không được hơn ngày hiện tại!", "Lỗi")
      }
    }
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
  getAllFeedback(page: number, searchName, searchStartDate, searchEndDate, sortRating) {
    this.feedbackService.getAllFeedback(page, searchName, searchStartDate, searchEndDate, sortRating)
      .subscribe((data: Feedback[]) => {
        if (data != null) {
          // @ts-ignore
          this.listFeedback = data.content;
        } else {
          this.listFeedback = [];
        }
        if (this.listFeedback.length !== 0) {
          // @ts-ignore
          this.totalPages = data.totalPages;
          // @ts-ignore
          this.countTotalPages = new Array(data.totalPages);
          // @ts-ignore
          this.number = data.number;
          // @ts-ignore
          this.size = data.size
        }
      });
  }


  /**
   * Creator : LuanTV
   * Date : 13/08/2022
   * Function : search
   */
  getSearch() {
    this.checkSort = false;
    this.checkPage = true;
    this.searchForm.value.searchName = this.searchForm.value.searchName.trim()

      if (this.searchForm.value.searchName == null) {
        this.name = '';
        this.checkNameCreator = false;
      } else {
        if (this.searchForm.value.searchName.search("[#+&%^]") >= 0) {
          this.checkNameCreator = true;
          this.toast.error("Vui lòng không nhập ký tự!", "Lỗi")
          this.getAllFeedback(0, this.name, this.startDate, this.endDate, 'ASC')
        } else {
          this.checkNameCreator = false;
          this.name = this.searchForm.value.searchName;
        }
      }
      if (this.searchForm.value.searchStartDate === '') {
        this.startDate = '1000-01-01'
      }
      else {
        this.startDate = this.searchForm.value.searchStartDate;
      }
      if (this.searchForm.value.searchEndDate === '') {
        this.endDate = new Date()
      } else {
        this.endDate = this.searchForm.value.searchEndDate;
      }
      this.getAllFeedback(0, this.name, this.startDate, this.endDate, 'ASC')
     this.showToast()
  }


  /**
   * Creator : LuanTV
   * Date : 13/08/2022
   * Function : find by id
   *
   * @param id
   */
  showDetail(id: number) {
    this.feedbackService.findFeedbackById(id).subscribe(value => {
      this.id = id;
      this.code = value.code;
      this.creator = value.creator;
      this.email = value.email;
      this.content = value.content;
      this.rating = value.rating;
      this.feedbackDate = value.feedbackDate;
      this.image = value.image;
    })
  }

  /**
   * Creator : LuanTV
   * Date : 13/08/2022
   * Function : sort
   */
  getSort() {
    this.checkSort = true;
    this.checkSortOrNot = !this.checkSortOrNot;
    if (this.checkSortOrNot) {
      this.getAllFeedback(0, this.name, this.startDate, this.endDate, this.sortRating)
    } else {
      this.getAllFeedback(0, this.name, this.startDate, this.endDate, 'rating')
    }
  }


  /**
   * Creator : LuanTV
   * Date : 13/08/2022
   * Function : page switch button previous
   */
  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      if (this.checkSortOrNot) {
        this.getAllFeedback(numberPage, this.name, this.startDate, this.endDate, this.sortRating)
      } else {
        this.getAllFeedback(numberPage, this.name, this.startDate, this.endDate, 'rating');
      }
    }
  }

  /**
   * Creator : LuanTV
   * Date : 13/08/2022
   * Function : page switch button next
   */
  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      if (this.checkSortOrNot) {
        this.getAllFeedback(numberPage, this.name, this.startDate, this.endDate, this.sortRating)
      } else {
        this.getAllFeedback(numberPage, this.name, this.startDate, this.endDate, 'rating');
      }
    }
  }


  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : page switch button previous without sort
   */
  goPreviousWithoutSort() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAllFeedback(numberPage, this.name, this.startDate, this.endDate, 'ASC');
    }
  }

  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : page switch button next without sort
   */
  goNextWithoutSort() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllFeedback(numberPage, this.name, this.startDate, this.endDate, 'ASC');
    }
  }

  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : page switch button start
   */
  goStart() {
    if (this.checkSortOrNot) {
      this.getAllFeedback(0, this.name, this.startDate, this.endDate, this.sortRating)
    } else {
      this.getAllFeedback(0, this.name, this.startDate, this.endDate, 'rating');
    }
  }

  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : page switch button end
   */
  goEnd() {
    if (this.checkSortOrNot) {
      this.getAllFeedback(this.totalPages - 1, this.name, this.startDate, this.endDate, this.sortRating)
    } else {
      this.getAllFeedback(this.totalPages - 1, this.name, this.startDate, this.endDate, 'rating');
    }
  }


  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : page switch button start without sort
   */
  previousWithoutSort() {
    this.getAllFeedback(0, this.name, this.startDate, this.endDate, 'ASC');
  }


  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : page switch button end without sort
   */
  nextWithoutSort() {
    this.getAllFeedback(this.totalPages - 1, this.name, this.startDate, this.endDate, 'ASC');
  }

  /**
   * Creator : LuanTV
   * Date : 16/08/2022
   * Function : find by page number
   */
  searchPageCurrent() {
    this.pageSearch = parseInt(this.formPage.value.pageForm.trim());
    if (this.pageSearch > 0 && this.pageSearch <= this.totalPages) {
      this.getAllFeedback(this.pageSearch - 1, this.name, this.startDate, this.endDate, 'ASC');
    } else {
      this.toast.error('Trang bạn tìm không tồn tại', 'Lỗi')
      this.getAllFeedback(0, this.name, this.startDate, this.endDate, 'ASC');
    }
  }
}
