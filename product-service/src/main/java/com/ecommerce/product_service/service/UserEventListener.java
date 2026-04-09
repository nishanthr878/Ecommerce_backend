package com.ecommerce.product_service.service;

import com.ecommerce.product_service.event.UserCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventListener {
    @KafkaListener(
            topics = "${spring.kafka.topic.user-created}",
            groupId = "product-service-group",
            containerFactory = "userKafkaListenerFactory"
    )
    public void handleUserCreated(UserCreatedEvent event) {
        System.out.println("Received user created event: " + event);
    }
}
