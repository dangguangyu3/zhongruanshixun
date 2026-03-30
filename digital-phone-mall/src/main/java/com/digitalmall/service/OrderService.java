package com.digitalmall.service;

import com.digitalmall.dao.OrderDAO;
import com.digitalmall.dao.impl.OrderDAOImpl;
import com.digitalmall.entity.Order;
import com.digitalmall.entity.OrderItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 订单服务类
 */
public class OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private PhoneService phoneService = new PhoneService();
    private CartService cartService = new CartService();

    /**
     * 根据用户ID查询订单
     * @param userId 用户ID
     * @return 订单列表
     */
    public List<Order> findOrdersByUserId(int userId) {
        return orderDAO.findByUserId(userId);
    }

    /**
     * 查询所有订单
     * @return 订单列表
     */
    public List<Order> findAllOrders() {
        return orderDAO.findAll();
    }

    /**
     * 根据订单ID查询订单
     * @param id 订单ID
     * @return 订单对象
     */
    public Order findOrderById(int id) {
        return orderDAO.findById(id);
    }

    /**
     * 创建订单
     * @param order 订单对象
     * @param orderItems 订单详情列表
     * @return 是否创建成功
     */
    public boolean createOrder(Order order, List<OrderItem> orderItems) {
        // 生成订单号
        String orderNo = generateOrderNo();
        order.setOrderNo(orderNo);
        // 设置订单状态为待支付
        order.setStatus(0);
        // 创建订单
        int orderId = orderDAO.createOrder(order);
        if (orderId > 0) {
            // 添加订单详情
            for (OrderItem orderItem : orderItems) {
                orderItem.setOrderId(orderId);
                orderDAO.addOrderItem(orderItem);
                // 更新商品库存
                phoneService.updatePhoneStock(orderItem.getPhoneId(), orderItem.getQuantity());
            }
            // 清空购物车
            cartService.clearCart(order.getUserId());
            return true;
        }
        return false;
    }

    /**
     * 修改订单状态
     * @param id 订单ID
     * @param status 状态
     * @return 是否修改成功
     */
    public boolean updateOrderStatus(int id, int status) {
        return orderDAO.updateStatus(id, status);
    }

    /**
     * 根据状态查询订单
     * @param status 状态
     * @return 订单列表
     */
    public List<Order> findOrdersByStatus(int status) {
        return orderDAO.findByStatus(status);
    }

    /**
     * 生成订单号
     * @return 订单号
     */
    private String generateOrderNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date()) + (int)(Math.random() * 10000);
    }
}