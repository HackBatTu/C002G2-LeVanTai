import { Component, OnInit } from '@angular/core';
import {Dictionary} from "../model/dictionary";
import {DictionaryService} from "../service/dictionary.service";

@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {
  dictionary: Dictionary = {
    vietnamese: '',
    english: ''
  };
  dictionaries: Dictionary[] = [];
  constructor(private dictionaryService: DictionaryService) {
    this.dictionaries = this.dictionaryService.findAll();
  }

  ngOnInit(): void {
  }
  translate(value: string) {
    value = value.toLowerCase();
    if (this.dictionaries.filter((data) => data.vietnamese.toLowerCase() === value)[0] !== undefined) {
      this.dictionary = this.dictionaries.filter((data) => data.vietnamese.toLowerCase() === value)[0];
    } else {
      this.dictionary.english = 'Not found';
    }
  }


}
