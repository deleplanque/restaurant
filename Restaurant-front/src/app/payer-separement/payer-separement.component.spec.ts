import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PayerSeparementComponent } from './payer-separement.component';

describe('PayerSeparementComponent', () => {
  let component: PayerSeparementComponent;
  let fixture: ComponentFixture<PayerSeparementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PayerSeparementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PayerSeparementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
