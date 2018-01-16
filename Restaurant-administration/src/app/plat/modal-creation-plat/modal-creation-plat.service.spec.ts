import { TestBed, inject } from '@angular/core/testing';

import { ModalCreationPlatService } from './modal-creation-plat.service';

describe('ModalCreationPlatService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ModalCreationPlatService]
    });
  });

  it('should be created', inject([ModalCreationPlatService], (service: ModalCreationPlatService) => {
    expect(service).toBeTruthy();
  }));
});
