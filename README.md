# 🔍 Springboot Custom Query (JDBC template)

A lightweight Spring Boot REST API demonstrating custom SQL queries using JDBC Template with row mappers for efficient database operations.

## 🚀 Features

- 📊 **Custom SQL Queries**: Direct SQL execution using Spring JDBC Template
- 🎯 **Custom Row Mappers**: Manual result set mapping for precise data handling
- 📈 **Product Analytics**: Get product count and detailed product listings
- 🏗️ **Clean Architecture**: Layered design with separation of concerns
- 🔄 **RESTful API**: Simple and efficient REST endpoints
- ⚡ **High Performance**: Direct SQL queries for optimal database performance

## 🛠️ Tech Stack

- **Java 21** ☕
- **Spring Boot 3.5.4** 🍃
- **Spring Web** 🌐
- **Spring Data JPA** 📊
- **JDBC Template** 🔗
- **MySQL** 🗄️
- **Lombok** 🎯
- **Maven** 📦

## 📋 Prerequisites

Before running this application, make sure you have:

- ☕ Java 21 or higher
- 🗄️ MySQL Server
- 📦 Maven 3.6+

## ⚙️ Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yasith-1/spring-custom-query.git
   cd spring-custom-query
   ```

2. **Configure Database**
   
   Create a MySQL database named `custom_product_test_icet` and update the connection details in `application.yml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/custom_product_test_icet
       username: your_username
       password: your_password
   ```

3. **Create Database Table**
   ```sql
   CREATE DATABASE custom_product_test_icet;
   USE custom_product_test_icet;
   
   CREATE TABLE product (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       price DECIMAL(10,2) NOT NULL
   );
   
   -- Sample data
   INSERT INTO product (name, price) VALUES 
   ('Laptop', 999.99),
   ('Mouse', 29.99),
   ('Keyboard', 79.99),
   ('Monitor', 299.99);
   ```

4. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## 🌐 API Endpoints

### 📊 Get Products with Count
```http
GET /products
```

**Response Format:**
```json
{
  "count": 4,
  "products": [
    {
      "id": 1,
      "name": "Laptop",
      "price": 999.99
    },
    {
      "id": 2,
      "name": "Mouse", 
      "price": 29.99
    }
  ]
}
```

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/edu/icet/customsql/
│   │   ├── Main.java                      # 🚀 Application entry point
│   │   ├── controller/
│   │   │   └── ProductController.java     # 🎮 REST controller
│   │   ├── mapper/
│   │   │   └── ProductRowMapper.java      # 🔄 Custom row mapper
│   │   ├── model/
│   │   │   └── Product.java               # 📝 Product model
│   │   ├── repository/
│   │   │   ├── ProductRepository.java     # 📊 Repository interface
│   │   │   └── impl/
│   │   │       └── ProductRepositoryImpl.java
│   │   └── service/
│   │       ├── ProductService.java        # 🎯 Service interface
│   │       └── impl/
│   │           └── ProductServiceImpl.java
│   └── resources/
│       └── application.yml                # ⚙️ Configuration
└── pom.xml                               # 📦 Maven dependencies
```

## 💡 Key Implementation Highlights

### 🔍 Custom Row Mapper
Demonstrates manual result set mapping for precise control:

```java
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}
```

### 📊 Custom SQL Queries
Direct SQL execution using JDBC Template:

```java
// Count query
jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `product`", Long.class);

// List query with custom mapper
jdbcTemplate.query("SELECT * FROM product", new ProductRowMapper());
```

### 📈 Aggregated Response
Service layer combines multiple data sources into a single response:

```java
HashMap<String, Object> productMap = new HashMap<>();
productMap.put("count", productRepository.getAllProductsCount());
productMap.put("products", productRepository.getAllProducts());
```

## 🧪 Testing

Test the API using:

### 📱 Using curl:
```bash
curl -X GET http://localhost:8080/products
```

### 🌐 Using Browser:
Navigate to: `http://localhost:8080/products`

### 🧪 Using Postman:
- Method: GET
- URL: `http://localhost:8080/products`

## 📊 Sample Response

```json
{
  "count": 4,
  "products": [
    {
      "id": 1,
      "name": "Laptop",
      "price": 999.99
    },
    {
      "id": 2,
      "name": "Mouse",
      "price": 29.99
    },
    {
      "id": 3,
      "name": "Keyboard", 
      "price": 79.99
    },
    {
      "id": 4,
      "name": "Monitor",
      "price": 299.99
    }
  ]
}
```

## 🎯 Use Cases

This project is perfect for:
- 📚 **Learning JDBC Template**: Understanding Spring's JDBC abstraction
- 🔍 **Custom SQL Queries**: When you need specific SQL optimizations
- 🎯 **Row Mapping**: Manual control over result set processing
- 🏗️ **Architecture Patterns**: Clean separation of concerns
- ⚡ **Performance**: Direct SQL for high-performance scenarios

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 🔧 Extending the Application

You can easily extend this application by:
- Adding more custom queries in the repository
- Implementing CRUD operations
- Adding pagination and sorting
- Creating more complex row mappers
- Adding validation and error handling

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Yasith** - [GitHub Profile](https://github.com/yasith-1)

## 🙏 Acknowledgments

- Spring Framework team for JDBC Template
- MySQL for reliable database solutions
- Lombok for reducing boilerplate code

---

⭐ **Star this repository if you found it helpful!** ⭐

💡 **Perfect for learning Spring JDBC Template and custom SQL queries!**
