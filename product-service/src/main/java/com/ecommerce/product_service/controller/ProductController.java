package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
    * ProductController handles HTTP requests for product management.
    * It provides endpoints to add, retrieve, and delete products.
    * The controller uses ProductService to perform business logic.
    * Endpoints:
    * - POST /api/products: Add a new product.
    * - GET /api/products: Retrieve all products.
    * - GET /api/products/{id}: Retrieve a product by its ID.
    * - DELETE /api/products/{id}: Delete a product by its ID.
    * All endpoints return appropriate HTTP responses.
    * The controller is annotated with @RestController and @RequestMapping for routing.
    * It uses Lombok's @RequiredArgsConstructor for dependency injection.
    * The Product model represents the product entity.
    * The ProductService interface defines the business logic for product operations.
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
