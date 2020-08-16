import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from './product';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SearchProductRestService {
  apiURL = 'http://localhost:8089/api';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getAllProducts(): Observable<Product> {
    return this.http.get<Product>(this.apiURL + '/products/all')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  getProductsBySearch(search): Observable<Product[]> {
    console.log(JSON.stringify(search));
    return this.http.post<Product[]>(this.apiURL + '/products/', JSON.stringify(search), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  handleError(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
 }
}
