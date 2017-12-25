import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdditionProvisoireComponent } from './addition-provisoire.component';

describe('AdditionProvisoireComponent', () => {
  let component: AdditionProvisoireComponent;
  let fixture: ComponentFixture<AdditionProvisoireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdditionProvisoireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdditionProvisoireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
