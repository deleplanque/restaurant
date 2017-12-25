import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmporterComponent } from './emporter.component';

describe('EmporterComponent', () => {
  let component: EmporterComponent;
  let fixture: ComponentFixture<EmporterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmporterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmporterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
