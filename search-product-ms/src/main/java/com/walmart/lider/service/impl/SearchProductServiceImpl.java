package com.walmart.lider.service.impl;

import com.walmart.lider.model.Products;
import com.walmart.lider.repository.ProductRepository;
import com.walmart.lider.service.SearchProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchProductServiceImpl implements SearchProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Products getProductById() {
    return null;
  }

  @Override
  public List<Products> getAllProducts() {
    return productRepository.findAll();
  }
}
