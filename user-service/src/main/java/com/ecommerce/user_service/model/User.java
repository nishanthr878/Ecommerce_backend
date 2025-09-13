package com.ecommerce.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/*
    * User entity representing a user in the system.
    * Fields: id, username, email, password, role
    * Annotations: @Document, @Data, @AllArgsConstructor, @NoArgsConstructor, @Builder
    * Uses Lombok to reduce boilerplate code.
    * Maps to MongoDB collection "users".
 */
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String role;

}
