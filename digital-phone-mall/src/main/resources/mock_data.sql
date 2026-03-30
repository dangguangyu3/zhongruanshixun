-- 模拟数据SQL脚本
-- 使用数据库
USE digital_mall;

-- 插入更多手机商品数据
INSERT INTO phone (brand, model, price, stock, description, status) VALUES
('Apple', 'iPhone 14', 6999.00, 40, 'Apple iPhone 14 128GB Blue', 1),
('Apple', 'iPhone 14 Pro', 8999.00, 25, 'Apple iPhone 14 Pro 128GB Space Black', 1),
('Samsung', 'Galaxy S22', 5999.00, 35, 'Samsung Galaxy S22 128GB Phantom Black', 1),
('Samsung', 'Galaxy S22 Ultra', 7999.00, 20, 'Samsung Galaxy S22 Ultra 256GB Phantom Black', 1),
('Huawei', 'Mate 50 Pro', 6999.00, 30, 'Huawei Mate 50 Pro 256GB Silver', 1),
('Xiaomi', 'Mi 12 Ultra', 6999.00, 35, 'Xiaomi Mi 12 Ultra 256GB Black', 1),
('OPPO', 'Find X5 Pro', 5999.00, 25, 'OPPO Find X5 Pro 256GB Black', 1),
('vivo', 'X80 Pro', 5998.00, 30, 'vivo X80 Pro 256GB Blue', 1);

-- 插入购物车数据
INSERT INTO cart (user_id, phone_id, quantity) VALUES
(2, 1, 1),  -- user1 购买 iPhone 13
(2, 3, 2),  -- user1 购买 Galaxy S21
(3, 2, 1),  -- user2 购买 iPhone 13 Pro
(5, 5, 1),  -- user3 购买 Mate 40 Pro
(6, 7, 1);  -- user4 购买 Mi 11 Ultra

-- 插入订单数据
INSERT INTO orders (order_no, user_id, total_amount, status) VALUES
('202603280001', 2, 5999.00, 3),  -- user1 已完成订单
('202603280002', 3, 7999.00, 2),  -- user2 已发货订单
('202603280003', 5, 6499.00, 1),  -- user3 已支付订单
('202603280004', 6, 5999.00, 0);  -- user4 待支付订单

-- 插入订单详情数据
INSERT INTO order_item (order_id, phone_id, quantity, price) VALUES
(1, 1, 1, 5999.00),  -- 订单1: iPhone 13
(2, 2, 1, 7999.00),  -- 订单2: iPhone 13 Pro
(3, 5, 1, 6499.00),  -- 订单3: Mate 40 Pro
(4, 7, 1, 5999.00);  -- 订单4: Mi 11 Ultra
