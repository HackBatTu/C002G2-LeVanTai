import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FirebaseChat} from '../model/firebase-chat';
import { AngularFirestore } from '@angular/fire/firestore';
import {AngularFireDatabase, AngularFireList} from '@angular/fire/database';

@Injectable({
  providedIn: 'root'
})
export class FirebaseChatService {
  private dbPath = '/chats';
  chatsRef: AngularFireList<FirebaseChat> = null;

  constructor(private http: HttpClient,
              private fireStore: AngularFirestore,
              private db: AngularFireDatabase) {
  }

  getAll(chatCode: string): AngularFireList<FirebaseChat> {
    this.dbPath = '/chats/' + chatCode;
    this.chatsRef = this.db.list(this.dbPath);
    return this.chatsRef;
  }

  send(chat: FirebaseChat, chatCode: string, chatId: number): void {
    this.db.database.ref('chats/' + chatCode + '/' + chatId).set({
      chatId: chat.chatId,
      username: chat.username,
      message: chat.message,
      date: chat.date,
      time: chat.time
    });
  }
}
