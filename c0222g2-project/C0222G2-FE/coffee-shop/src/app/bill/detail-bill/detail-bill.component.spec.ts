import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailBillComponent } from './detail-bill.component';

describe('DetailBillComponent', () => {
  let component: DetailBillComponent;
  let fixture: ComponentFixture<DetailBillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailBillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
