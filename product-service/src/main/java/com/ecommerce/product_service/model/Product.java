package com.ecommerce.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
    * Product represents a product entity in the e-commerce system.
    * It contains fields for id, name, description, category, price, and stock.
    * The class is annotated with @Document to map it to a MongoDB collection.
    * Lombok annotations are used to generate boilerplate code like getters, setters, constructors, and builder methods.
 */
@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer stock;
}
