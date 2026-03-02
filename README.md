
📖 Overview

Portfolio CMS is a full-stack web application built with Java Spring Boot that allows dynamic management of portfolio projects through a secure admin system.

Instead of a static portfolio website, this application works as a Content Management System (CMS) where projects are stored and managed through backend services connected to a database.

The project focuses on modern backend development, security implementation, and scalable architecture prepared for cloud deployment.

---

✨ Key Features

✅ Secure admin authentication

✅ CRUD management of portfolio projects

✅ RESTful API architecture

✅ Database persistence using JPA / Hibernate

✅ Layered backend structure

✅ Dockerized deployment

✅ Cloud-ready application design

---

## 🧱 Tech Stack

### 🚀 Backend
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Maven

### 🎨 Frontend
- HTML
- CSS
- JavaScript

### 🗄 Database
- H2 Database
- Hibernate ORM

### ⚙️ DevOps
- Docker
- Git
- GitHub

---

Client (Frontend)
        ↓
        
Spring Boot Controller
        ↓
        
Service Layer
        ↓
        
Repository Layer
       ↓
        
Database

The layered architecture improves maintainability, scalability and separation of concerns.

---

🔐 Security

Authentication and protected routes are implemented using Spring Security, ensuring only authorized users can manage portfolio content.

---

📡 Example API Endpoints

GET     /api/projects

POST    /api/projects

PUT     /api/projects/{id}

DELETE  /api/projects/{id}


---

🐳 Run with Docker

Build image:

docker build -t portfolio-cms .

Run container:

docker run -p 8080:8080 portfolio-cms

Application runs on:

http://localhost:8080

---

🚀 Run Locally

Clone repository:

git clone https://github.com/danielasilva92/portfolio-cms.git

Navigate to project:

cd portfolio-cms

Start application:

./mvnw spring-boot:run

Windows:

mvnw.cmd spring-boot:run

---

🎯 Learning Objectives

This project demonstrates:

Backend system design

REST API development

Authentication & authorization

Database integration

Clean code architecture

Deployment preparation

---

🔮 Future Improvements

JWT Authentication

Role-based permissions

React frontend

CI/CD pipeline

Cloud deployment (AWS / Azure)
