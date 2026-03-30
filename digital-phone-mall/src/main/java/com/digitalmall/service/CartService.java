package com.digitalmall.service;

import com.digitalmall.dao.CartDAO;
import com.digitalmall.dao.impl.CartDAOImpl;
import com.digitalmall.entity.Cart;

import java.util.List;

/**
 * 购物车服务类
 */
public class CartService {
    private CartDAO cartDAO = new CartDAOImpl();

    /**
     * 根据用户ID查询购物车
     * @param userId 用户ID
     * @return 购物车列表
     */
    public List<Cart> findCartByUserId(int userId) {
        return cartDAO.findByUserId(userId);
    }

    /**
     * 添加商品到购物车
     * @param cart 购物车对象
     * @return 是否添加成功
     */
    public boolean addToCart(Cart cart) {
        // 检查购物车中是否已存在该商品
        Cart existingCart = cartDAO.findByUserIdAndPhoneId(cart.getUserId(), cart.getPhoneId());
        if (existingCart != null) {
            // 如果已存在，更新数量
            int newQuantity = existingCart.getQuantity() + cart.getQuantity();
            return cartDAO.updateQuantity(existingCart.getId(), newQuantity);
        } else {
            // 如果不存在，添加新记录
            return cartDAO.addCart(cart);
        }
    }

    /**
     * 更新购物车商品数量
     * @param id 购物车ID
     * @param quantity 数量
     * @return 是否更新成功
     */
    public boolean updateCartQuantity(int id, int quantity) {
        return cartDAO.updateQuantity(id, quantity);
    }

    /**
     * 删除购物车商品
     * @param id 购物车ID
     * @return 是否删除成功
     */
    public boolean deleteCartItem(int id) {
        return cartDAO.deleteCart(id);
    }

    /**
     * 清空购物车
     * @param userId 用户ID
     * @return 是否清空成功
     */
    public boolean clearCart(int userId) {
        return cartDAO.clearCart(userId);
    }
}