package com.walmart.lider.repository;

import com.walmart.lider.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Products,Integer> {

}
