package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.model.User;
import com.ecommerce.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
    * UserController handles user-related HTTP requests such as registration.
    * It uses UserService to perform business logic.
    * Endpoints:
    * - POST /api/users/register: Registers a new user.
    * Returns the registered user details.
    * All endpoints are publicly accessible.
    * No authentication required.
    * Uses Lombok's @RequiredArgsConstructor for dependency injection.
    * Annotated with @RestController and @RequestMapping for RESTful API handling.
    * ResponseEntity is used to build HTTP responses.
    * RequestBody is used to map request payloads to User objects.
    * UserService is injected to handle user registration logic.
    * User model represents the user entity.
    * The controller is part of the user-service module in an e-commerce application.
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
}
