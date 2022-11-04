import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDishTypeComponent } from './edit-dish-type.component';

describe('EditDishTypeComponent', () => {
  let component: EditDishTypeComponent;
  let fixture: ComponentFixture<EditDishTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditDishTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditDishTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
