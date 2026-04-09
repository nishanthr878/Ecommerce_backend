package com.ecommerce.order_service.service;

import com.ecommerce.order_service.event.OrderCreatedEvent;
import com.ecommerce.order_service.model.Order;
import com.ecommerce.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public Order placeOrder(Order order) {
        order.setStatus("CREATED");
        Order savedOrder = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
                savedOrder.getId(),
                savedOrder.getUserId(),
                savedOrder.getProductId(),
                savedOrder.getQuantity(),
                savedOrder.getPrice()
        );

        kafkaTemplate.send("order-created", event);
        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
