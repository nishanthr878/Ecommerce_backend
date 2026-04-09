# user-service

User registration service backed by MongoDB. On registration, it publishes a user-created event to Kafka.

## Run

1) Start infra:

```bash
docker compose up -d
```

2) Start the service:

```bash
./gradlew :user-service:bootRun
```

## Configuration

- Port: `8081` (see `user-service/src/main/resources/application.yml`)
- MongoDB: `ecommerce_users` (URI in `user-service/src/main/resources/application.yml`)
- Kafka bootstrap: `localhost:29092`

## API

Base path: `/api/users`

### Register user

`POST /api/users/register`

Example:

```bash
curl -X POST "http://localhost:8081/api/users/register" \
  -H "Content-Type: application/json" \
  -d '{
    "username": "alice",
    "email": "alice@example.com",
    "password": "password123",
    "role": "USER"
  }'
```

## Events

- Produces: `user-created-events`
  - Producer code: `user-service/src/main/java/com/ecommerce/user_service/service/UserService.java`
  - Topic definition: `user-service/src/main/java/com/ecommerce/user_service/config/KafkaTopicConfig.java`

## Swagger

- UI: `http://localhost:8081/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8081/v3/api-docs`

## Security

Security config permits unauthenticated access to:

- `POST /api/users/register`
- Swagger/OpenAPI endpoints (`/swagger-ui/**`, `/v3/api-docs/**`)

See `user-service/src/main/java/com/ecommerce/user_service/config/Securityconfig.java`.
