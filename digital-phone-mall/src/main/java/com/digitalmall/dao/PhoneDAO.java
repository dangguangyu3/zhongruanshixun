package com.digitalmall.dao;

import com.digitalmall.entity.Phone;

import java.util.List;

/**
 * 手机商品DAO接口
 */
public interface PhoneDAO {
    /**
     * 查询所有手机商品
     * @return 手机商品列表
     */
    List<Phone> findAll();

    /**
     * 根据ID查询手机商品
     * @param id 手机ID
     * @return 手机商品对象
     */
    Phone findById(int id);

    /**
     * 根据品牌查询手机商品
     * @param brand 品牌
     * @return 手机商品列表
     */
    List<Phone> findByBrand(String brand);

    /**
     * 根据价格范围查询手机商品
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 手机商品列表
     */
    List<Phone> findByPriceRange(double minPrice, double maxPrice);

    /**
     * 新增手机商品
     * @param phone 手机商品对象
     * @return 是否新增成功
     */
    boolean addPhone(Phone phone);

    /**
     * 修改手机商品信息
     * @param phone 手机商品对象
     * @return 是否修改成功
     */
    boolean updatePhone(Phone phone);

    /**
     * 修改手机商品状态
     * @param id 手机ID
     * @param status 状态
     * @return 是否修改成功
     */
    boolean updateStatus(int id, int status);

    /**
     * 删除手机商品
     * @param id 手机ID
     * @return 是否删除成功
     */
    boolean deletePhone(int id);

    /**
     * 更新手机库存
     * @param id 手机ID
     * @param quantity 数量
     * @return 是否更新成功
     */
    boolean updateStock(int id, int quantity);
}