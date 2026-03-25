package com.mybook.user.views;
import com.mybook.user.controller.UserControllerImpl;
import com.mybook.user.controller.UserController;

import java.util.Scanner;

public class Login {
    public void mylogin(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("请输入用户名：");
        String myusername=scanner.next();
        System.out.println("请输入密码：");
        String mypasswd=scanner.next();
        UserController userController=new UserControllerImpl();
        boolean flag=userController.login(myusername,mypasswd);
        if (flag){
            System.out.println("####   #    #  ####   ####  ######  ####   ####");
            System.out.println("#      #    # #    # #    # #      #      #    ");
            System.out.println(" ####  #    # #      #      #####   ####   ####");
            System.out.println("    # #    # #      #      #           #      #");
            System.out.println("#    # #    # #    # #    # #      #    # #    #");
            System.out.println(" ####   ####   ####   ####  ######  ####   ####");
            System.out.println("登陆成功");
        }
        else {
            System.out.println("######   ##   # #      ###### #####  ");
            System.out.println("#       #  #  # #      #      #    # ");
            System.out.println("#####  #    # # #      #####  #    # ");
            System.out.println("#      ###### # #      #      #    # ");
            System.out.println("#      #    # # #      #      #    # ");
            System.out.println("#      #    # # ###### ###### #####  ");
            System.out.println("登陆失败");
        }
    }
}
