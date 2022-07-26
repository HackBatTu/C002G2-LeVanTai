import {Component, OnInit} from '@angular/core';
import {Todo} from './todo';
import {FormControl} from '@angular/forms';
import {TodoService} from '../service/todo.service';
import {Router} from '@angular/router';

// tslint:disable-next-line:variable-name
let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();

  constructor(private todoService: TodoService, private router: Router) {
  }

  ngOnInit(): void {
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todoService.create(todo).subscribe(data => {
      }, error => {
      }, () => {
        this.router.navigate(['/product-list']);
      });
      this.content.reset();
    }
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }
}
