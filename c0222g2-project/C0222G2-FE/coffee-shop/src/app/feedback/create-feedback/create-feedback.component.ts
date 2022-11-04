import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {FeedbackService} from "../service/feedback.service";
import {AngularFireStorage} from "@angular/fire/storage";
import {formatDate} from "@angular/common";
import {finalize} from "rxjs/operators";
import {Feedback} from "../model/feedback";
import {ToastrService} from "ngx-toastr";


@Component({
  selector: 'app-create-feedback',
  templateUrl: './create-feedback.component.html',
  styleUrls: ['./create-feedback.component.css']
})
export class CreateFeedbackComponent implements OnInit {
  currentDate = new Date();
  rating: number[] = [1, 2, 3, 4, 5];
  value: number = 0;
  feedbackFrom: FormGroup;
  selectedImage: any = null;
  isLoading: Boolean = false;



  constructor(private feedbackService: FeedbackService,
              private angularFireStorage: AngularFireStorage,
              private toastrService: ToastrService) {
    this.getFeedbackForm();
  }

  ngOnInit(): void {
    this.getFeedbackForm();
  }

  getValue(rating: number) {
    this.value = rating;
  }

  getFeedbackForm() {
    this.feedbackFrom = new FormGroup({
      creator: new FormControl("",
        [Validators.required, Validators.minLength(2), Validators.maxLength(30),
          Validators.pattern("^([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
            "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*( ))*" +
            "([A-ZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẬẪÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]" +
            "[a-záàảãạăắằẳẵặâấầẩậẫéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđ]*)$")]),
      email: new FormControl("", [Validators.required, Validators.email,
        Validators.minLength(5), Validators.maxLength(320)]),
      content: new FormControl("", [Validators.required, Validators.minLength(2)]),
      rating: new FormControl( this.value),
      image: new FormControl("", [Validators.required])
    })
  }


  save() {
    if (this.feedbackFrom.valid) {
      this.toggleLoading();
      const imgName = this.getCurrentDateTime() + this.selectedImage.name;
      const fileRef = this.angularFireStorage.ref(imgName);
      const feedback = this.feedbackFrom.value;
      feedback.rating = this.value;

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
                $('#staticBackdrop').modal('hide');
              }, error => {
                console.log(error.error);
                let errs = error.error;
              })
          })
        })
      ).subscribe();
    } else {
      this.showToastrWarning();
    }
  }

  private getCurrentDateTime(): string {
    return formatDate(new Date(), 'ddMMyyyy_hh:mm:ssa_', 'en-US');
  }

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
  }

  toggleLoading() {
    this.isLoading = true;~
    setTimeout(() => {
      this.isLoading = false;
    }, 3000)
  }

  showToastrSuccess() {
    this.toastrService.success('Thành công!', 'Gửi phản hồi');
  }
  showToastrWarning(){
    this.toastrService.warning("Vui lòng nhập đầy đủ thông tin!")
  }
}
