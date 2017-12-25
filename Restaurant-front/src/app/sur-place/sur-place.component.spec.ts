import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SurPlaceComponent } from './sur-place.component';

describe('SurPlaceComponent', () => {
  let component: SurPlaceComponent;
  let fixture: ComponentFixture<SurPlaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SurPlaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SurPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
