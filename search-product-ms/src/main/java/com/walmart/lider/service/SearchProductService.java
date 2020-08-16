package com.walmart.lider.service;

import com.walmart.lider.controller.Search;
import com.walmart.lider.model.Products;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SearchProductService {

  List<Products> getProductBySearch(Search search);
}
