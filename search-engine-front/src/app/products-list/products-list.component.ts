import { Component, OnInit, Input, HostBinding } from '@angular/core';
import { SearchProductRestService } from "../shared/search-product-rest.service";
import { Observable } from 'rxjs';
import { Product } from '../shared/product';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.scss']
})
export class ProductsListComponent {
  private _search;
  
  @HostBinding("style.--some-var")
  private value: number;

  get search(): any {
    return this._search;
  }

  @Input()
  set search(val:any) {
    console.log('previous item = ', this._search);
    console.log('currently selected item=', val);
    this._search = val;
    this.searchProductRest.getProductsBySearch(this.search).subscribe(data => {
      this.productsList = data;
    });
  }

  productsList: Product[] = [];

  constructor(public searchProductRest: SearchProductRestService) { }

}
