package com.mybook.carts.controller;

import com.mybook.carts.beans.MyCart;
import java.util.List;

public interface MyCartControllerInterface {
    // 增
    public boolean addCart(MyCart mycart);

    // 删除，一般给定id进行删除
    public boolean delCart(int id);

    // 查询，查询所有
    public List<MyCart> findallcarts(int userid);
}
