import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostAlertModalPage } from './post-alert-modal.page';

describe('PostAlertModalPage', () => {
  let component: PostAlertModalPage;
  let fixture: ComponentFixture<PostAlertModalPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostAlertModalPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostAlertModalPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
