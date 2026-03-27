package com.mybook.user.views;

import com.mybook.user.bean.Myuser;
import com.mybook.user.controller.UserController;
import com.mybook.user.controller.UserControllerImpl;

public class Register {
    public String myregister() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("请输入用户名：");
        String myusername=scanner.next();
        System.out.println("请输入密码：");
        String mypasswd=scanner.next();
        Myuser myuser=new Myuser();
        myuser.setUsername(myusername);
        myuser.setPassword(mypasswd);
        myuser.setIdentity(0);
        UserController userController=new UserControllerImpl();
        boolean flag=userController.register(myuser);
        if (flag){
            return "注册成功"+myusername;
        }
        else {
            return "注册失败";
        }
    }
}
