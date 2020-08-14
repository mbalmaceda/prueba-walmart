package com.walmart.lider.service.impl;

import com.walmart.lider.controller.Search;
import com.walmart.lider.exceptions.ProductNotFoundException;
import com.walmart.lider.model.Products;
import com.walmart.lider.repository.ProductRepository;
import com.walmart.lider.service.SearchProductService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchProductServiceImpl implements SearchProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Products getProductById(Long idProducto) {
    return productRepository.findByCode(idProducto)
        .orElseThrow(() -> new ProductNotFoundException(idProducto));
  }

  @Override
  public List<Products> getProductBySearch(Search search) {
    List<Products> productsList = new ArrayList<>();
    if (StringUtils.isNumeric(search.getSearch())) {
      productsList.add(productRepository.findByCode(Long.valueOf(search.getSearch()))
          .orElseThrow(() -> new ProductNotFoundException(search.getSearch())));
      return productsList;
    } else {
      return productsList;
    }
  }

  @Override
  public List<Products> getAllProducts() {
    return productRepository.findAll();
  }
}
