# Project: Transaction Risk API

### Overview
A Spring Boot REST API that assesses transaction risk based on configurable business rules. 
Built to demonstrate clean backend design, validation, and error handling.

### Key Features
* RESTful APIs to create and query transactions.
* Rule-based risk assessment (HIGH/LOW)
* Bean Validation for request input.
* Global exception handling with proper HTTP status codes
* JPA persistence with H2 database
* Unit tested business logic

### Risk Logic
* Transactions above 10,000 from non-Australian countries are classified HIGH risk.
*  All others are LOW risk

### Design Decisions
* Used enums for risk levels to ensure type safety
* Centralized validation and error handling
* Isolated business logic for testability

### Challenges Solved
* Fixed a subtle ORM issue caused by a reserved SQL keyword by explicitly naming database tables

