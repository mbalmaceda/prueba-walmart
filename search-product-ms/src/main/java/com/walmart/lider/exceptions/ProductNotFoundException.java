package com.walmart.lider.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
  public ProductNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}
