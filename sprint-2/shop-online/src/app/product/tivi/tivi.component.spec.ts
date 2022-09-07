import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TiviComponent } from './tivi.component';

describe('TiviComponent', () => {
  let component: TiviComponent;
  let fixture: ComponentFixture<TiviComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TiviComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TiviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
