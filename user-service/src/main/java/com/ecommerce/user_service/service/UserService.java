package com.ecommerce.user_service.service;

import com.ecommerce.user_service.model.User;
import com.ecommerce.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
/*
    * Service class for managing users.
    * Handles user registration and password encoding.
    * Publishes user creation events to Kafka topic "user-created-events".
    *
*/
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final KafkaTemplate<String, User> kafkaTemplate;



    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userRepository.save(user);

        kafkaTemplate.send("user-created-events", saved);

        return saved;
    }
}
