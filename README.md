# E-commerce Full Stack Application 🛒

A modern, full-stack e-commerce web application built with React frontend and Spring Boot backend, featuring comprehensive product management, image handling, and search functionality.
This e-commerce application provides a complete shopping platform with product catalog management, image storage, and search capabilities. The project demonstrates modern full-stack development practices with a RESTful API backend and responsive React frontend.

### Key Highlights
- **Full CRUD Operations** for product management
- **Image Upload & Storage** with PostgreSQL BLOB storage
- **Advanced Search** functionality across multiple product fields
- **Responsive Design** with modern UI/UX
- **RESTful API** with proper HTTP status codes
- **Error Handling** and validation on both frontend and backend

## ✨ Features

### 🛍️ Product Management
- ✅ Add new products with images
- ✅ View all products in a responsive grid layout
- ✅ Update existing product information
- ✅ Delete products from catalog
- ✅ Product availability toggle

### 🔍 Search & Filter
- ✅ Search across product name, description, brand, and category
- ✅ Real-time search results
- ✅ Case-insensitive search functionality

### 🖼️ Image Handling
- ✅ Upload product images during creation
- ✅ Store images as BLOB in PostgreSQL database
- ✅ Retrieve and display images with proper content types
- ✅ Support for multiple image formats (JPEG, PNG, WebP)

### 🎨 User Interface
- ✅ Modern, responsive design
- ✅ Interactive hover effects
- ✅ Loading states and error handling
- ✅ Form validation and user feedback
- ✅ Mobile-friendly layout

## 🛠️ Technology Stack

### Backend
- **Spring Boot 3.5.4** - Main framework
- **Spring Data JPA** - Data persistence layer
- **Spring Web** - RESTful web services
- **PostgreSQL** - Primary database
- **Hibernate** - ORM for database operations
- **Maven** - Dependency management
- **Lombok** - Reducing boilerplate code

### Frontend
- **React 18** - UI library
- **JavaScript ES6+** - Programming language
- **CSS3** - Styling and animations
- **Fetch API** - HTTP client for API calls
- **HTML5** - Markup structure

### Database
- **PostgreSQL 17** - Relational database
- **BLOB Storage** - For image data storage

### Development Tools
- **IntelliJ IDEA / VS Code** - IDEs
- **Postman** - API testing
- **Git** - Version control
- **GitHub** - Code repository

## 🏗️ Architecture

```
┌─────────────────┐    HTTP/REST     ┌─────────────────┐
│   React Frontend │ ◄──────────────► │ Spring Boot API │
│   (Port: 3000)   │                  │   (Port: 8080)  │
└─────────────────┘                  └─────────────────┘
                                               │
                                               │ JPA/Hibernate
                                               ▼
                                    ┌─────────────────┐
                                    │  PostgreSQL DB  │
                                    │   (Port: 5432)  │
                                    └─────────────────┘
```

### Project Architecture Pattern
- **MVC (Model-View-Controller)** pattern in Spring Boot
- **Component-based architecture** in React
- **Repository pattern** for data access
- **RESTful API design** for client-server communication

## 🚀 Installation & Setup

### Prerequisites
- **Java 17** or higher
- **Node.js 16** or higher
- **PostgreSQL 12** or higher
- **Maven 3.8** or higher
- **Git**

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/ecommerce.git
cd ecommerce
```

### 2. Database Setup
```sql
-- Create database
CREATE DATABASE ecommerce_db;

-- Create user (optional)
CREATE USER ecommerce_user WITH ENCRYPTED PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE ecommerce_db TO ecommerce_user;
```

### 3. Backend Setup
```bash
cd backend/ecommerce-backend

# Update application.properties
# src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password

# Run the application
./mvnw spring-boot:run
```

### 4. Frontend Setup
```bash
cd frontend/ecommerce-frontend

# Install dependencies
npm install

# Start development server
npm start
```

### 5. Access the Application
- **Frontend**: http://localhost:5173
- **Backend API**: http://localhost:8080
- **Database**: localhost:5432

## 📚 API Documentation

### Product Endpoints

#### Get All Products
```http
GET /api/products
Response: List<Product>
```

#### Get Product by ID
```http
GET /api/product/{id}
Response: Product object or 404
```

#### Add New Product
```http
POST /api/product
Content-Type: multipart/form-data
Body: 
  - product: JSON object
  - imageFile: File
Response: Created product or error
```

#### Update Product
```http
PUT /api/product/{id}
Content-Type: multipart/form-data
Body:
  - product: JSON object
  - imageFile: File
Response: Success message or error
```

#### Delete Product
```http
DELETE /api/product/{id}
Response: Success message or 404
```

#### Search Products
```http
GET /api/product/search?keyword={searchTerm}
Response: List<Product> matching search criteria
```

#### Get Product Image
```http
GET /api/product/{productId}/image
Response: Image binary data with proper content-type
```

### Product Model
```json
{
  "id": 1,
  "name": "iPhone 15",
  "description": "Latest Apple smartphone",
  "brand": "Apple",
  "price": 999.99,
  "category": "Mobile",
  "stockQuantity": 50,
  "productAvailable": true,
  "releaseDate": "2024-01-15",
  "imageName": "iphone15.jpg",
  "imageType": "image/jpeg"
}
```

## 📁 Project Structure

```
ecommerce-fullstack/
├── backend/
│   └── ecommerce-backend/
│       ├── src/main/java/com/harshal/ecommerce_backend/
│       │   ├── controller/
│       │   │   └── ProductController.java
│       │   ├── model/
│       │   │   └── Product.java
│       │   ├── repo/
│       │   │   └── ProductRepo.java
│       │   ├── service/
│       │   │   └── ProductService.java
│       │   └── EcommerceBackendApplication.java
│       ├── src/main/resources/
│       │   └── application.properties
│       └── pom.xml
├── frontend/
│   └── ecommerce-frontend/
│       ├── src/
│       │   ├── components/
│       │   │   ├── Home.js
│       │   │   └── AddProduct.js
│       │   ├── App.js
│       │   └── index.js
│       ├── public/
│       └── package.json
├── screenshots/
├── README.md
└── .gitignore
```


### 🎉 Quick Start Commands

```bash
# Clone and setup
git clone https://github.com/yourusername/ecommerce.git
cd ecommerce

# Backend setup
cd backend/ecommerce-backend
./mvnw spring-boot:run

# Frontend setup (new terminal)
cd frontend/ecommerce-frontend
npm install && npm start

# Access application
# Frontend: http://localhost:3000
# Backend: http://localhost:8080/api/products
```

