import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormProdutorComponent } from './form-produtor.component';

describe('FormProdutorComponent', () => {
  let component: FormProdutorComponent;
  let fixture: ComponentFixture<FormProdutorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormProdutorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormProdutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
