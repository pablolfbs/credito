import { TestBed } from '@angular/core/testing';
import { CreditoService } from './credito.service';

describe('CreditoServiceService', () => {
  let service: CreditoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreditoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
