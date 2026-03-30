package com.digitalmall.dao.impl;

import com.digitalmall.dao.OrderDAO;
import com.digitalmall.entity.Order;
import com.digitalmall.entity.OrderItem;
import com.digitalmall.entity.Phone;
import com.digitalmall.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单DAO实现类
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public List<Order> findByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Order> orderList = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY create_time DESC";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userId);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setOrderNo(rs.getString("order_no"));
                    order.setUserId(rs.getInt("user_id"));
                    order.setTotalAmount(rs.getDouble("total_amount"));
                    order.setStatus(rs.getInt("status"));
                    order.setCreateTime(rs.getTimestamp("create_time"));
                    order.setOrderItems(findOrderItemsByOrderId(order.getId()));
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                DBUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderList;
    }

    @Override
    public List<Order> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Order> orderList = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM orders ORDER BY create_time DESC";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setOrderNo(rs.getString("order_no"));
                    order.setUserId(rs.getInt("user_id"));
                    order.setTotalAmount(rs.getDouble("total_amount"));
                    order.setStatus(rs.getInt("status"));
                    order.setCreateTime(rs.getTimestamp("create_time"));
                    order.setOrderItems(findOrderItemsByOrderId(order.getId()));
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                DBUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderList;
    }

    @Override
    public Order findById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Order order = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM orders WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setOrderNo(rs.getString("order_no"));
                    order.setUserId(rs.getInt("user_id"));
                    order.setTotalAmount(rs.getDouble("total_amount"));
                    order.setStatus(rs.getInt("status"));
                    order.setCreateTime(rs.getTimestamp("create_time"));
                    order.setOrderItems(findOrderItemsByOrderId(order.getId()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                DBUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    @Override
    public int createOrder(Order order) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int orderId = 0;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO orders (order_no, user_id, total_amount, status) VALUES (?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, order.getOrderNo());
                pstmt.setInt(2, order.getUserId());
                pstmt.setDouble(3, order.getTotalAmount());
                pstmt.setInt(4, order.getStatus());
                pstmt.executeUpdate();
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    orderId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                DBUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderId;
    }

    @Override
    public boolean addOrderItem(OrderItem orderItem) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO order_item (order_id, phone_id, quantity, price) VALUES (?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, orderItem.getOrderId());
                pstmt.setInt(2, orderItem.getPhoneId());
                pstmt.setInt(3, orderItem.getQuantity());
                pstmt.setDouble(4, orderItem.getPrice());
                int result = pstmt.executeUpdate();
                return result > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                DBUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateStatus(int id, int status) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "UPDATE orders SET status = ? WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, status);
                pstmt.setInt(2, id);
                int result = pstmt.executeUpdate();
                return result > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                DBUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Order> findByStatus(int status) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Order> orderList = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM orders WHERE status = ? ORDER BY create_time DESC";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, status);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setOrderNo(rs.getString("order_no"));
                    order.setUserId(rs.getInt("user_id"));
                    order.setTotalAmount(rs.getDouble("total_amount"));
                    order.setStatus(rs.getInt("status"));
                    order.setCreateTime(rs.getTimestamp("create_time"));
                    order.setOrderItems(findOrderItemsByOrderId(order.getId()));
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                DBUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderList;
    }

    /**
     * 根据订单ID查询订单详情
     * @param orderId 订单ID
     * @return 订单详情列表
     */
    private List<OrderItem> findOrderItemsByOrderId(int orderId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<OrderItem> orderItemList = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT oi.*, p.* FROM order_item oi JOIN phone p ON oi.phone_id = p.id WHERE oi.order_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, orderId);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setId(rs.getInt("oi.id"));
                    orderItem.setOrderId(rs.getInt("oi.order_id"));
                    orderItem.setPhoneId(rs.getInt("oi.phone_id"));
                    orderItem.setQuantity(rs.getInt("oi.quantity"));
                    orderItem.setPrice(rs.getDouble("oi.price"));
                    
                    Phone phone = new Phone();
                    phone.setId(rs.getInt("p.id"));
                    phone.setBrand(rs.getString("p.brand"));
                    phone.setModel(rs.getString("p.model"));
                    phone.setPrice(rs.getDouble("p.price"));
                    phone.setStock(rs.getInt("p.stock"));
                    phone.setDescription(rs.getString("p.description"));
                    phone.setStatus(rs.getInt("p.status"));
                    phone.setCreateTime(rs.getTimestamp("p.create_time"));
                    
                    orderItem.setPhone(phone);
                    orderItemList.add(orderItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                DBUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderItemList;
    }
}