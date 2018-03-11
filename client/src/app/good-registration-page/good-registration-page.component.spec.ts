import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoodRegistrationPageComponent } from './good-registration-page.component';

describe('GoodRegistrationPageComponent', () => {
  let component: GoodRegistrationPageComponent;
  let fixture: ComponentFixture<GoodRegistrationPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoodRegistrationPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoodRegistrationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
