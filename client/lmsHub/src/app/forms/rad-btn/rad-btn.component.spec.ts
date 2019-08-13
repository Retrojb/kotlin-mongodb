import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RadBtnComponent } from './rad-btn.component';

describe('RadBtnComponent', () => {
  let component: RadBtnComponent;
  let fixture: ComponentFixture<RadBtnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RadBtnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RadBtnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
