package com.digitalmall.dao;

import com.digitalmall.entity.Order;
import com.digitalmall.entity.OrderItem;

import java.util.List;

/**
 * 订单DAO接口
 */
public interface OrderDAO {
    /**
     * 根据用户ID查询订单
     * @param userId 用户ID
     * @return 订单列表
     */
    List<Order> findByUserId(int userId);

    /**
     * 查询所有订单
     * @return 订单列表
     */
    List<Order> findAll();

    /**
     * 根据订单ID查询订单
     * @param id 订单ID
     * @return 订单对象
     */
    Order findById(int id);

    /**
     * 创建订单
     * @param order 订单对象
     * @return 订单ID
     */
    int createOrder(Order order);

    /**
     * 添加订单详情
     * @param orderItem 订单详情对象
     * @return 是否添加成功
     */
    boolean addOrderItem(OrderItem orderItem);

    /**
     * 修改订单状态
     * @param id 订单ID
     * @param status 状态
     * @return 是否修改成功
     */
    boolean updateStatus(int id, int status);

    /**
     * 根据状态查询订单
     * @param status 状态
     * @return 订单列表
     */
    List<Order> findByStatus(int status);
}