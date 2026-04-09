# ecommerce-platform

Spring Boot microservices demo for a simple e-commerce platform. The repo is a Gradle multi-module build with independent services, MongoDB per service, and Kafka for event-driven integration.

## Services

| Service | Module | Default port | Notes |
|---|---|---:|---|
| API Gateway | `api-gateway/` | (not set) | Spring Cloud Gateway (WebMVC). Routes not configured yet. |
| User Service | `user-service/` | 8081 | User registration + publishes `user-created-events`. Swagger enabled. |
| Product Service | `product-service/` | 8082 | Product CRUD + consumes user-created events. Swagger enabled. |
| Order Service | `order-service/` | 8085 | Order creation + publishes an order-created event. Swagger enabled. |
| Cart Service | `cart-service/` | (not set) | Scaffold only (app name configured). |
| Payment Service | `payment-service/` | (not set) | Scaffold only (app name configured). |
| Notification Service | `notification-service/` | (not set) | Scaffold only (app name configured). |

If a service doesn't set `server.port`, Spring Boot defaults to 8080. Set unique ports before running multiple services concurrently.

## Prerequisites

- Java 17
- Docker + Docker Compose

## Quick Start (Local)

1) Start infrastructure (MongoDB + Kafka + UIs)

```bash
docker compose up -d
```

2) Run services (one terminal per service)

```bash
./gradlew :user-service:bootRun
./gradlew :product-service:bootRun
./gradlew :order-service:bootRun
```

Windows:

```bat
gradlew.bat :user-service:bootRun
```

## API Docs (Swagger)

- User Service: `http://localhost:8081/swagger-ui/index.html`
- Product Service: `http://localhost:8082/swagger-ui/index.html`
- Order Service: `http://localhost:8085/swagger-ui/index.html`

OpenAPI JSON is available at `http://localhost:<port>/v3/api-docs`.

## Docs

- `docs/README.md`
- `docs/local-development.md`
- `docs/architecture.md`
- `docs/kafka-topics.md`
- `docs/troubleshooting.md`

## Per-service READMEs

- `api-gateway/README.md`
- `user-service/README.md`
- `product-service/README.md`
- `order-service/README.md`
- `cart-service/README.md`
- `payment-service/README.md`
- `notification-service/README.md`

## Notes

- Local MongoDB credentials in `docker-compose.yml` are `root` / `root` (development only).
- Kafka is exposed as `localhost:29092` for local apps.
