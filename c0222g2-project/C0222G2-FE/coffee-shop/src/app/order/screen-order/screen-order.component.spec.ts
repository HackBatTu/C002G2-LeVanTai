import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScreenOrderComponent } from './screen-order.component';

describe('ScreenOrderComponent', () => {
  let component: ScreenOrderComponent;
  let fixture: ComponentFixture<ScreenOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScreenOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScreenOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
