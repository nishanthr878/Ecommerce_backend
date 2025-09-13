package com.ecommerce.user_service.repository;

import com.ecommerce.user_service.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/*
    * Repository interface for User entity.
    * Extends MongoRepository to provide CRUD operations.
    * Custom query methods: findByUsername, findByEmail
*/
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
