package com.mybook.user.controller;

import com.mybook.tools.myjdbc.DataBaseConnection;
import com.mybook.user.bean.Myuser;

import java.sql.SQLException;


public class UserControllerImpl implements UserController {
    @Override
    public boolean login(String username, String password) {
        try {
            java.sql.Connection conn = DataBaseConnection.getConnection();
            String sql = "select * from myuser where username=? and password=?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    @Override
    public boolean register(Myuser myuser) {
        try {
            java.sql.Connection conn = DataBaseConnection.getConnection();
            String sql = "insert into myuser(username,password,identify) values(?,?,?)";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, myuser.getUsername());
            ps.setString(2, myuser.getPassword());
            ps.setInt(3, myuser.getIdentity());
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
}
