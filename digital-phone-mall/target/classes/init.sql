CREATE DATABASE IF NOT EXISTS digital_mall DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE digital_mall;

CREATE TABLE IF NOT EXISTS user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    role INT NOT NULL DEFAULT 0,
    status INT NOT NULL DEFAULT 1,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS phone (
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    description VARCHAR(500),
    status INT NOT NULL DEFAULT 1,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cart (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    phone_id INT NOT NULL,
    quantity INT NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (phone_id) REFERENCES phone(id),
    UNIQUE KEY (user_id, phone_id)
);

CREATE TABLE IF NOT EXISTS orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_no VARCHAR(50) NOT NULL UNIQUE,
    user_id INT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    status INT NOT NULL DEFAULT 0,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS order_item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    phone_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (phone_id) REFERENCES phone(id)
);

INSERT INTO user (username, password, name, phone, role, status) VALUES
('admin', 'admin123', 'Admin', '13800138000', 1, 1);

INSERT INTO user (username, password, name, phone, role, status) VALUES
('user1', 'user123', 'User1', '13900139001', 0, 1),
('user2', 'user123', 'User2', '13900139002', 0, 1);

INSERT INTO phone (brand, model, price, stock, description, status) VALUES
('Apple', 'iPhone 13', 5999.00, 50, 'Apple iPhone 13 128GB Black', 1),
('Apple', 'iPhone 13 Pro', 7999.00, 30, 'Apple iPhone 13 Pro 128GB Blue', 1),
('Samsung', 'Galaxy S21', 4999.00, 40, 'Samsung Galaxy S21 128GB Black', 1),
('Samsung', 'Galaxy S21 Ultra', 6999.00, 25, 'Samsung Galaxy S21 Ultra 256GB Black', 1),
('Huawei', 'Mate 40 Pro', 6499.00, 35, 'Huawei Mate 40 Pro 256GB Silver', 1),
('Huawei', 'P50 Pro', 5999.00, 20, 'Huawei P50 Pro 256GB White', 1),
('Xiaomi', 'Mi 11 Ultra', 5999.00, 45, 'Xiaomi Mi 11 Ultra 256GB Black', 1),
('Xiaomi', 'Redmi K40', 1999.00, 60, 'Redmi K40 128GB Black', 1),
('OPPO', 'Find X3 Pro', 4999.00, 30, 'OPPO Find X3 Pro 256GB Brown', 1),
('vivo', 'X60 Pro+', 4998.00, 35, 'vivo X60 Pro+ 256GB Blue', 1);