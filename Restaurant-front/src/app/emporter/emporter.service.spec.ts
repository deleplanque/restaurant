import { TestBed, inject } from '@angular/core/testing';

import { EmporterService } from './emporter.service';

describe('EmporterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmporterService]
    });
  });

  it('should be created', inject([EmporterService], (service: EmporterService) => {
    expect(service).toBeTruthy();
  }));
});
