package com.mybook.tools.myjdbc;

import java.sql.Connection;

public class DataBaseConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/myenglishbook?characterEncoding=utf-8" + "&useSSL=false&serverTimezone=UTC";
            String userdata = "root";
            String passwd = "123456";
            java.sql.Connection conn = java.sql.DriverManager.getConnection(url, userdata, passwd);
            return conn;
        } catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
}
