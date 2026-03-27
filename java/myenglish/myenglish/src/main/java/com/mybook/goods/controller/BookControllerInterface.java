package com.mybook.goods.controller;
import com.mybook.goods.beans.MyBook;

public interface BookControllerInterface {
    //根据给定id查找商品
    public MyBook findById(int id);
}
