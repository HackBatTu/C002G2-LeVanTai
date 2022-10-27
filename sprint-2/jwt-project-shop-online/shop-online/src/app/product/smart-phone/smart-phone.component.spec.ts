import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartPhoneComponent } from './smart-phone.component';

describe('SmartPhoneComponent', () => {
  let component: SmartPhoneComponent;
  let fixture: ComponentFixture<SmartPhoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmartPhoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmartPhoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
