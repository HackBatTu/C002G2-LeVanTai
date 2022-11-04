import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDishTypeComponent } from './list-dish-type.component';

describe('ListDishTypeComponent', () => {
  let component: ListDishTypeComponent;
  let fixture: ComponentFixture<ListDishTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDishTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDishTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
