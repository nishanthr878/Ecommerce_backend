package com.ecommerce.product_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
    * UserCreatedEvent represents an event triggered when a new user is created.
    * It contains fields for id, username, and email.
    * The class uses Lombok annotations to generate boilerplate code like getters, setters, and constructors.
 */
public class UserCreatedEvent {
    private String id;
    private String username;
    private String email;
    private String password;
    private String role;
}
