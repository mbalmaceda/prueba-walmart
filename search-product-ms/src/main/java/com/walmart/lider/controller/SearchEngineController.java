package com.walmart.lider.controller;

import com.walmart.lider.model.Products;
import com.walmart.lider.service.SearchProductService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class SearchEngineController {

  @Autowired
  private SearchProductService searchProductService;

  @GetMapping("/products/all")
  public List<Products> getAllProducts() {
    return searchProductService.getAllProducts();
  }

  @GetMapping("/products/{idProduct}")
  public Products getProductByIdRequestParam(@PathVariable Long idProduct) {
    return searchProductService.getProductById(idProduct);
  }


  @GetMapping("/products")
  public List<Products> getAllProductsBySearchEngine(@RequestBody @Valid Search search) {
    log.info("Request search: ", search);
    return searchProductService.getProductBySearch(search);
  }
}
