package com.digitalmall.service;

import com.digitalmall.dao.PhoneDAO;
import com.digitalmall.dao.impl.PhoneDAOImpl;
import com.digitalmall.entity.Phone;

import java.util.List;

/**
 * 手机商品服务类
 */
public class PhoneService {
    private PhoneDAO phoneDAO = new PhoneDAOImpl();

    /**
     * 查询所有手机商品
     * @return 手机商品列表
     */
    public List<Phone> findAllPhones() {
        return phoneDAO.findAll();
    }

    /**
     * 根据ID查询手机商品
     * @param id 手机ID
     * @return 手机商品对象
     */
    public Phone findPhoneById(int id) {
        return phoneDAO.findById(id);
    }

    /**
     * 根据品牌查询手机商品
     * @param brand 品牌
     * @return 手机商品列表
     */
    public List<Phone> findPhonesByBrand(String brand) {
        return phoneDAO.findByBrand(brand);
    }

    /**
     * 根据价格范围查询手机商品
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @return 手机商品列表
     */
    public List<Phone> findPhonesByPriceRange(double minPrice, double maxPrice) {
        return phoneDAO.findByPriceRange(minPrice, maxPrice);
    }

    /**
     * 新增手机商品
     * @param phone 手机商品对象
     * @return 是否新增成功
     */
    public boolean addPhone(Phone phone) {
        return phoneDAO.addPhone(phone);
    }

    /**
     * 修改手机商品信息
     * @param phone 手机商品对象
     * @return 是否修改成功
     */
    public boolean updatePhone(Phone phone) {
        return phoneDAO.updatePhone(phone);
    }

    /**
     * 上下架手机商品
     * @param id 手机ID
     * @param status 状态
     * @return 是否修改成功
     */
    public boolean updatePhoneStatus(int id, int status) {
        return phoneDAO.updateStatus(id, status);
    }

    /**
     * 删除手机商品
     * @param id 手机ID
     * @return 是否删除成功
     */
    public boolean deletePhone(int id) {
        return phoneDAO.deletePhone(id);
    }

    /**
     * 更新手机库存
     * @param id 手机ID
     * @param quantity 数量
     * @return 是否更新成功
     */
    public boolean updatePhoneStock(int id, int quantity) {
        return phoneDAO.updateStock(id, quantity);
    }
}