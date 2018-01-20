import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalEditionComponent } from './modal-edition.component';

describe('ModalEditionComponent', () => {
  let component: ModalEditionComponent;
  let fixture: ComponentFixture<ModalEditionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalEditionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalEditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
