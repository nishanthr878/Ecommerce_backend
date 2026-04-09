# product-service

Product catalog service backed by MongoDB.

## Run

1) Start infra:

```bash
docker compose up -d
```

2) Start the service:

```bash
./gradlew :product-service:bootRun
```

## Configuration

- Port: `8082` (see `product-service/src/main/resources/application.yml`)
- MongoDB: `ecommerce_products` (URI in `product-service/src/main/resources/application.yml`)
- Kafka bootstrap: `localhost:29092`

## API

Base path: `/api/products`

### Add product

`POST /api/products`

```bash
curl -X POST "http://localhost:8082/api/products" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Coffee Mug",
    "description": "Ceramic mug",
    "category": "Kitchen",
    "price": 12.99,
    "stock": 100
  }'
```

### Get all products

`GET /api/products`

```bash
curl "http://localhost:8082/api/products"
```

### Get product by id

`GET /api/products/{id}`

```bash
curl "http://localhost:8082/api/products/<id>"
```

### Delete product

`DELETE /api/products/{id}`

```bash
curl -X DELETE "http://localhost:8082/api/products/<id>" -i
```

## Events

- Consumes: `user-created-events`
  - Listener: `product-service/src/main/java/com/ecommerce/product_service/service/UserEventListener.java`

## Swagger

- UI: `http://localhost:8082/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8082/v3/api-docs`
