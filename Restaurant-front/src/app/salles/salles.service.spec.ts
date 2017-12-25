import { TestBed, inject } from '@angular/core/testing';

import { SallesService } from './salles.service';

describe('SallesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SallesService]
    });
  });

  it('should be created', inject([SallesService], (service: SallesService) => {
    expect(service).toBeTruthy();
  }));
});
