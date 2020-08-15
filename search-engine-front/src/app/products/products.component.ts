import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductsService } from '../service/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  @Input()
  result$: Observable<any>;

  constructor(private productService: ProductsService) { 
    this.result$ = productService.searchProducts("181");
  }

  ngOnInit(): void {
  }

}
