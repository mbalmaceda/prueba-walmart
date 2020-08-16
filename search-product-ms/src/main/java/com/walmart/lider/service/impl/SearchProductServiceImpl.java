package com.walmart.lider.service.impl;

import com.walmart.lider.controller.Search;
import com.walmart.lider.exceptions.ProductNotFoundException;
import com.walmart.lider.model.Products;
import com.walmart.lider.repository.ProductRepository;
import com.walmart.lider.service.SearchProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchProductServiceImpl implements SearchProductService {

  private final static int dcto = 50;

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Products> getProductBySearch(Search search) {
    List<Products> productsList = findProductBySearchString(search.getSearch(),
        search.isSearchNumeric());
    return search.isPalindrome() ? palindromeDiscount(productsList) : productsList;
  }

  private List<Products> findProductBySearchString(String searchString, boolean isNumeric) {
    if (isNumeric) {
      List<Products> productsList = new ArrayList<>();
      productsList.add(productRepository.findByCode(Long.valueOf(searchString))
          .orElseThrow(() -> new ProductNotFoundException(searchString)));
      return productsList;
    } else {
      return productRepository.findByBrandContaining(searchString)
          .and(productRepository.findByDescriptionContaining(searchString)).toList();
    }
  }

  private List<Products> palindromeDiscount(List<Products> productsList) {
    return productsList.stream()
        .map(p -> Products.builder()
            ._id(p.get_id()).code(p.getCode()).brand(p.getBrand()).description(p.getDescription())
            .image(p.getImage()).price(p.getPrice()).priceDiscount((p.getPrice() * dcto) / 100)
            .build())
        .collect(Collectors.toList());
  }
}
