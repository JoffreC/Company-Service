# 🏢 Company Service API

**Company Service** is a backend microservice built with **Spring Boot** that manages company information and communicates reactively with another microservice called **Contact Service**.  
It follows a **Hexagonal Architecture (Ports and Adapters)** to keep the domain logic independent from frameworks and external systems.

---

## 🧰 Technologies Used

- **Java 21**
- **Spring Boot 3.5.x**
- **Spring WebFlux** → Reactive inter-service communication
- **Spring Data JPA / PostgreSQL**
- **Flyway** → Database versioning and migrations
- **Swagger / Springdoc OpenAPI 3**
- **Maven**
- **.env file** → Environment-based configuration

---

## 🧱 Project Structure (Hexagonal Architecture)
/src
├── main
│ ├── java/com/test/company_service
│ │ ├── application # Use cases and input ports
│ │ ├── domain # Core business logic and entities
│ │ ├── infrastructure # Adapters (configuration, dtos, exceptions, controllers, repositories, WebFlux client)
│ └── resources
│ ├── db/migration # Flyway migration scripts
│ └── application.properties
└── test
└── java/com/test/company_service

---

## ⚙️ Configuration

### 🔧 `application.properties`

```properties
spring.application.name=company-service
spring.config.import=optional:file:.env[.properties]

spring.datasource.url=${DB_CONNECTION}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

api.prefix=api/v1
contact.service.url=${CONTACT_URL}
```

## 🌍 .env File Example
### Database
DB_CONNECTION=jdbc:postgresql://localhost:5432/company_db
DB_USERNAME=postgres
DB_PASSWORD=admin

### External Services
CONTACT_URL=http://localhost:8085/api/v1/contact

## 🗃️ Database Migrations (Flyway)

Flyway is used to version and manage the database schema.

Migration scripts are located in:

src/main/resources/db/migration

Naming convention:

V1__create_company_table.sql
V2__create_company_locations_table.sql


Run migrations manually with:

```bash
mvn flyway:migrate
```

Migrations are executed automatically on application startup.

## ▶️ Running the Project
### 1️⃣ Clone the Repository

```bash
git clone https://github.com/JoffreC/Company-Service.git
cd company-service
```

### 2️⃣ Configure Environment

Create a .env file with your database and external service variables (see example above). Don't forget to create your database in PostgreSQL.

### 3️⃣ Build and Run

```bash
mvn clean package
mvn spring-boot:run
```

The API will be available at:
👉 http://localhost:8080/api/v1/company

## 📘 API Documentation (Swagger / OpenAPI)
Swagger UI

👉 http://localhost:8080/swagger-ui.html
