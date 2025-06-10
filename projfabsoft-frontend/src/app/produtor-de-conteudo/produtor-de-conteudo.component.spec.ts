import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutorDeConteudoComponent } from './produtor-de-conteudo.component';

describe('ProdutorDeConteudoComponent', () => {
  let component: ProdutorDeConteudoComponent;
  let fixture: ComponentFixture<ProdutorDeConteudoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProdutorDeConteudoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdutorDeConteudoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
