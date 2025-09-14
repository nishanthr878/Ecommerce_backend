package com.ecommerce.product_service.service;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    * ProductService handles business logic for product management.
    * It provides methods to add, retrieve, and delete products.
    * The service uses ProductRepository for database operations and KafkaTemplate to send events.
    * Methods:
    * - addProduct: Saves a new product and sends a creation event to Kafka.
    * - getAllProducts: Retrieves all products from the database.
    * - getProductById: Retrieves a product by its ID.
    * - deleteProduct: Deletes a product by its ID.
    * The service is annotated with @Service and uses Lombok's @RequiredArgsConstructor for dependency injection.
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Product addProduct(Product product) {
        Product saved = productRepository.save(product);
        kafkaTemplate.send("product-created-events", saved);
        return saved;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
