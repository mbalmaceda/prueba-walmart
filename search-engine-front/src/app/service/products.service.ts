import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  // URL which returns list of JSON items (API end-point URL)
  private readonly URL = 'http://localhost:8089/api/';

  constructor(private http: HttpClient) { }

  // create a method named: resolveItems()
  // this method returns list-of-items in form of Observable
  // every HTTTP call returns Observable object
  searchProducts(variable: String): Observable<any> {
    const headers =  {
      headers: new  HttpHeaders({ 
        'Content-Type': 'application/json'})
    };
    console.log('Request is sent!');
    // this.http is a HttpClient library provide by @angular/common
    // we are calling .get() method over this.http object
    // this .get() method takes URL to call API
    return this.http.post(this.URL+"products",{
      'search' : variable
    },headers);
  }
}
