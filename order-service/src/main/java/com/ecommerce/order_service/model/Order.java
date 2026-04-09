package com.ecommerce.order_service.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String userId;
    private String productId;
    private int quantity;
    private double price;
    private String status; // e.g., "PENDING", "COMPLETED", "CANCELLED"

}
