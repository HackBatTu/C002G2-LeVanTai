import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOrderManagementComponent } from './list-order-management.component';

describe('ListOrderManagementComponent', () => {
  let component: ListOrderManagementComponent;
  let fixture: ComponentFixture<ListOrderManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListOrderManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOrderManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
