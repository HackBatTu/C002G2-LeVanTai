import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTableManagementComponent } from './add-table-management.component';

describe('AddTableManagementComponent', () => {
  let component: AddTableManagementComponent;
  let fixture: ComponentFixture<AddTableManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddTableManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTableManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
