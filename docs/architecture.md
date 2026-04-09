# Architecture

This repo is a Gradle multi-module Spring Boot microservices setup.

## Modules

- `user-service/`: user registration; MongoDB; publishes a user-created event to Kafka
- `product-service/`: product CRUD; MongoDB; listens for user-created events (demo integration)
- `order-service/`: order placement; MongoDB; publishes an order-created event to Kafka
- `api-gateway/`: Spring Cloud Gateway (WebMVC); routing not configured yet
- `cart-service/`, `payment-service/`, `notification-service/`: scaffolds / placeholders

## Data Stores

Each service uses its own MongoDB database (see `*/src/main/resources/application.yml`).

## Async Messaging

Kafka is used for cross-service events.

- `user-service` publishes `user-created-events` after registration.
- `product-service` listens for user-created events (currently logs to stdout).
- `order-service` publishes an order-created event (topic naming is currently inconsistent; see `docs/kafka-topics.md`).

## API Documentation

Some services include `springdoc-openapi` for Swagger UI.
