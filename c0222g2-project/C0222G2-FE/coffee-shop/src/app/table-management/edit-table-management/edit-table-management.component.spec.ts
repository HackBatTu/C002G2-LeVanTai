import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTableManagementComponent } from './edit-table-management.component';

describe('EditTableManagementComponent', () => {
  let component: EditTableManagementComponent;
  let fixture: ComponentFixture<EditTableManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditTableManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTableManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
