import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YesterdayHistoryComponent } from './yesterday-history.component';

describe('YesterdayHistoryComponent', () => {
  let component: YesterdayHistoryComponent;
  let fixture: ComponentFixture<YesterdayHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YesterdayHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YesterdayHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
