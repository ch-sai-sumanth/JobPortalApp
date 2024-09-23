# Job Portal App

The **Job Portal App** is a secure, scalable web application built using **Spring Boot** that allows users to register, log in, and manage job posts. It offers full **CRUD operations** on job posts with secure password storage using **BCrypt** and **JWT-based authentication** for protected access across the application.

## Key Features

- **Secure User Registration & Login**: User passwords are hashed with BCrypt for security.
- **JWT Authentication**: Users receive a JWT token after login, required for accessing protected routes.
- **Full CRUD Operations**: Create, update, delete, and view job posts with ease.
- **Search Functionality**: Text-based search to find job posts quickly.
- **Protected Endpoints**: Only authenticated users can create, update, or delete job posts.

## Tech Stack

- **Java**
- **Spring Boot**
- **Spring Security**
- **JWT**
- **BCrypt**
- **Hibernate**
- **PostgreSQL**

## How to Run

1. Clone the repository:
    ```bash
    git clone [GitHub Link]
    ```
2. Navigate to the project directory:
    ```bash
    cd job-portal-app
    ```
3. Update the `application.properties` with your PostgreSQL credentials.
4. Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```
5. Access the application at `http://localhost:8080`.
6. Swagger url `http://localhost:8080/swagger-ui/index.html`.
