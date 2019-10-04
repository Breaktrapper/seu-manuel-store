package com.seumanuel.store.repository;

<<<<<<< HEAD

=======
import com.seumanuel.store.model.Order;
>>>>>>> f939ed70515641b0f332abaf24b1fdccea1b9e4c
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface OrderRepository extends MongoRepository {
=======
public interface OrderRepository extends MongoRepository<Order, String> {


>>>>>>> f939ed70515641b0f332abaf24b1fdccea1b9e4c
}
