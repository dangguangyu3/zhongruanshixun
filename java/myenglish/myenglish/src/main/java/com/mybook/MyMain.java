package com.mybook;

import com.mybook.tools.myjdbc.CommonSearch;
import com.mybook.tools.myjdbc.FindHashMap;
import com.mybook.user.views.Login;
import com.mybook.user.views.Register;

import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        String newuser="匿名用户";
        while (true) {
            showMenu(newuser) ;
            Scanner sc = new Scanner(System.in);
            int chose = sc.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("登录");
                    Login login = new Login();
                    login.mylogin();
                    break;
                case 2:
                    Register register = new Register();
                    register.myregister();
                    break;
                case 3:
                    FindHashMap.searchall(CommonSearch.findalldata("mybook",1));
                    break;
                case 4:
                    System.out.println("退出");
                    break;
                default:
                    System.out.println("无效的选项");
                    break;
                }
            }
        }

        public static void showMenu(String newuser) {
            System.out.println("\n┌───────────────────────────────┐");
            System.out.println("│         🌈 主菜单 🌈             │");
            System.out.println("├─────────────────────────────────┤");
            System.out.println("│   1️⃣   登录                      │");
            System.out.println("│   2️⃣   注册                      │");
            System.out.println("│   3️⃣   商品列表                   │");
            System.out.println("│   4️⃣   退出   👋                 │");
            System.out.println("└─────────────────────────────────┘");
            System.out.print("请选择：");
            System.out.println("当前登录用户"+newuser);
    }
}
