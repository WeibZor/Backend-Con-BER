# CityScooterApp

A Spring Boot application for managing drivers in a scooter service.

## Features

- Create and retrieve drivers
- RESTful API endpoints
- In-memory H2 database
- Validation and error handling

## Technologies

- Spring Boot 3.5.13
- Java 21
- Spring Data JPA
- H2 Database
- Validation

## Running the Application

1. Ensure you have Java 21 installed.
2. Run `./mvnw spring-boot:run`
3. The application will start on port 8080.

## API Endpoints

- `POST /api/driver/create` - Create a new driver
- `GET /api/driver/{id}` - Get driver by ID
- `GET /api/helloworld` - Hello World endpoint

## Database

H2 console available at `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## Architecture

Follows Clean Architecture with:
- Controllers (Infrastructure In)
- Use Cases/Services (Application)
- Ports (Application)
- Adapters/Repositories (Infrastructure Out)
- Domain Entities