# Spring Boot API Starter Kit (Lite) 🚀

A lightweight starter kit for building **REST APIs with Spring Boot**.
This version is designed for simplicity and educational purposes, providing a minimal structure to demonstrate:

- ✅ Layered architecture (Controller, Service, Repository)
- 📑 Interactive API documentation with Swagger/OpenAPI
- 🗂️ Basic CRUD implementation with Product and Category entities
- ✅ Examples for different HTTP methods (GET, POST, PUT, DELETE)
- ✅ Various HTTP status codes (200, 201, 204, 404, 409)
- ⚡ In-memory H2 database for quick testing


## ⚠️ Important Note on Best Practices

This repository does not implement all industry best practices.
The goal of this Lite version is to provide simple examples of REST API endpoints with different HTTP methods and response codes.

For production-ready architectures and best practices (including DTO usage, mapping strategies, layered validations, error handling, and JWT security), check out:
- 🔗 My detailed articles on [Dev.to](https://dev.to/gianfcop)
- 💼 The Pro Starter Kit on [Gumroad](https://gianfcop.gumroad.com/) with:
   - ✅ DTOs and MapStruct mappers
   - ✅ JWT Authentication & Authorization
   - ✅ Advanced Error Handling & Response Wrappers
   - ✅ Logging, Profiles, and CI/CD ready structure

## ⚙️ Requirements
- Java 17+
- Maven 3.8+
- IDE of your choice (IntelliJ IDEA, VSCode)

## 🚀 Quick Start

1. Clone the repo:
   ```bash
   git clone https://github.com/gianfcop/springboot-rest-api-starter-lite.git
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Open Swagger UI:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## 🏗️ Project Structure
   ```
   src/main/java/com/starterkit/api
   ├── config/        → Configurations (Swagger)
   ├── controller/    → REST Controllers (ProductController, CategoryController)
   ├── entity/        → JPA Entities (Product, Category)
   ├── repository/    → Spring Data JPA repositories
   ├── service/       → Business logic
   └── SpringBootApiStarterKitLiteApplication.java
   ```

## 📑 API Documentation

Interactive Swagger UI available at:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

Endpoints included:
- POST /api/products → Create a product
- GET /api/products → Get all products
- PUT /api/products/{id} → Update product
- DELETE /api/products/{id} → Delete product
- POST /api/categories → Create category
- GET /api/categories → Get all categories

## 🧪 Testing

This version is minimal and does not include automated tests, but you can easily test the API using Swagger UI or tools like Postman.

## ✅ Want More Features?

Check out **Full Pro Starter Kit** (available on [Gumroad](https://gianfcop.gumroad.com/)) with:
- JWT Security
- DTOs and Mappers (MapStruct)
- Error Handling and Response Wrappers
- Logging, Profiles, and CI/CD ready structure
- Test Suite (MockMvc, Validation)
- Available on Gumroad

Also read the full tutorials on [Dev.to](https://dev.to/gianfcop).


## 📜 License

This project is licensed for educational and personal use only.
Do not redistribute or resell.