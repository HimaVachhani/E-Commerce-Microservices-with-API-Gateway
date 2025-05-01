# E-Commerce-Microservices-with-API-Gateway
Project Overview
This project is a microservices-based e-commerce application consisting of several services:

Product Service: Handles product catalog management.

User Service: Manages user profiles.

Order Service: Handles order placements.

API Gateway: Acts as a reverse proxy for routing requests to the appropriate microservices.

The services communicate with each other using Spring Cloud Eureka for service discovery and Spring Cloud Feign for inter-service communication. The API Gateway is implemented using Spring Cloud Gateway, routing requests based on path predicates.

Technologies Used
Spring Boot: Framework for building microservices.

Spring Cloud Netflix Eureka: Service discovery.

Spring Cloud Gateway: API Gateway for routing requests.

Spring Cloud Feign: Declarative REST Client for inter-service communication.
Prerequisites
JDK 11 or higher.

Maven for building the project.

Docker (optional, for containerization).

Postman or any HTTP client to test the APIs.

Project Structure
api-gateway: Manages routing for all services and serves as the entry point for the application.

eureka-server: Acts as the service registry for all microservices.

product-service: Manages product catalog operations.

user-service: Manages user profiles.

order-service: Handles order management.

Accessing the Application
Eureka Dashboard:
After running all services, you can access the Eureka dashboard at:
http://localhost:8084

API Gateway:
All requests should be routed through the API Gateway:

GET http://localhost:8080/products

GET http://localhost:8080/users

POST http://localhost:8080/orders
