import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsignmentEditComponent } from './consignment-edit.component';

describe('ConsignmentEditComponent', () => {
  let component: ConsignmentEditComponent;
  let fixture: ComponentFixture<ConsignmentEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsignmentEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsignmentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
