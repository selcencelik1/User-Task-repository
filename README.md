# 📋 Task Management API

A simple and extensible RESTful API built with **Spring Boot** for managing users and their tasks.  
Each user can have multiple tasks, and each task has a status defined by an `enum`. Tasks can also be filtered by their status.

---

## 🚀 Features

- ✅ Create users
- ✅ Assign multiple tasks to each user
- ✅ Task status management using `enum` (TODO, IN_PROGRESS, TEST, DONE)
- ✅ Filter tasks by status (e.g., `/tasks?status=TODO`)
- ✅ One-to-Many relationship between User and Task
- ✅ JSON-based RESTful API
- ✅ PostgreSQL database integration

---

## 🧱 Tech Stack

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Maven**

---

## 🧩 Project Structure

```text
src/
├── controller/        # REST controllers
├── service/           # Business logic
├── dto/               # Data Transfer Objects
├── entity/            # JPA entities: User, Task
├── repository/        # JPA repositories
└── enumer/            # TaskStatus enum (TODO, IN_PROGRESS, TEST, DONE)
├── exception/         # GlobalExceptionHandler for incorrect entry 
