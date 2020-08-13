package com.walmart.lider.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Products {

  @Id
  private ObjectId _id;
  @Indexed(unique = true)
  private Integer id;
  private String brand;
  private String description;
  private String image;
  private Integer price;
}
