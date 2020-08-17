import { Component, Input } from '@angular/core';
import { SearchProductRestService } from "../shared/search-product-rest.service";
import { Product } from '../shared/product';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.scss']
})
export class ProductsListComponent {
  private _search;
  private apiURL = environment.urlImagesLider;

  get search(): any {
    return this._search;
  }

  @Input()
  set search(val:any) {
    this._search = val;
    if(this._search.search){
      this.searchProductRest.getProductsBySearch(this.search).subscribe(data => {
        this.productsList = data;
        this.productsList.map(p => {
          const imgSplit = p.image.split("/");
          p.imageName = this. apiURL + imgSplit[imgSplit.length -1];
        })
      });
    }
  }

  productsList: Product[] = [];

  constructor(public searchProductRest: SearchProductRestService) { }

}
