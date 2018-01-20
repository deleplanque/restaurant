import { TestBed, inject } from '@angular/core/testing';

import { ModelEditionService } from './model-edition.service';

describe('ModelEditionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ModelEditionService]
    });
  });

  it('should be created', inject([ModelEditionService], (service: ModelEditionService) => {
    expect(service).toBeTruthy();
  }));
});
