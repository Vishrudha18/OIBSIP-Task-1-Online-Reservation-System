# 🛤️ Online Reservation System (Java + JDBC)

## 📌 Project Overview
The **Online Reservation System** is a console-based Java application developed using **Core Java and JDBC** with **MySQL** as the backend database.  
It allows authorized users to **log in**, **reserve train tickets**, and **cancel reservations** using a unique **PNR number**.

The main goal of this project is to store reservation data in a **centralized database**, reduce manual effort, and provide a simple and efficient reservation workflow.

---

## 🎯 Features
- 🔐 **User Authentication (Login Module)**
- 📝 **Ticket Reservation**
  - Passenger details entry
  - Auto-generated train name
  - PNR generation
- ❌ **Ticket Cancellation**
  - Fetch ticket using PNR
  - Display reservation details
  - Confirm and cancel ticket
- 🗄️ **MySQL Database Integration**
- 🧾 **Menu-driven Console Interface**

---

## 🧑‍💻 Technologies Used
- **Java (Core Java)**
- **JDBC (MySQL Connector/J)**
- **MySQL**
- **VS Code**
- **Git & GitHub**

---

## 📁 Project Structure
TASK 1/
│
├── src/
│ ├── DBConnection.java
│ ├── Login.java
│ ├── Reservation.java
│ ├── Cancellation.java
│ ├── Main.java
│ └── db.properties
│
├── lib/
│ └── mysql-connector-j.jar
│
├── db/
│ └── database.sql
│
├── .vscode/
│ └── settings.json
│
├── .gitignore
└── README.md

---

## ⚙️ Environment Setup

### 1️⃣ Install Required Software
- JDK 8 or above
- MySQL Server & MySQL Workbench
- VS Code with **Java Extension Pack**

### 2️⃣ Configure Database
CREATE DATABASE online_reservation;
USE online_reservation;

**Create tables:**

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE reservations (
    pnr INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    train_number VARCHAR(10),
    train_name VARCHAR(50),
    class_type VARCHAR(20),
    journey_date DATE,
    source VARCHAR(50),
    destination VARCHAR(50)
);


**Insert sample login:**

INSERT INTO users (username, password)
VALUES ('admin', 'admin123');

---

## 🔗 Database Configuration
Create a db.properties file inside src/:

db.url=jdbc:mysql://localhost:3306/online_reservation?useSSL=false&allowPublicKeyRetrieval=true
db.user=root
db.password=your_mysql_password

---

## ▶️ How to Run the Project

***Clone the repository***
git clone https://github.com/Vishrudha18/OIBSIP-Task-1-Online-Reservation-System.git

***Open the project in VS Code***

***Add MySQL Connector JAR to classpath***
(lib/mysql-connector-j.jar)

***Run:***
Main.java

---

## 🧪 Sample Login Credentials
Username: admin
Password: admin123

---

## Output

<img width="1918" height="950" alt="Image" src="https://github.com/user-attachments/assets/3e8a44b0-97a2-4030-a99f-2164a27b55ae" />

<img width="1860" height="856" alt="Image" src="https://github.com/user-attachments/assets/20b1f89b-f222-4f55-9e21-bf111a04fdfe" />

<img width="1854" height="845" alt="Image" src="https://github.com/user-attachments/assets/2a04e932-1ee8-47e0-baf5-2fc03709e5f8" />

---

## 🧠 Learning Outcomes
- JDBC database connectivity
- PreparedStatement usage
- Modular Java programming
- Menu-driven console applications
- Secure database configuration handling

---

## 📌 Future Enhancements
- Seat availability management
- Separate train table
- Password encryption
- Admin dashboard
- GUI using JavaFX or Swing

---

## 📜 License
This project is developed for learning and internship purposes.
