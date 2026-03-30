package com.digitalmall.service;

import com.digitalmall.dao.UserDAO;
import com.digitalmall.dao.impl.UserDAOImpl;
import com.digitalmall.entity.User;

import java.util.List;

/**
 * 用户服务类
 */
public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    public User login(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }

    /**
     * 用户注册
     * @param user 用户对象
     * @return 是否注册成功
     */
    public boolean register(User user) {
        // 检查用户名是否已存在
        User existingUser = userDAO.findByUsername(user.getUsername());
        if (existingUser != null) {
            return false;
        }
        // 设置用户角色为普通用户
        user.setRole(0);
        // 设置用户状态为正常
        user.setStatus(1);
        return userDAO.register(user);
    }

    /**
     * 修改密码
     * @param userId 用户ID
     * @param newPassword 新密码
     * @return 是否修改成功
     */
    public boolean updatePassword(int userId, String newPassword) {
        return userDAO.updatePassword(userId, newPassword);
    }

    /**
     * 查询所有用户
     * @return 用户列表
     */
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户对象
     */
    public User findUserById(int id) {
        return userDAO.findById(id);
    }

    /**
     * 修改用户状态
     * @param userId 用户ID
     * @param status 状态
     * @return 是否修改成功
     */
    public boolean updateUserStatus(int userId, int status) {
        return userDAO.updateStatus(userId, status);
    }
}