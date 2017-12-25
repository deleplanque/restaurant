import { TestBed, inject } from '@angular/core/testing';

import { SurPlaceService } from './sur-place.service';

describe('SurPlaceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SurPlaceService]
    });
  });

  it('should be created', inject([SurPlaceService], (service: SurPlaceService) => {
    expect(service).toBeTruthy();
  }));
});
