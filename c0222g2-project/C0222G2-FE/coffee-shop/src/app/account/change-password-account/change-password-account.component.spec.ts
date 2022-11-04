import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangePasswordAccountComponent } from './change-password-account.component';

describe('ChangePasswordAccountComponent', () => {
  let component: ChangePasswordAccountComponent;
  let fixture: ComponentFixture<ChangePasswordAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangePasswordAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangePasswordAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
