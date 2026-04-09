# Local Development

## Prerequisites

- Java 17
- Docker + Docker Compose

## Start Infrastructure

From repo root:

```bash
docker compose up -d
```

This starts:

- MongoDB on `localhost:27017` (auth enabled; username `root`, password `root`)
- Mongo Express UI on `http://localhost:8083`
- Kafka + Zookeeper
- Kafka UI on `http://localhost:8080`

## Run Services

Use Gradle wrapper from repo root.

```bash
./gradlew :user-service:bootRun
./gradlew :product-service:bootRun
./gradlew :order-service:bootRun
```

If you run multiple services at once, ensure each has a unique `server.port`.

## Useful URLs

- Mongo Express: `http://localhost:8083`
- Kafka UI: `http://localhost:8080`
- Swagger UI:
  - User Service: `http://localhost:8081/swagger-ui/index.html`
  - Product Service: `http://localhost:8082/swagger-ui/index.html`
  - Order Service: `http://localhost:8085/swagger-ui/index.html`

## Run Tests

```bash
./gradlew test
```
