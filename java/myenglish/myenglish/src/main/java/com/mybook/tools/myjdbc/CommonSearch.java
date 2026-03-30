package com.mybook.tools.myjdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CommonSearch {
    public static List<Map<String,String>> findalldata(String table,int page) {
        try {
            //连接数据库
            java.sql.Connection conn = DataBaseConnection.getConnection();
            //查询所有数据的条数
            String countsql = "select count(*) mycount from " + table;
            java.sql.PreparedStatement ps1 = conn.prepareStatement(countsql);
            java.sql.ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            int datacount = rs1.getInt("mycount");
            String sql = "select * from " + table+" limit ?,?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            int total=(int)Math.ceil((double)datacount/3);
            int start=page<=total?(page-1)*3:(total-1)*3;// Calculate the starting index for the limit
            ps.setInt(1, start);
            ps.setInt(2, 3);
            java.sql.ResultSet rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int mylen = rsmd.getColumnCount();
            List<Map<String,String>> mybooks = new java.util.ArrayList<>();
            while (rs.next()) {
                Map<String, String> mybook = new java.util.HashMap<>();
                for (int i = 1; i <mylen; i++) {
                    //获取列名
                    String mykey = rsmd.getColumnName(i);
//                    System.out.println(mykey);
                    String myvalue = rs.getString(mykey);
                    mybook.put(mykey, myvalue);
                    mybook.put("total",total+"");
                }
                mybooks.add(mybook);
            }
//            System.out.println(mybooks);
            return mybooks;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

//    public static void main(String[] args) {
//        findalldata("mybook", 1);
//    }
}
