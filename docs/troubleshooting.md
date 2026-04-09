# Troubleshooting

## MongoDB Authentication Errors

If you see auth errors connecting to MongoDB:

- Ensure infra is up: `docker compose ps`
- Verify credentials in `docker-compose.yml` match your `application.yml` (`root` / `root`)
- Make sure your Mongo URI includes `?authSource=admin`

## Kafka Connection Issues

Services are configured to use `localhost:29092` (not 9092) for Kafka.

- Verify Kafka UI loads: `http://localhost:8080`
- Verify containers are healthy: `docker compose ps`

## Port Already In Use

If a service fails with a "port already in use" error:

- Stop the other process using the port, or
- Set a unique port in `*/src/main/resources/application.yml` or `application.properties`.

## Swagger UI Not Loading

- Ensure the service includes springdoc (not all services do).
- Use the service port, then visit `/swagger-ui/index.html`.
