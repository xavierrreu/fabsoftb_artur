import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TesteDeHabilidadeComponent } from './teste-de-habilidade.component';

describe('TesteDeHabilidadeComponent', () => {
  let component: TesteDeHabilidadeComponent;
  let fixture: ComponentFixture<TesteDeHabilidadeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TesteDeHabilidadeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TesteDeHabilidadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
