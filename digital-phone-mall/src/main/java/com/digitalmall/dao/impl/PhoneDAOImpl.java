package com.digitalmall.dao.impl;

import com.digitalmall.dao.PhoneDAO;
import com.digitalmall.entity.Phone;
import com.digitalmall.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 手机商品DAO实现类
 */
public class PhoneDAOImpl implements PhoneDAO {

    @Override
    public List<Phone> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Phone> phoneList = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM phone";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Phone phone = new Phone();
                    phone.setId(rs.getInt("id"));
                    phone.setBrand(rs.getString("brand"));
                    phone.setModel(rs.getString("model"));
                    phone.setPrice(rs.getDouble("price"));
                    phone.setStock(rs.getInt("stock"));
                    phone.setDescription(rs.getString("description"));
                    phone.setStatus(rs.getInt("status"));
                    phone.setCreateTime(rs.getTimestamp("create_time"));
                    phoneList.add(phone);
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
        return phoneList;
    }

    @Override
    public Phone findById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Phone phone = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM phone WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    phone = new Phone();
                    phone.setId(rs.getInt("id"));
                    phone.setBrand(rs.getString("brand"));
                    phone.setModel(rs.getString("model"));
                    phone.setPrice(rs.getDouble("price"));
                    phone.setStock(rs.getInt("stock"));
                    phone.setDescription(rs.getString("description"));
                    phone.setStatus(rs.getInt("status"));
                    phone.setCreateTime(rs.getTimestamp("create_time"));
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
        return phone;
    }

    @Override
    public List<Phone> findByBrand(String brand) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Phone> phoneList = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM phone WHERE brand = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, brand);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Phone phone = new Phone();
                    phone.setId(rs.getInt("id"));
                    phone.setBrand(rs.getString("brand"));
                    phone.setModel(rs.getString("model"));
                    phone.setPrice(rs.getDouble("price"));
                    phone.setStock(rs.getInt("stock"));
                    phone.setDescription(rs.getString("description"));
                    phone.setStatus(rs.getInt("status"));
                    phone.setCreateTime(rs.getTimestamp("create_time"));
                    phoneList.add(phone);
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
        return phoneList;
    }

    @Override
    public List<Phone> findByPriceRange(double minPrice, double maxPrice) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Phone> phoneList = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM phone WHERE price BETWEEN ? AND ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, minPrice);
                pstmt.setDouble(2, maxPrice);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Phone phone = new Phone();
                    phone.setId(rs.getInt("id"));
                    phone.setBrand(rs.getString("brand"));
                    phone.setModel(rs.getString("model"));
                    phone.setPrice(rs.getDouble("price"));
                    phone.setStock(rs.getInt("stock"));
                    phone.setDescription(rs.getString("description"));
                    phone.setStatus(rs.getInt("status"));
                    phone.setCreateTime(rs.getTimestamp("create_time"));
                    phoneList.add(phone);
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
        return phoneList;
    }

    @Override
    public boolean addPhone(Phone phone) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO phone (brand, model, price, stock, description, status) VALUES (?, ?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, phone.getBrand());
                pstmt.setString(2, phone.getModel());
                pstmt.setDouble(3, phone.getPrice());
                pstmt.setInt(4, phone.getStock());
                pstmt.setString(5, phone.getDescription());
                pstmt.setInt(6, phone.getStatus());
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
    public boolean updatePhone(Phone phone) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "UPDATE phone SET brand = ?, model = ?, price = ?, stock = ?, description = ?, status = ? WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, phone.getBrand());
                pstmt.setString(2, phone.getModel());
                pstmt.setDouble(3, phone.getPrice());
                pstmt.setInt(4, phone.getStock());
                pstmt.setString(5, phone.getDescription());
                pstmt.setInt(6, phone.getStatus());
                pstmt.setInt(7, phone.getId());
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
                String sql = "UPDATE phone SET status = ? WHERE id = ?";
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
    public boolean deletePhone(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM phone WHERE id = ?";
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
    public boolean updateStock(int id, int quantity) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "UPDATE phone SET stock = stock - ? WHERE id = ?";
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
}