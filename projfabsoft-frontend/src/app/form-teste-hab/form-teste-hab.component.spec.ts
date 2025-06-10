import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTesteHabComponent } from './form-teste-hab.component';

describe('FormTesteHabComponent', () => {
  let component: FormTesteHabComponent;
  let fixture: ComponentFixture<FormTesteHabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormTesteHabComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormTesteHabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
