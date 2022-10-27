import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInfoUserComponent } from './add-info-user.component';

describe('AddInfoUserComponent', () => {
  let component: AddInfoUserComponent;
  let fixture: ComponentFixture<AddInfoUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddInfoUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddInfoUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
