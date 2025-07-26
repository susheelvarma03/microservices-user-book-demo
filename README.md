# 📚 Book-Service & 👤 User-Service Microservices

This project demonstrates a **Microservices Architecture** using **Spring Boot**, where two independent services communicate using **RestTemplate**.

---

## 🏗️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- H2 / MySQL  
- RestTemplate (for inter-service communication)  
- Lombok  

---

## 🧩 Services Overview

### 👤 User-Service

Handles user-related operations.

#### Endpoints:
- `GET /api/users` - Get all users  
- `GET /api/users/{id}` - Get user by ID  
- `POST /api/users` - Create a new user  
- `DELETE /api/users/{id}` - Delete a user  

---

### 📚 Book-Service

Handles book-related operations and fetches user details from User-Service using **RestTemplate**.

#### Endpoints:
- `GET /api/books` - Get all books  
- `GET /api/books/{id}` - Get book by ID  
- `POST /api/books` - Create a new book  
- `GET /api/books/with-user/{id}` - Get book with user info (via RestTemplate)  

---

## 🔗 Inter-Service Communication

Book-Service uses `RestTemplate` to fetch user details from User-Service.

```java
ResponseEntity<UserDTO> response = restTemplate.getForEntity("http://localhost:8081/api/users/" + userId, UserDTO.class);
```

Make sure **User-Service** is running on port `8081`.

---

## ▶️ How to Run

1. Clone both services:
```bash
git clone https://github.com/yourusername/user-service.git
git clone https://github.com/yourusername/book-service.git
```

2. Start **User-Service** first (port: `8081`)  
3. Start **Book-Service** (port: `8082`)  

Use Postman, Swagger, or curl to test APIs.

---

## 🧪 Example Use Case

1. Create a user in User-Service:
```http
POST /api/users
Content-Type: application/json

{
  "name": "Alice",
  "email": "alice@example.com"
}
```

2. Create a book in Book-Service:
```http
POST /api/books
Content-Type: application/json

{
  "title": "Spring Boot Microservices",
  "author": "John Doe",
  "userId": 1
}
```

3. Fetch book with associated user:
```http
GET /api/books/with-user/1
```

---

## 📁 Directory Structure

Each service contains:

```
src/
 └── main/
     ├── java/
     │   └── com.example.*
     └── resources/
         └── application.properties
```

---

## 🔄 Future Enhancements

- Replace `RestTemplate` with **WebClient**  
- Register services with **Eureka Discovery Server**  
- Add centralized **API Gateway**  
- Implement **Circuit Breaker** using Resilience4J  

---

## 👨‍💻 Author

**Susheel Varma**

---

