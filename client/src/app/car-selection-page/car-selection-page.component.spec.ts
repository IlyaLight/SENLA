import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarSelectionPageComponent } from './car-selection-page.component';

describe('CarSelectionPageComponent', () => {
  let component: CarSelectionPageComponent;
  let fixture: ComponentFixture<CarSelectionPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarSelectionPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarSelectionPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
