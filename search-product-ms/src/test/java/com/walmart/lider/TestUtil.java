package com.walmart.lider;

import com.google.gson.Gson;
import com.walmart.lider.controller.Search;
import com.walmart.lider.model.Products;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.http.MediaType;

public class TestUtil {

  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
      MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

  public String convertToJson(Object object) {
    final Gson gson = new Gson();
    return gson.toJson(object);
  }

  public static List<Products> getProductList(){
    List<Products> productsList = new ArrayList<>();
    productsList.add(getProductNumeric());
    return productsList;
  }

  public static Products getProductNumeric(){
    return Products.builder()
        ._id(new ObjectId())
        .code(181L)
        .brand("Brand Name abba")
        .description("abba Description")
        .price(12345)
        .image("/lider/prueba.svg")
        .build();
  }

  public static Search getSearchNumeric(){
    return Search.builder().search("181").build();
  }

  public static Search getSearchCharacter(boolean flagPalindrome){
    return Search.builder().search(flagPalindrome ? "assa" : "qwerty").build();
  }
}
