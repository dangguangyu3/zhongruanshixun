package com.mybook.carts.controller;

import com.mybook.carts.beans.MyCart;
import com.mybook.tools.myjdbc.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCartController implements MyCartControllerInterface {

    @Override
    public boolean addCart(MyCart mycart) {
        // 数据库操作 try--catch
        try {
            // 先获取连接
            Connection conn = DataBaseConnection.getConnection();
            // 取到连接后，写sql语句，插入所有的内容，不写id，这里id自增
            String sql = "insert into mycart(userid,goodid)" + " values(?,?)";
            // 这里直接定义 PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            // 传参，需要传入6个参数
            ps.setInt(1, mycart.getUserId());
            ps.setInt(2, mycart.getGoodid());
            // 直接执行插入
            int result = ps.executeUpdate();
            // 这里执行executeUpdate()应该是更新，执行语句一般可能在内存，不在表中
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delCart(int id) {
        // 退单也是数据库的操作
        try {
            Connection conn = DataBaseConnection.getConnection();
            // 获取连接，定义sql
            String sql = "delete from mycart where id=?";
            // 调用预编译语句
            PreparedStatement ps = conn.prepareStatement(sql);
            // 然后传入参数
            ps.setInt(1, id);
            // 执行删除
            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<MyCart> findallcarts(int userid) {
        // 查询方法传过来一个userid，按userid进行查询
        // 连接数据库
        try {
            // 取连接
            Connection conn = DataBaseConnection.getConnection();
            // 使用sql获取数据
            String sql = "select * from mycart,mybook where userid=?" + " and mycart.goodid=mybook.id";
            // 进行PreparedStatement的预编译
            PreparedStatement ps = conn.prepareStatement(sql);
            // 在预处理语句中传入一个参数
            ps.setInt(1, userid);
            // 执行预编译
            ResultSet rs = ps.executeQuery();
            // 这里查询出的订单就是一个列表
            // 列表先初始化
            List<MyCart> mycarts = new ArrayList<>();
            // 遍历，调整游标
            while (rs.next()) {
                // 这里取数据的一条数据，生成某用户的订单
                MyCart mycart = new MyCart();
                // 取id可能涉及到删除的操作
                mycart.setId(rs.getInt("id"));
                // 取商品名称
                mycart.setGoodname(rs.getString("title"));
                // 取价格
                mycart.setPrice(rs.getDouble("price"));
                // 取地址
                mycart.setPublishertime(rs.getString("publishtime"));
                // 取电话
                mycart.setAuthor(rs.getString("author"));
                // 加入到列表中
                mycarts.add(mycart);
            }
            // 在catch前面，循环外面查询结束返回即可
            return mycarts;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return Collections.emptyList();
    }
}
