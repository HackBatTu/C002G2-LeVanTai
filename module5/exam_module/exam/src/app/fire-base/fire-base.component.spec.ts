import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FireBaseComponent } from './fire-base.component';

describe('FireBaseComponent', () => {
  let component: FireBaseComponent;
  let fixture: ComponentFixture<FireBaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FireBaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FireBaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
