import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalCreationPlatComponent } from './modal-creation-plat.component';

describe('ModalCreationPlatComponent', () => {
  let component: ModalCreationPlatComponent;
  let fixture: ComponentFixture<ModalCreationPlatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalCreationPlatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalCreationPlatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
