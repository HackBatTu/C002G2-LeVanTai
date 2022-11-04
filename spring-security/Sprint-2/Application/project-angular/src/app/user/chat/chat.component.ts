import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {map} from 'rxjs/operators';
import {FirebaseChat} from '../model/firebase-chat';
import {FirebaseChatService} from '../service/firebase-chat.service';
import {AuthService} from '../service/auth.service';
import {Customer} from '../model/customer';
import {AppUser} from '../model/appUser';
import {Subscription} from 'rxjs';
import {CustomerService} from '../service/customer.service';
import {CommonService} from '../service/common.service';

declare var $: any;

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  @ViewChild('chathistory') chathistory: ElementRef;
  scrolltop: number = null;
  currentUserName: string = '';
  currentUserId: number;
  secondUserName = '';
  secondImage = 'https://bootdey.com/img/Content/avatar/avatar1.png';
  chatUserId: number;
  userNames: string[] = [];
  appUsers: AppUser[] = [];
  message = '';
  messages: FirebaseChat[] = [];
  chat = {
    chatId: 0,
    message: '',
    username: '',
    date: new Date().toLocaleDateString('vi-VN'),
    time: new Date().toLocaleTimeString('vi-VN')
  };
  chatCode = '';
  dateNow: string = new Date().toLocaleDateString('vi-VN');
  timeNow = new Date().toLocaleTimeString('vi-VN').slice(0, 5);

  public role: string;
  public loginStatus: any;
  customer: Customer;
  messageReceived: any;
  private subscriptionName: Subscription;
  appUser: AppUser;


  constructor(private firebaseChat: FirebaseChatService,
              private authService: AuthService,
              private customerService: CustomerService,
              private commonService: CommonService) {
    this.authService.checkLogin().subscribe(value => {
      this.loginStatus = value;
      if (value) {
        this.authService.getRoles().subscribe(resp => {
          this.getRole(resp);
          this.getCustomerByUsername(resp.username);
        }, error => {
        });
      }
    }, error => {
    });
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
    });
  }

  getRole(value: any) {
    if (this.isAdmin(value.grantList)) {
      this.role = 'ROLE_ADMIN';
    } else if (this.isUser(value.grantList)) {
      this.role = 'ROLE_USER';
    }
    this.currentUserName = value.username;
  }

  isAdmin(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_ADMIN';
    });
  }

  isUser(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_USER';
    });
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUsername(username).subscribe(c => {
      this.customer = c;
      this.customerService.getAppUserFromUsername(username).subscribe((au: any) => {
        this.appUser = au;
        this.currentUserId = au.id;
        this.currentUserName = au.userName;
      });
    }, error => {
    }, () => {
      this.getAllUser();
    });
  }

  ngOnInit(): void {
  }

  getAllUser() {
    this.authService.getAllUsers().subscribe((res: AppUser[]) => {
      for (const user of res) {
        this.customerService.getCustomerByUsername(user.userName).subscribe(value => {
          user.customer = value;
        });
        if (this.role == 'ROLE_ADMIN') {
          if (user.userName != this.currentUserName) {
            this.appUsers.push(user);
            this.userNames.push(user.userName);
          }
        } else {
          if (user.userName == 'admin') {
            this.appUsers.push(user);
            this.userNames.push(user.userName);
          }
        }
      }
    }, error => {
    }, () => {

      this.customerService.getCustomerByUsername(this.appUsers[0].userName).subscribe(value => {
        if (value != null) {
          this.secondUserName = value.name;
          this.secondImage = value.image;
        } else {
          this.secondUserName = this.appUsers[0].userName;
          this.secondImage = 'https://bootdey.com/img/Content/avatar/avatar1.png';
        }
      }, error => {
      }, () => {
        this.chatUserId = this.appUsers[0].id;
        $('#box-user-' + this.appUsers[0].id).attr('class', 'clearfix active');
        this.setChatCode();
        this.getAllMessages();
      });
    });

  }

  getAllMessages() {
    this.firebaseChat.getAll(this.chatCode).snapshotChanges().pipe(
      map(changes => changes.map(c => ({key: c.payload.key, ...c.payload.val()}
      )))).subscribe(messages => {
      for (const mes of messages) {
        mes.time = mes.time.slice(0, 5);
      }
      this.messages = messages;
      setTimeout(() => this.scrolltop = this.chathistory.nativeElement.scrollHeight, 10);
    });
  }

  sendMessage() {
    this.chat.username = this.currentUserName;
    this.chat.message = this.message;
    this.chat.date = new Date().toLocaleDateString('vi-VN');
    this.chat.time = new Date().toLocaleTimeString('vi-VN');
    this.setChatCode();
    if (this.messages.length > 0) {
      this.chat.chatId = this.messages[this.messages.length - 1].chatId + 1;
    }
    this.firebaseChat.send(this.chat, this.chatCode, this.chat.chatId);
    this.message = '';
  }

  setSecondUserName(item: AppUser) {
    $('[id|=\'box-user\']').attr('class', 'clearfix');
    $('#box-user-' + item.id).attr('class', 'clearfix active');
    if (item.customer != null) {
      this.secondUserName = item.customer.name;
      this.secondImage = item.customer.image;
    } else {
      this.secondUserName = item.userName;
      this.secondImage = 'https://bootdey.com/img/Content/avatar/avatar1.png';
    }
    for (const user of this.appUsers) {
      if (user.customer != null) {
        if (user.customer.name == this.secondUserName) {
          this.chatUserId = user.id;
        }
      } else {
        if (user.userName == this.secondUserName) {
          this.chatUserId = user.id;
        }
      }
    }
    this.setChatCode();
    this.getAllMessages();
  }

  setChatCode() {
    if (this.currentUserId < this.chatUserId) {
      this.chatCode = this.currentUserId + '' + this.chatUserId;
    } else {
      this.chatCode = this.chatUserId + '' + this.currentUserId;
    }
  }
}
