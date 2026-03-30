package com.digitalmall.dao;

import com.digitalmall.entity.Cart;

import java.util.List;

/**
 * 购物车DAO接口
 */
public interface CartDAO {
    /**
     * 根据用户ID查询购物车
     * @param userId 用户ID
     * @return 购物车列表
     */
    List<Cart> findByUserId(int userId);

    /**
     * 根据用户ID和手机ID查询购物车
     * @param userId 用户ID
     * @param phoneId 手机ID
     * @return 购物车对象
     */
    Cart findByUserIdAndPhoneId(int userId, int phoneId);

    /**
     * 添加商品到购物车
     * @param cart 购物车对象
     * @return 是否添加成功
     */
    boolean addCart(Cart cart);

    /**
     * 更新购物车商品数量
     * @param id 购物车ID
     * @param quantity 数量
     * @return 是否更新成功
     */
    boolean updateQuantity(int id, int quantity);

    /**
     * 删除购物车商品
     * @param id 购物车ID
     * @return 是否删除成功
     */
    boolean deleteCart(int id);

    /**
     * 根据用户ID清空购物车
     * @param userId 用户ID
     * @return 是否清空成功
     */
    boolean clearCart(int userId);
}