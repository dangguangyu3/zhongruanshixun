package com.mybook.orders.controller;

import com.mybook.orders.beans.MyOrder;
import com.mybook.tools.myjdbc.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyOrderController
        implements MyOrderControllerInterface{

    @Override
    public List<MyOrder> findallorders(int userid) {
        //查询方法传过来一个userid，按userid进行查询
        //连接数据库
        try{

            //取连接
            Connection conn= DataBaseConnection.getConnection();
            //使用sql获取数据
            String sql="select a.*,b.title from myorder " +
                    "a,mybook b where a.userid=? and a.goodid=b.id";
            //进行PreparedStatement的预编译
            PreparedStatement ps=conn.prepareStatement(sql);
            //在预处理语句中传入一个参数
            ps.setInt(  1,userid);
            //执行预编译
            ResultSet rs=ps.executeQuery();
            //这里查询出的订单就是一个列表
            //列表先初始化
            List<MyOrder> myorders=new ArrayList<>();
            //遍历，调整游标
            while(rs.next()){
                //这里取数据的一条数据，生成某用户的订单
                MyOrder myorder=new MyOrder();
                //取id可能涉及到删除的操作
                myorder.setId(rs.getInt( "id"));
                //取商品名称
                myorder.setGoodname(rs.getString( "title"));
                //取数量
                myorder.setMycount(rs.getInt( "mycount"));
                //取价格
                myorder.setMyprice(rs.getDouble( "myprice"));
                //取地址
                myorder.setAddress(rs.getString( "address"));
                //取电话
                myorder.setTel(rs.getString(  "tel"));
                //加入到列表中
                myorders.add(myorder);

            }
            //在catch前面，循环外面查询结果返回即可
            return myorders;
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean insertorder(MyOrder myorder,int goodid) {
        //数据库操作是try---catch
        try{

            //先获取连接
            Connection conn=DataBaseConnection.getConnection();
            //取到连接后，写sql语句，插入写所有的内容，不写id，这里id自增
            String sql="insert into myorder(userid,goodid,mycount,myprice,address,tel) " +
                    " values(?,?,?,?,?,?)";
            //这里直接定义 PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            //传参，需要传入6个参数
            ps.setInt( 1,myorder.getUserid());
            ps.setInt( 2,goodid);
            ps.setInt( 3,myorder.getMycount());
            ps.setDouble(  4,myorder.getMyprice());
            ps.setString( 5,myorder.getAddress());
            ps.setString( 6,myorder.getTel());
            //直接执行插入
            int result=ps.executeUpdate();
            if(result>0) {
                return true;
            }

        }catch(Exception e){

        }
        return false;
    }

    @Override
    public boolean deleteOrder(int id) {
        //退单也是数据库的操作
        try{

            Connection conn=DataBaseConnection.getConnection();
            //获取连接，定义sql
            String sql="delete from myorder where id=?";
            //调用预编译语句
            PreparedStatement ps=conn.prepareStatement(sql);
            //然后传入参数
            ps.setInt( 1,id);
            //执行删除
            int result=ps.executeUpdate();
            if(result>0){
                return true;
            }

        }catch(Exception e){

        }
        return false;
    }

    @Override
    public boolean modifyOrder(MyOrder myorder) {
        //数据库操作，先try
        try{

            Connection conn=DataBaseConnection.getConnection();
            //定义修改地址，电话，然后就是数量，修改数量通过数量算总价
            String sql="update myorder set address=?,tel=?,mycount=?,myprice=? where id=?";
            //这里调用预编译语句
            PreparedStatement ps=conn.prepareStatement(sql);
            //然后赋参数
            ps.setString(  1,myorder.getAddress());
            ps.setString(  2,myorder.getTel());
            ps.setInt( 3,myorder.getMycount());
            ps.setDouble(  4,myorder.getMyprice());
            ps.setInt( 5,myorder.getId());
            //最后执行
            int result=ps.executeUpdate();
            if(result>0){
                return true;
            }

        }catch(Exception e){

        }
        return false;
    }
}
