package com.walmart.lider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {

  @Id
  private ObjectId _id;
  @Indexed(unique = true)
  @Field(name = "id")
  private Long code;
  private String brand;
  private String description;
  private String image;
  private Integer price;
  private Integer priceDiscount;
}
;