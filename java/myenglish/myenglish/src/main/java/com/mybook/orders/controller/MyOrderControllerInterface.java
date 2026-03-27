package com.mybook.orders.controller;

import com.mybook.orders.beans.MyOrder;
import java.util.List;

public interface MyOrderControllerInterface {
    // 查询订单，只能查当前用户，参数用户id，返回值是订单列表
    public List<MyOrder> findallorders(int userid);

    // 生成订单
    public boolean insertorder(MyOrder myorder, int goodid);

    // 退单，就是删除订单，删除订单只能按id来删除
    public boolean deleteOrder(int id);

    // 修改订单，对于订单只能修改购买数量，地址，电话
    public boolean modifyOrder(MyOrder myorder);
}
