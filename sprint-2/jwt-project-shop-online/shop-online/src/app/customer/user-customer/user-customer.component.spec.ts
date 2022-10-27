import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCustomerComponent } from './user-customer.component';

describe('UserCustomerComponent', () => {
  let component: UserCustomerComponent;
  let fixture: ComponentFixture<UserCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
