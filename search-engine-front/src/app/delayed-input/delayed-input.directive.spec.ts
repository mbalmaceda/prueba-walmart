import { DelayedInputDirective } from './delayed-input.directive';
import { TestBed, ComponentFixture } from '@angular/core/testing';
import { ElementRef } from '@angular/core';

describe('DelayedInputDirective', () => {
  let directive: DelayedInputDirective;
  let elementRef: ElementRef<HTMLInputElement>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        DelayedInputDirective
      ]
    });
    directive = new DelayedInputDirective(elementRef);
  });

  it('should create an instance', () => {
    expect(directive).toBeTruthy();
  });

});
