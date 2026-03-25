package com.mybook.user.controller;
/*
 * 测试反射
 */

import java.sql.SQLOutput;

public class MyRefletor {
    public static void main(String[] args){
        try{
            Class clz=Class.forName("com.mybook.user.bean.MyUser");
            clz.getFields();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
