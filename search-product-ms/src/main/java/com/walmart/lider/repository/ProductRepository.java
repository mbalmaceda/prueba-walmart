package com.walmart.lider.repository;

import com.walmart.lider.model.Products;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Products, Long> {
  Optional<Products> findByCode(Long idProduct);
  Streamable<Products> findByBrandContaining(String firstname);
  Streamable<Products> findByDescriptionContaining(String lastname);
}
