import { TestBed } from '@angular/core/testing';

import { DishTypeService } from './dish-type.service';

describe('DishTypeService', () => {
  let service: DishTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DishTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
