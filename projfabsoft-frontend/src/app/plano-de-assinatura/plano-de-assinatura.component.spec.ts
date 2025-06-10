import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanoDeAssinaturaComponent } from './plano-de-assinatura.component';

describe('PlanoDeAssinaturaComponent', () => {
  let component: PlanoDeAssinaturaComponent;
  let fixture: ComponentFixture<PlanoDeAssinaturaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlanoDeAssinaturaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlanoDeAssinaturaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
