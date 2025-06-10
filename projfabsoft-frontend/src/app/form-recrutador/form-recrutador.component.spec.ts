import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRecrutadorComponent } from './form-recrutador.component';

describe('FormRecrutadorComponent', () => {
  let component: FormRecrutadorComponent;
  let fixture: ComponentFixture<FormRecrutadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormRecrutadorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormRecrutadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
