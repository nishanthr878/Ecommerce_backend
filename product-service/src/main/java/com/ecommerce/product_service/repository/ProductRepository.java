package com.ecommerce.product_service.repository;

import com.ecommerce.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
    * ProductRepository provides CRUD operations for Product entities.
    * It extends MongoRepository to leverage Spring Data MongoDB functionalities.
    * The repository interface allows interaction with the MongoDB database for product data.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
