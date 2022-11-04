import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTableManagementComponent } from './list-table-management.component';

describe('ListTableManagementComponent', () => {
  let component: ListTableManagementComponent;
  let fixture: ComponentFixture<ListTableManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListTableManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListTableManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
