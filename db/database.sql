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

INSERT INTO users (username, password)
VALUES ('admin', 'admin123');
