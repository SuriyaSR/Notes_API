# 📝 Notes API – Spring Boot + MongoDB + AWS Deployment

A full-stack ready **Notes Management REST API** built with Spring Boot and MongoDB, containerized using Docker, and deployed on AWS using CI/CD.

---

## 🚀 Live Demo

### Swagger UI
👉 http://13.60.190.29:8081/swagger-ui/index.html

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Data MongoDB
- MongoDB Atlas
- Docker
- GitHub Actions (CI/CD)
- AWS ECR (Container Registry)
- AWS EC2 (Deployment)
- Swagger / OpenAPI

---

## ✨ Features

- Create notes
- Update notes
- Delete notes
- Get all notes
- Last modified timestamp tracking
- RESTful API design
- Swagger API documentation
- Environment-based configuration
- Dockerized deployment
- CI/CD pipeline

---


---

## ⚙️ API Endpoints

| Method | Endpoint |
|--------|---------|
GET | /api/v1/notes |
GET | /api/v1/note/{id} |
POST | /api/v1/note |
PUT | /api/v1/note/{id} |
DELETE | /api/v1/note/{id} |

---

## 🐳 Docker

### Build Image
```bash
docker build -t notes-api .
```

### Run Container
```bash
docker run -p 8081:8080 --env-file .env notes-api
```

### 🔐 Environment Variables
```bash
NOTES_MONGO_URI=your_mongodb_connection_string
```
Secrets are NOT stored in code.

### CI/CD Pipeline
GitHub Actions pipeline:
```bash
Push to GitHub
   ↓
Build JAR
   ↓
Build Docker Image
   ↓
Push to AWS ECR
   ↓
EC2 pulls latest image
```

### ☁️ Deployment Architecture
```bash
GitHub → GitHub Actions → AWS ECR → EC2 → Docker Container
```

### 📌 Future Improvements

- Nginx reverse proxy
- HTTPS with SSL
- AWS Secrets Manager integration
- Role-based authentication
- Frontend integration

### 👤 Author
#### Suriya J

Full Stack Developer (Java + React)
