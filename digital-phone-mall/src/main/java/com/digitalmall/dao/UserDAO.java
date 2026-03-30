package com.digitalmall.dao;

import com.digitalmall.entity.User;

import java.util.List;

/**
 * 用户DAO接口
 */
public interface UserDAO {
    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户对象
     */
    User findByUsername(String username);

    /**
     * 注册新用户
     * @param user 用户对象
     * @return 是否注册成功
     */
    boolean register(User user);

    /**
     * 修改用户密码
     * @param userId 用户ID
     * @param newPassword 新密码
     * @return 是否修改成功
     */
    boolean updatePassword(int userId, String newPassword);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> findAll();

    /**
     * 根据用户ID查询用户
     * @param id 用户ID
     * @return 用户对象
     */
    User findById(int id);

    /**
     * 修改用户状态
     * @param userId 用户ID
     * @param status 状态
     * @return 是否修改成功
     */
    boolean updateStatus(int userId, int status);
}