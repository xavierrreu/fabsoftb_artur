import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormProjetoComponent } from './form-projeto.component';

describe('FormProjetoComponent', () => {
  let component: FormProjetoComponent;
  let fixture: ComponentFixture<FormProjetoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormProjetoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormProjetoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
