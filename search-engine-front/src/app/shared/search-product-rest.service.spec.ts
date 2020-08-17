import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from "@angular/common/http/testing";
import { SearchProductRestService } from './search-product-rest.service';
import { HttpClient } from '@angular/common/http';
import { of, Observable, throwError } from 'rxjs';
import { Product } from './product';

describe('SearchProductRestService', () => {
  let service: SearchProductRestService;
  let httpClient: HttpClient;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ]
    });
    service = TestBed.inject(SearchProductRestService);
    httpClient = TestBed.inject(HttpClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should call get api Search Engine APP', () => {
    spyOn(httpClient, 'get').and.callFake(() => {
      return of(Observable.create(Product));
    });
    const search = {search : '181'};

    service.getProductsBySearch(search);
    expect(service).toBeTruthy();
  });

  it('should call get api Search Engine APP and return error', () => {
    spyOn(service, 'handleError').and.callThrough();
    let error = 'Ha ocurrido un error';
    service.handleError(error);
    expect(service.handleError).toHaveBeenCalled();
  });
});
