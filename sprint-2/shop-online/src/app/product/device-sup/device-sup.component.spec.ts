import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeviceSupComponent } from './device-sup.component';

describe('DeviceSupComponent', () => {
  let component: DeviceSupComponent;
  let fixture: ComponentFixture<DeviceSupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeviceSupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeviceSupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
