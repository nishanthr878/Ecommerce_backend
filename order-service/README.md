# order-service

Order placement service backed by MongoDB. When an order is created, it publishes an order-created event to Kafka.

## Run

1) Start infra:

```bash
docker compose up -d
```

2) Start the service:

```bash
./gradlew :order-service:bootRun
```

## Configuration

- Port: `8085` (see `order-service/src/main/resources/application.yml`)
- MongoDB: `ecommerce_orders` (URI in `order-service/src/main/resources/application.yml`)
- Kafka bootstrap: `localhost:29092`

## API

Base path: `/api/orders`

### Create order

`POST /api/orders/create`

```bash
curl -X POST "http://localhost:8085/api/orders/create" \
  -H "Content-Type: application/json" \
  -d '{
    "userId": "<userId>",
    "productId": "<productId>",
    "quantity": 1,
    "price": 12.99
  }'
```

### Get all orders

`GET /api/orders/get/all`

```bash
curl "http://localhost:8085/api/orders/get/all"
```

## Events

- Produces: `order-created`
  - Producer code: `order-service/src/main/java/com/ecommerce/order_service/service/OrderService.java`

## Known Issues

- Topic naming mismatch: `order-service/src/main/resources/application.yml` defines `spring.kafka.topic.order-created: order-created-events`, but the producer sends to `order-created` directly.

## Swagger

- UI: `http://localhost:8085/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8085/v3/api-docs`
