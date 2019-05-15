import { TestBed } from '@angular/core/testing';

import { BicicletasService } from './bicicletas.service';

describe('BicicletasService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BicicletasService = TestBed.get(BicicletasService);
    expect(service).toBeTruthy();
  });
});
