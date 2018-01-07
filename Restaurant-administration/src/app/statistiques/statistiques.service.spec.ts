import { TestBed, inject } from '@angular/core/testing';

import { StatistiquesService } from './statistiques.service';

describe('StatistiquesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StatistiquesService]
    });
  });

  it('should be created', inject([StatistiquesService], (service: StatistiquesService) => {
    expect(service).toBeTruthy();
  }));
});
