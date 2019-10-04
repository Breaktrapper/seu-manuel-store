package com.seumanuel.store.repository;

<<<<<<< HEAD
=======

>>>>>>> f939ed70515641b0f332abaf24b1fdccea1b9e4c
import com.seumanuel.store.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {


    Product findByName(String name);

    List<Product> findAllByPriceBetween(BigDecimal min, BigDecimal max);
=======
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

>>>>>>> f939ed70515641b0f332abaf24b1fdccea1b9e4c
}
