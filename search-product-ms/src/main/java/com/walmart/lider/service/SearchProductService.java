package com.walmart.lider.service;

import com.walmart.lider.model.Products;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SearchProductService {

  Products getProductById(Long idProducto);
  List<Products> getAllProducts();
}
