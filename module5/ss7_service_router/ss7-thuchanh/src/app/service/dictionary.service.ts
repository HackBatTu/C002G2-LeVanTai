import {Injectable} from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaries: Dictionary[] = [];

  constructor() {
    this.dictionaries.push(
      {vietnamese: 'Phương', english: 'DOG'},
      {vietnamese: 'Luận', english: 'Cat'},
      {vietnamese: 'Bình', english: 'Mickey'},
      {vietnamese: 'Hậu', english: 'Chicken'},
      {vietnamese: 'Phúc', english: 'mouse'},
      {vietnamese: 'Diệp', english: 'bird'}
      );
  }

  findAll() {
    return this.dictionaries;
  }
}
