package com.mybook.user.controller;
import com.mybook.user.bean.Myuser;
public interface UserController {
    public boolean login(String username, String password);
    public boolean register(Myuser user);
}
