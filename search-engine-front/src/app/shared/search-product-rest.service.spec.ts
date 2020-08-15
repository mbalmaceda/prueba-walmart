import { TestBed } from '@angular/core/testing';

import { SearchProductRestService } from './search-product-rest.service';

describe('SearchProductRestService', () => {
  let service: SearchProductRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchProductRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
