# 🏢 EstateFlow - Real Estate CRM System
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.2-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.9-blue)
![Database](https://img.shields.io/badge/Database-H2%20%7C%20MySQL-blueviolet)
![License](https://img.shields.io/badge/License-MIT-green)
EstateFlow is a **full-featured Real Estate Customer Relationship Management (CRM) System** built using **Spring Boot 3**, **Spring Security**, **Spring Data JPA**, **Hibernate**, **Thymeleaf**, and **Bootstrap 5**.

The application is designed to streamline real estate business operations by providing a centralized platform to manage customers, properties, employees, sales, bookings, payments, finance, vendors, documents, and support tickets.

It includes role-based authentication, interactive dashboards, reporting modules, secure login, responsive UI, and enterprise-grade architecture.

---


# 📑 Table of Contents

- Features
- Technology Stack
- Project Architecture
- Modules
- Screenshots
- Folder Structure
- Database
- Installation
- Running the Application
- Demo Accounts
- Switching to MySQL
- Environment Variables
- Security
- Changelog


---

# ✨ Features

EstateFlow provides a complete CRM solution for real estate companies.

### Authentication & Security

- Secure Login
- Role Based Authentication
- Spring Security
- BCrypt Password Encryption
- Session Management
- Access Denied Handling
- Protected Routes

---

### Dashboard

Interactive dashboard with

- Total Properties
- Total Customers
- Active Leads
- Site Visits
- Bookings
- Revenue
- Pending Payments
- Employees
- Finance Summary
- Sales Analytics
- Charts

---

### Lead Management

- Add Lead
- Edit Lead
- Delete Lead
- Search Leads
- Track Lead Status
- Lead Follow-ups
- Customer Conversion

---

### Property Management

Manage

- Residential Properties
- Commercial Properties
- Available Properties
- Sold Properties
- Property Status

---

### Customer Management

- Customer Registration
- Customer History
- Search Customers
- Customer Bookings
- Customer Documents

---

### Booking Management

- Property Booking
- Booking Approval
- Booking Status
- Booking History

---

### Site Visit Management

- Schedule Visits
- Track Visits
- Customer Visit Records
- Visit Reports

---

### Finance Module

Manage

- Payments
- Loans
- Accounts
- Vendor Payments
- Petty Cash
- Revenue

---

### Employee Management

- Employee Records
- Departments
- HR Module
- Employee Information

---

### Vendor Management

- Vendor Details
- Vendor Payments
- Vendor Records

---

### Document Management

Upload and manage

- Customer Documents
- Property Documents
- Verification Status

---

### Support Module

- Support Tickets
- Ticket Status
- Issue Tracking

---

### Reports

- CSV Export
- Dashboard Reports
- Sales Reports
- Finance Reports

---

### User Experience

- Responsive UI
- Mobile Friendly
- Bootstrap 5
- Dark Mode
- Toast Notifications
- Validation
- Modal Forms

---

# 🛠 Technology Stack

## Backend

- Java 17
- Spring Boot 3.3.2
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

## Frontend

- Thymeleaf
- HTML5
- CSS3
- Bootstrap 5
- JavaScript
- Bootstrap Icons
- Chart.js

## Database

Development

- H2 Database

Production

- MySQL

## Build Tool

- Maven

---

# 🏗 Project Architecture

The project follows a layered architecture.

```
Controller
      │
      ▼
Service Layer
      │
      ▼
Repository Layer
      │
      ▼
Database
```

Each layer has a clear responsibility.

- Controller → Handles Requests
- Service → Business Logic
- Repository → Database Operations
- Entity → Database Tables
- Security → Authentication & Authorization
- Templates → UI Pages

---

# 📦 Modules

The application contains the following business modules.

### Sales

- Leads
- Follow Ups
- Customers
- Bookings
- Site Visits

### Property

- Properties
- Property Status

### Finance

- Accounts
- Loans
- Payments
- Petty Cash

### HR

- Employees

### Vendor

- Vendors

### Documents

- Upload
- Verification

### Support

- Tickets

### Administration

- User Management
- Dashboard
- Reports

---

# 📂 Project Structure

```
src
 ├── main
 │
 ├── java
 │    └── com.realestate.crm
 │
 │        ├── config
 │        ├── controller
 │        ├── entity
 │        ├── repository
 │        ├── security
 │        ├── service
 │        ├── serviceImpl
 │        └── RealEstateCrmApplication
 │
 ├── resources
 │
 │    ├── static
 │    │      ├── css
 │    │      └── js
 │    │
 │    ├── templates
 │    │      ├── dashboard
 │    │      ├── login
 │    │      ├── users
 │    │      └── fragments
 │    │
 │    ├── application.properties
 │    └── application-mysql.properties
 │
 └── pom.xml
```

---

# 💾 Database

The project supports two databases.

### H2 Database

Used by default.

Advantages

- No installation required
- Automatically created
- Perfect for development

---

### MySQL

Supported for production deployment.

Configuration is available inside

```
application-mysql.properties
```

---

# 🚀 Installation

Clone the repository

```bash
git clone https://github.com/yourusername/EstateFlow-Real-Estate-CRM.git
```

Move into the project

```bash
cd EstateFlow-Real-Estate-CRM
```

Build the project

```bash
mvn clean install
```

Run

```bash
mvn spring-boot:run
```

---

# ▶ Running the Application

The default configuration uses an H2 database.

```bash
mvn spring-boot:run
```

Application URL

```
http://localhost:8080/login
```

---

# 👤 Demo Accounts

| Username | Password | Role |
|-----------|----------|------|
| admin | admin123 | Administrator |
| sales1 | sales123 | Sales Executive |
| accounts1 | accounts123 | Accounts |
| hr1 | hr123 | HR |
| manager1 | manager123 | Manager |

---

# 🛢 Running with MySQL

Start using the MySQL profile.

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=mysql
```

Environment Variables

```
CRM_DB_USERNAME

CRM_DB_PASSWORD
```

---

# 🔐 Security

Implemented using Spring Security.

Features include

- Authentication
- Authorization
- BCrypt Password Encryption
- Role Based Access
- Secure Sessions
- Access Denied Pages

---

# 📊 Dashboard Analytics

Dashboard provides

- Revenue Statistics
- Property Statistics
- Customer Statistics
- Booking Analytics
- Sales Reports
- Finance Summary
- Charts using Chart.js

---

# 📱 Responsive Design

The application supports

- Desktop
- Laptop
- Tablet
- Mobile

---

# 🌍 Deployment

The application can be deployed on

- Render
- Docker
- Railway
- AWS EC2
- Azure
- DigitalOcean
- VPS Servers

---

# 🔮 Future Enhancements

- Email Notifications
- SMS Integration
- Google Maps Integration
- Online Payment Gateway
- Property Image Gallery
- AI Lead Prediction
- Customer Chat Support
- Mobile Application
- PDF Invoice Generation
- REST API Version

---

# 📋 Changelog

## [Latest] - 2026-08-12

### Added
- Enhanced documentation with comprehensive feature descriptions
- Daily update tracking system to the README

### Improved
- Updated project documentation for better clarity
- Added changelog section to track updates

### Documentation
- Updated Table of Contents with Changelog link
- Maintained all existing features and modules documentation

---

# 🤝 Contributing

Contributions are welcome.

Steps

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Push to GitHub
5. Create a Pull Request

---

# 📄 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

**Yashraj Agawane**

---

## ⭐ If you found this project helpful, don't forget to star the repository!

---

## 📅 Daily Update - 2026-08-13

**Last Updated:** 01:19:47 UTC

### Daily Maintenance
- ✅ Documentation verified
- ✅ Changelog updated
- ✅ Repository health check passed

---

## 📅 Daily Update - 2026-08-14

**Last Updated:** 01:18:46 UTC

### Daily Maintenance
- ✅ Documentation verified
- ✅ Changelog updated
- ✅ Repository health check passed

---

## 📅 Daily Update - 2026-08-15

**Last Updated:** 00:50:27 UTC

### Daily Maintenance
- ✅ Documentation verified
- ✅ Changelog updated
- ✅ Repository health check passed

---

## 📅 Daily Update - 2026-08-16

**Last Updated:** 00:53:37 UTC

### Daily Maintenance
- ✅ Documentation verified
- ✅ Changelog updated
- ✅ Repository health check passed
