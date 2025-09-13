package com.ecommerce.product_service.service;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
