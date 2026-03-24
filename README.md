# Secure Student Project Management System

A Spring Boot REST API where students can register, login, and manage their academic projects using JWT authentication.

## Tech Stack

- Java, Spring Boot, Spring Security
- JWT (JJWT), BCrypt
- Spring Data JPA, MySQL / H2

## How It Works

Students register and login to get a JWT token. That token is used to create, view, update, and delete their own projects. Each student can only access their own data.

## API Endpoints

| Method | Endpoint | Auth Required | Description |
|---|---|---|---|
| POST | `/auth/register` | No | Register a student |
| POST | `/auth/login` | No | Login and get JWT token |
| POST | `/projects` | Yes | Create a project |
| GET | `/projects` | Yes | Get all your projects |
| PUT | `/projects/{id}` | Yes | Update a project |
| DELETE | `/projects/{id}` | Yes | Delete a project |

## Setup

```bash
git clone https://github.com/cser-naivedya-raj/Spring-Security-Assessment-Task.git
cd Spring-Security-Assessment-Task/secure-student-project-management-system
mvn spring-boot:run
```

Update `application.properties` with your database credentials before running.

## Example

**Login**
```json
POST /auth/login
{ "email": "shiv@gmail.com", "password": "1234" }
```

**Create Project**
```http
POST /projects
Authorization: Bearer <token>

{ "title": "AI Chatbot", "description": "NLP based chatbot" }
```
