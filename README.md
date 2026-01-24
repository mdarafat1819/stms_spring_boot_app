# Simple Task Management System (Java Spring Boot App)

## 🎯 Project Objective
The **Simple Task Management System (STMS)** is a Spring Boot project designed to help you learn and implement **backend development best practices** using **Clean Architecture** principles.

This project helps you:

- Design and implement **RESTful APIs**
- Perform **CRUD operations** using Spring Data JPA
- Use **DTOs** to separate API contracts from database entities
- Enforce **input validation** with Jakarta Validation
- Handle **enum-based business rules** (Task Status)
- Implement **centralized exception handling** with structured error responses
- Improve **code maintainability, readability, and scalability**
- Gain **hands-on experience** with real-world backend architecture

The project is **beginner-friendly** while following **production-level design patterns**.

---

## 📋 Task Details
Each task in STMS contains the following fields:

| Field | Description | Validation / Notes |
|-------|------------|------------------|
| **ID** | Auto-generated unique identifier | Integer |
| **Title** | Short name of the task | Must not be empty (`@NotBlank`) |
| **Description** | Detailed explanation of the task | Must not be empty (`@NotBlank`) |
| **Status** | Current state of the task | Enum: `PENDING`, `IN_PROGRESS`, `DONE`; stored as STRING |
| **Status Description** | Human-readable explanation of the status | Derived from enum; returned in API responses only |

### 📤 API Behavior

- Task creation and update requests use **request DTOs** (`TaskRequest`)
- Task responses are returned using **response DTOs** (`TaskResponse`)
- Invalid input results in **400 Bad Request**
- Non-existing tasks result in **404 Not Found**
- Errors are returned in **structured JSON** format

This ensures clear separation between **database entities**, **request validation**, and **API responses**, following Clean Architecture principles.

---

## 🛠 Prerequisites

To run this project, you need:

- Java (JDK 17 or later)
- Maven
- PostgreSQL
- Any IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Basic Knowledge Required

- Java
- Spring Boot
- REST API
- JPA / Hibernate

Make sure PostgreSQL is running and database credentials are set correctly in `application.properties`.

---

## ▶ How to Run 
1. Clone the repository:
   ```bash
   git clone https://github.com/mdarafat1819/stms_spring_boot_app.git
   cd stms_spring_boot_app
   mvn spring-boot:run

### API Endpoints
Base URL: `http://localhost:8080/tasks`
| Method | Endpoint       | Description       |
|--------|----------------|-----------------|
| GET    | /tasks         | Get all tasks    |
| GET    | /tasks/{id}    | Get task by ID   |
| POST   | /tasks         | Create a new task|
| PUT    | /tasks/{id}    | Update a task    |
| DELETE | /tasks/{id}    | Delete a task    |

