package com.walmart.lider.controller;

import com.walmart.lider.service.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class SearchEngineController {

  @Autowired
  private SearchProductService searchProductService;

  @GetMapping(name = "/", produces = "application/json")
  public ResponseEntity getAllProducts(){
    return ResponseEntity.ok(searchProductService.getAllProducts());
  }
}
