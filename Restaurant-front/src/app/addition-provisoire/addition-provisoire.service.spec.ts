import { TestBed, inject } from '@angular/core/testing';

import { AdditionProvisoireService } from './addition-provisoire.service';

describe('AdditionProvisoireService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdditionProvisoireService]
    });
  });

  it('should be created', inject([AdditionProvisoireService], (service: AdditionProvisoireService) => {
    expect(service).toBeTruthy();
  }));
});
