package com.mybook.goods.controller;

import com.mybook.goods.beans.MyBook;
import com.mybook.tools.myjdbc.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookController implements BookControllerInterface{

    @Override
    public MyBook findById(int id) {
        //连接数据库
        try{

            //写好的通用连接数据库的类
            Connection conn= DataBaseConnection.getConnection();
            //定义sql语句，sql语句根据Id找商品
            String sql="select * from mybook where id=?";
            //调用PreparedStament，除了占位，还有sql注入的问题
            PreparedStatement ps=conn.prepareStatement(sql);
            //然后再把占位语句中唯一的一个id值传入，这个id是一个整数
            ps.setInt(  1,id);

            //调用结果类ResultSet
            ResultSet rs=ps.executeQuery();
            //这里给定id值的商品只有一个，只要调一次游标
            rs.next();
            //调一次游标，商品就具备了，这里的java的对象需要new
            MyBook mybook=new MyBook();
            mybook.setTitle(rs.getString(  "title"));
            mybook.setAuthor(rs.getString(  "author"));
            //这里传入booklists中的字符串，里面就是一个列表
            mybook.setBooklists(rs.getString( "booklists"));
            mybook.setDescription(rs.getString(  "description"));
            mybook.setIsbn(rs.getString(  "isbn"));
            mybook.setPrice(rs.getDouble(  "price"));
            mybook.setPublisher(rs.getString("publisher"));
            mybook.setPublishtime(rs.getString(  "publishtime"));
            return mybook;
        }catch(Exception e){

        }
        return null;
    }

}