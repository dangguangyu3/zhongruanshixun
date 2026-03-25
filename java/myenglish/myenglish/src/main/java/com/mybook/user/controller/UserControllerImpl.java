package com.mybook.user.controller;

import com.mybook.user.bean.Myuser;


public class UserControllerImpl implements UserController{
    @Override
    public boolean login(String username, String password) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/myenglishbook?characterEncoding=utf-8"+"&useSSL=false&serverTimezone=UTC";
            String userdata="root";
            String passwd="admin";
            java.sql.Connection conn=java.sql.DriverManager.getConnection(url,userdata,passwd);
            String sql="select * from myuser where username=? and password=?";
            java.sql.PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            java.sql.ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    @Override
    public boolean register(Myuser user) {
        return false;
    }
}
