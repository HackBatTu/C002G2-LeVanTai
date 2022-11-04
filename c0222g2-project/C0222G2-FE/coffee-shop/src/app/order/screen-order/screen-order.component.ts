import { Component, ElementRef, OnChanges, OnInit, Output, QueryList, SimpleChange, SimpleChanges, VERSION, ViewChild, ViewChildren } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/database';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { Observable, Subject } from 'rxjs';
import { Dish } from 'src/app/dish/model/dish';
import { Employee } from 'src/app/employee/model/employee/employee';
import { CookieService } from 'src/app/login/service/cookie.service';
import { CoffeeTable } from '../model/CoffeeTable';
import { NotificationOfCoffeStore } from '../model/notification';
import { Order } from '../model/order';
import { NotificationService } from '../service/notification.service';
import { OrderService } from '../service/order.service';
import {formatDate} from '@angular/common';
import {FeedbackService} from "../../feedback/service/feedback.service";
import {AngularFireStorage} from "@angular/fire/storage";
import {finalize} from "rxjs/operators";

@Component({
  selector: 'app-screen-order',
  templateUrl: './screen-order.component.html',
  styleUrls: ['./screen-order.component.css']
})
export class ScreenOrderComponent implements OnInit, OnChanges{
  @ViewChild('quantity') inputQuantity;
  @ViewChildren("checkboxes") checkboxes: QueryList<ElementRef>;
  order: Order;
  dishId: number;
  formCheckBox: FormGroup;
  hideMenu:boolean = false;
  checkButton:boolean = true;
  checkButtonOption: boolean = false;
  notificationMessage: NotificationOfCoffeStore;
  dishes: Dish[] = [];
  dishTypes: any;
  dish: Dish;
  orderMenu = [];
  checkOrderMenu = [];
  messageUnread = [];
  checkBox: boolean = false;
  selectCheckBox: any;
  totalPages = [];
  totalMoney = 0;
  presentPage = 1;
  date: Date;
  tableUser: string;
  employee: Employee;
  coffeTable: CoffeeTable;
  idTable;
  /**
 * Created by: DiepTT
 * Date created: 11/08/2022
 * Function: Create feedback (User send feedback)
 */
  currentDate = new Date();
  rating: number[] = [1, 2, 3, 4, 5];
  value: number = 0;
  feedbackFrom: FormGroup;
  selectedImage: any = null;
  isLoading: Boolean = false;


  constructor(private activatedRoute: ActivatedRoute,
              private orderService: OrderService,
              private notificationService: NotificationService,
              private toastr: ToastrService,
              private title : Title,
              private feedbackService: FeedbackService,
              private angularFireStorage: AngularFireStorage,
              private cookieService: CookieService){
      this.formCheckBox = new FormGroup({
        selectCheckBox: new FormArray([])
      });
      this.title.setTitle("Gọi món");
      this.messageUnread = this.notificationService.keyArray;
      this.date = new Date();
      this.tableUser = this.cookieService.getCookie('username');
      this.getTable(this.tableUser);
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.formCheckBox = new FormGroup({
      selectCheckBox: new FormArray([])
    });
    throw new Error('Method not implemented.');
  }


  ngOnInit(): void {
    this.getAllDish(1, this.presentPage);
    this.getAllDishType();
    /**
     * Creator: DiepTT
     */
    this.getFeedbackForm();
  }


  /**
   *  Author: BinhPx
   *  Date: 11/08/2022
   *  This function to open and close menu
   *  when web site responsive which width is less than 930px
   */
  openMenuService(){
    if(this.checkButton){
      this.hideMenu = true;
      this.checkButton = false;
    }
    else{
      this.hideMenu = false;
      this.checkButton= true;
    }
  }

  /**
   *  Author: BinhPx
   *  Date: 11/08/2022
   *  This function to get all dish have when api return
   */

  getAllDish(id:number, page){
    this.dishId = id;
    this.orderService.redirect(id, page).subscribe(dishes => {
      // @ts-ignore
       this.dishes = dishes.content;
       // @ts-ignore
       this.totalPages = Array.from({length: dishes.totalPages}, (v,k)=> k+1);
       // @ts-ignore
      this.dishes = dishes.content;
       // @ts-ignore
      this.totalPages = Array.from({length: dishes.totalPages}, (v,k)=> k+1);
    });
  }


  /**
   *  Author: BinhPx
   *  Date: 11/08/2022
   *  This function to get all dish type have when api return
   */
  getAllDishType(){
    this.orderService.getAllDishType().subscribe(dishTypes => {
       // @ts-ignore
      this.dishTypes = dishTypes
    });
  }

  getTable(code: string){
    this.orderService.getTable(code).subscribe(items => {
      this.idTable = items.id;
      localStorage.setItem('idTable', ''+items.id);
    });
  }


  /**
   *  Author: BinhPx
   *  Date: 11/08/2022
   *  This function use id to get dish then show result to function addIntoMenuOrder()
   */
  getDish(id: number){
      this.orderService.getDish(id).subscribe(dish => {
         this.dish = dish;
         localStorage.setItem('dish', JSON.stringify(this.dish));
         const tempOrder: string = localStorage.getItem('dish');
         if(tempOrder){
            this.dish = JSON.parse(tempOrder) as Dish;
          }
      })
  }


  /**
   *  Author: BinhPx
   *  Date: 11/08/2022
   *  This function do insert dish into menu order
   */
  addIntoMenuOrder(quantity){
    console.log( localStorage.getItem('idTable'));

      let flag = false;
      let id = 0;
      const order = {
          quantity: Number(quantity),
          dish: this.dish,
          bill: 1,
          employee: 1,
          coffeeTable: localStorage.getItem('idTable')
      };

    if(quantity == null || quantity > 10 || quantity == '' || quantity < 0){
      this.toastr.error('Bạn chưa nhập số lượng hoặc số lượng lớn 9!','',{timeOut: 2000, progressBar: true});
      this.inputQuantity.nativeElement.value = '';
    }
    else{
      if(this.orderMenu.length == 0){
        this.orderMenu.push(order);
        this.totalMoney = 0;
        this.orderMenu.forEach(items => {
          this.totalMoney+= items.dish.price * items.quantity;
        });
      }
      else{
        for(let i = 0; i < this.orderMenu.length; i++){
          if(this.orderMenu[i].dish.id == this.dish.id){
            id = i;
            flag = true;
            break;
          }
          else{
            flag = false;
          }
        }
        if(flag){
            for(let i =0; i < this.orderMenu.length; i++){
              if(i == id){
                let temp = this.orderMenu[i].quantity;
                this.orderMenu[i].quantity = Number(quantity) + Number(temp);
                this.totalMoney = 0;
                this.orderMenu.forEach(items => {
                this.totalMoney+= items.dish.price * items.quantity});
              }
            }
            flag = false;
        }
        else{
          this.orderMenu.push(order);
          this.totalMoney = 0;
          this.orderMenu.forEach(items => {
            this.totalMoney+= items.dish.price * items.quantity
          });
          flag = false;
        }
      }
    }
    this.inputQuantity.nativeElement.value = '';
  }

    /**
   *  Author: BinhPx
   *  Date: 14/08/2022
   *  This function create order have param is table code, employee code, bill code, dish code
   */
    createOrder(titleContent: string, tableCoffe: string, requestConent: string){
      if(this.orderMenu.length ==0 ){
        this.toastr.warning('Vui lòng order!','Thất bại',{timeOut: 2000, progressBar: true})
      }
      else{
        this.orderMenu.forEach(items => {
          this.order = {
            quantity: items.quantity,
            dish: this.dish,
            // @ts-ignore
            bill: {},
            employee: {},
            coffeeTable: {
              id: items.coffeeTable,
              code: this.idTable
            }
          }
          this.orderService.updateTable(tableCoffe).subscribe();
          this.orderService.createOrder(this.order).subscribe();
        });
        this.orderMenu = [];
        this.sendNotification(titleContent, tableCoffe, requestConent);
        this.displayTimer(0);
      }
    }



   /**
   *  Author: BinhPx
   *  Date: 12/08/2022
   *  This function check event check box and push it into selectCheckBox
   */
  onCheckBoxChange(event){
    this.selectCheckBox  = this.formCheckBox.controls['selectCheckBox'] as FormArray;
    if(event.target.checked){
      this.selectCheckBox.push(new FormControl(event.target.value));
    }
    else{
      const index = this.selectCheckBox.controls.findIndex(i => i.value === event.target.value);
      this.selectCheckBox.removeAt(index);
    }
  }


   /**
   *  Author: BinhPx
   *  Date: 12/08/2022
   *  This function use to delete dish in to list dish order
   */
  deleteDish(){
    const selectCheckBox  = this.formCheckBox.controls['selectCheckBox'] as FormArray;
    let arrayTemp = [];
    selectCheckBox.value.sort();
    for(let i of selectCheckBox.value){
      this.orderMenu.splice(i, 1, 0);
    }
    arrayTemp = this.orderMenu.filter(item => {
       if(item != 0){
        return arrayTemp.push(item);
       }
    })
    this.orderMenu = arrayTemp;
      this.totalMoney = 0;
      this.orderMenu.forEach(items => {
        this.totalMoney+= items.dish.price * items.quantity;
      });
    this.formCheckBox = new FormGroup({
      selectCheckBox: new FormArray([])
    });
    this.uncheckAll();
  }

  uncheckAll() {
    this.checkboxes.forEach((element) => {
      element.nativeElement.checked = false;
    });
  }


  /**
   *  Author: BinhPx
   *  Date: 13/08/2022
   *  This function use to send messager
   */
  sendNotification(titleContent: string, tableCoffe: string, requestConent: string){
    this.notificationService.getTokenFromFcm();
    this.toastr.success('Bạn đã gửi yêu cầu thành công!','Thành công',{timeOut: 2000, progressBar: true})
    this.notificationService.sendNotification(titleContent, tableCoffe, requestConent);
  }


  /**
   *  Author: BinhPX
   *  Date: 13/08/2022
   *  Function navigate to another page menu dish
   */
  goPrevious() {
    let numberPage: number = this.presentPage;
    if (numberPage > 0) {
      numberPage--;
      this.getAllDish(this.dishId, numberPage);
      this.presentPage = numberPage;
    }
  }

  goNext() {
    let numberPage: number = this.presentPage;

    if (numberPage < this.totalPages.length) {
      numberPage++;
      this.getAllDish(this.dishId, numberPage);
      this.presentPage = numberPage;
    }
  }

  goItem(page: number) {
    this.presentPage = page;
    this.getAllDish(this.dishId, page);
  }




  name = "Angular" + VERSION.major;
  displayTimer(timer){
      let timerString: HTMLElement = document.getElementById('timerCountdown') as HTMLElement;
      let timerCountdown = timer;
      let minutes, seconds;
      let setTimer = setInterval(()=>{
            minutes = Math.floor(timerCountdown/60);
            seconds = Math.floor(timerCountdown%60);
            minutes = minutes < 10 ? '0' + minutes : minutes;
            seconds = seconds < 10 ? '0' + seconds : seconds;
            if(++timerCountdown>(60*1)){
              this.toastr.error('Thời gian chờ của bạn đã tới hạn, yêu cầu sẽ tự động gửi đi đến quản lý!','',{timeOut: 2000, progressBar: true});
              this.orderMenu = [];
              clearInterval(setTimer);
            }
            timerString.innerHTML = minutes + ':' + seconds;
        }, 1000);
  }



  /**
   * Func progress message
   */
  showMessage(){
    let title = this.notificationService.notification.title;
    let body = this.notificationService.notification.body;
    this.toastr.warning(body, title, {timeOut: 3000, progressBar: true});
  }


  /**
   * Created by: DiepTT
   * Date created: 11/08/2022
   * Function: Get value of "rating" from Feedback Form
   * @param rating
   */
  getValue(rating: number) {
    this.value = rating;
  }

  /**
   * Created by: DiepTT
   * Date created: 11/08/2022
   * Date updated: 12-14/08/2022
   * Function: Get Feedback Form with validation for form-controls
   */
  getFeedbackForm() {
    this.feedbackFrom = new FormGroup({
      creator: new FormControl("",
        [Validators.required, Validators.minLength(2), Validators.maxLength(30),
          Validators.pattern("^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
            "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*( )){0,14}" +
            "([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
            "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*)$")]),
      email: new FormControl("", [Validators.required, Validators.email,
        Validators.minLength(5)]),
      content: new FormControl("", [Validators.required, Validators.minLength(2)]),
      rating: new FormControl(this.value),
      image: new FormControl("",
        [Validators.pattern("^.+((.jpg)|(.png)|(.gif)|(.jpeg)|(.psd)|(.bmp)|(.heic))$")])
    })
  }

  /**
   * Created by: DiepTT
   * Date created: 11/08/2022
   * Date updated: 12-14/08/2022
   * Function: Actions when user click button "Gửi phản hồi"
   */
  save() {
    if (this.feedbackFrom.valid) {
      this.toggleLoading();
      const feedback = this.feedbackFrom.value;
      feedback.rating = this.value;
      feedback.email= feedback.email.trim();
      feedback.content = feedback.content.trim();

      if (!(this.selectedImage == null)) {
        const imgName = this.getCurrentDateTime() + this.selectedImage.name;
        const fileRef = this.angularFireStorage.ref(imgName);

        this.angularFireStorage.upload(imgName, this.selectedImage).snapshotChanges().pipe(
          finalize(() => {
            fileRef.getDownloadURL().subscribe((url) => {
              feedback.image = url;
              this.feedbackService.createFeedback(feedback).subscribe(
                () => {
                  this.showToastrSuccess();
                  this.feedbackFrom.reset();
                  this.value = 0;
                  //@ts-ignore
                  $('#staticBackdropFeedback').modal('hide');
                }, error => {
                  console.log(error.error);
                  let errs = error.error;
                })
            })
          })
        ).subscribe();
      } else {
        feedback.image = "";
        this.feedbackService.createFeedback(feedback).subscribe(
          () => {
            this.showToastrSuccess();
            this.feedbackFrom.reset();
            this.value = 0;
            //@ts-ignore
            $('#staticBackdropFeedback').modal('hide');
          }, error => {
            console.log(error.error);
            let errs = error.error;
          })
      }
    } else {
      this.showToastrWarning();
    }
  }

  /**
   * Created by: DiepTT
   * Date created: 11/08/2022
   * Function: Get current date-time to concatenate with image name
   */
  private getCurrentDateTime(): string {
    return formatDate(new Date(), 'ddMMyyyy_hh:mm:ssa_', 'en-US');
  }

  /**
   * Created by: DiepTT
   * Date created: 11/08/2022
   * Function: Get information of uploaded image
   * @param event
   */
  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
  }

  /**
   * Created by: DiepTT
   * Date created: 13/08/2022
   * Function: Get information of uploaded image
   */
  toggleLoading() {
    this.isLoading = true;
    setTimeout(() => {
      this.isLoading = false;
    }, 3000)
  }

  /**
   * Created by: DiepTT
   * Date created: 13/08/2022
   * Function: Show notification when creating feedback successfully
   */
  showToastrSuccess() {
    this.toastr.success('Cảm ơn quý khách đã gửi phản hồi về cho quán!', 'Gửi thành công.');
  }

  /**
   * Created by: DiepTT
   * Date created: 13/08/2022
   * Function: Show notification when required input fields are not filled but submitting
   */
  showToastrWarning() {
    this.toastr.warning("Vui lòng nhập đầy đủ thông tin!")
  }

  /**
   * Created by: DiepTT
   * Date created: 16/08/2022
   * Function: Reset form when clicking button "Hủy"
   */
  reset() {
    this.feedbackFrom.reset();
    this.value = 0;
  }
}
