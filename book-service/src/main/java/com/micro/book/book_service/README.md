# Microservices: User & Book Service (Spring Boot Demo)

This project demonstrates a basic **microservices architecture** using Java Spring Boot. It includes two services:

- **User Service** (`user-service`): Manages user data
- **Book Service** (`book-service`): Stores books and fetches corresponding user details via REST communication

---

## 📦 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven
- IntelliJ
- RestTemplate

---

## 🧱 Microservices Architecture

✅ Independent Services  
✅ RESTful Communication between services  
✅ Separate databases/tables  
✅ DTOs, Services, Controllers  
✅ Hands-on microservices without Spring Cloud

---

## 🔁 Inter-Service Communication

The `book-service` fetches user details from `user-service` using `RestTemplate`:

```java
User user = restTemplate.getForObject("http://localhost:8082/users/" + book.getUserId(), User.class);
