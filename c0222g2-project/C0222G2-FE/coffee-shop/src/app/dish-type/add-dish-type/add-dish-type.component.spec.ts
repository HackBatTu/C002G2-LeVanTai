import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDishTypeComponent } from './add-dish-type.component';

describe('AddDishTypeComponent', () => {
  let component: AddDishTypeComponent;
  let fixture: ComponentFixture<AddDishTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDishTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDishTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
