# Kafka Topics

Kafka runs via `docker-compose.yml`.

- In-app bootstrap servers: `localhost:29092`
- Kafka UI: `http://localhost:8080`

## Topics

### `user-created-events`

- Producer: `user-service` (see `user-service/src/main/java/com/ecommerce/user_service/service/UserService.java`)
- Consumer: `product-service` (see `product-service/src/main/java/com/ecommerce/product_service/service/UserEventListener.java`)

Notes:

- The topic is also declared via Spring Kafka admin in `user-service/src/main/java/com/ecommerce/user_service/config/KafkaTopicConfig.java`.

### `order-created`

- Producer: `order-service` (see `order-service/src/main/java/com/ecommerce/order_service/service/OrderService.java`)
- Consumers: none yet

Notes:

- `order-service/src/main/resources/application.yml` currently defines `spring.kafka.topic.order-created: order-created-events` but the producer sends to `order-created` directly. Align these before relying on the config.

## Inspecting Messages

Use Kafka UI (`http://localhost:8080`) to browse topics and messages.
