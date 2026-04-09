package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.model.Order;
import com.ecommerce.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.placeOrder(order);
        return ResponseEntity.ok("Order creatd: " + order);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Order>> getOrder() {
        orderService.getAllOrders();

        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
