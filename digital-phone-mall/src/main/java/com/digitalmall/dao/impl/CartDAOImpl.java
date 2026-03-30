package com.digitalmall.dao.impl;

import com.digitalmall.dao.CartDAO;
import com.digitalmall.entity.Cart;
import com.digitalmall.entity.Phone;
import com.digitalmall.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车DAO实现类
 */
public class CartDAOImpl implements CartDAO {

    @Override
    public List<Cart> findByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Cart> cartList = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT c.*, p.* FROM cart c JOIN phone p ON c.phone_id = p.id WHERE c.user_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userId);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Cart cart = new Cart();
                    cart.setId(rs.getInt("c.id"));
                    cart.setUserId(rs.getInt("c.user_id"));
                    cart.setPhoneId(rs.getInt("c.phone_id"));
                    cart.setQuantity(rs.getInt("c.quantity"));
                    cart.setCreateTime(rs.getTimestamp("c.create_time"));
                    
                    Phone phone = new Phone();
                    phone.setId(rs.getInt("p.id"));
                    phone.setBrand(rs.getString("p.brand"));
                    phone.setModel(rs.getString("p.model"));
                    phone.setPrice(rs.getDouble("p.price"));
                    phone.setStock(rs.getInt("p.stock"));
                    phone.setDescription(rs.getString("p.description"));
                    phone.setStatus(rs.getInt("p.status"));
                    phone.setCreateTime(rs.getTimestamp("p.create_time"));
                    
                    cart.setPhone(phone);
                    cartList.add(cart);
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
        return cartList;
    }

    @Override
    public Cart findByUserIdAndPhoneId(int userId, int phoneId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cart cart = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM cart WHERE user_id = ? AND phone_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userId);
                pstmt.setInt(2, phoneId);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    cart = new Cart();
                    cart.setId(rs.getInt("id"));
                    cart.setUserId(rs.getInt("user_id"));
                    cart.setPhoneId(rs.getInt("phone_id"));
                    cart.setQuantity(rs.getInt("quantity"));
                    cart.setCreateTime(rs.getTimestamp("create_time"));
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
        return cart;
    }

    @Override
    public boolean addCart(Cart cart) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO cart (user_id, phone_id, quantity) VALUES (?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, cart.getUserId());
                pstmt.setInt(2, cart.getPhoneId());
                pstmt.setInt(3, cart.getQuantity());
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
    public boolean updateQuantity(int id, int quantity) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "UPDATE cart SET quantity = ? WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, quantity);
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
    public boolean deleteCart(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM cart WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
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
    public boolean clearCart(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM cart WHERE user_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userId);
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
}