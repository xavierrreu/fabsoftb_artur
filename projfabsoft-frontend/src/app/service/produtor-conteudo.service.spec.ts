import { TestBed } from '@angular/core/testing';

import { ProdutorConteudoService } from './produtor-conteudo.service';

describe('ProdutorConteudoService', () => {
  let service: ProdutorConteudoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProdutorConteudoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
