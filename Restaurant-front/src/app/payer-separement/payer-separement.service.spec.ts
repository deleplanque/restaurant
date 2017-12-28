import { TestBed, inject } from '@angular/core/testing';

import { PayerSeparementService } from './payer-separement.service';

describe('PayerSeparementService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PayerSeparementService]
    });
  });

  it('should be created', inject([PayerSeparementService], (service: PayerSeparementService) => {
    expect(service).toBeTruthy();
  }));
});
