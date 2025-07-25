import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecrutadorComponent } from './recrutador.component';

describe('RecrutadorComponent', () => {
  let component: RecrutadorComponent;
  let fixture: ComponentFixture<RecrutadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecrutadorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecrutadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
