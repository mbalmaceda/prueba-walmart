import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { SearchProductRestService } from "../shared/search-product-rest.service";
import { ProductsListComponent } from './products-list.component';
import { HttpClientTestingModule } from "@angular/common/http/testing";

describe('ProductsListComponent', () => {
  let component: ProductsListComponent;
  let fixture: ComponentFixture<ProductsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductsListComponent ],
      providers:[SearchProductRestService],
      imports: [HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
