import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonCreatePageComponent } from './person-create-page.component';

describe('PersonCreatePageComponent', () => {
  let component: PersonCreatePageComponent;
  let fixture: ComponentFixture<PersonCreatePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonCreatePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonCreatePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
