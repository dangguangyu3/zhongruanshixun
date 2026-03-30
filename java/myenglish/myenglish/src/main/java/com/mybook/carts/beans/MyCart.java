package com.mybook.carts.beans;

/**
 * 控制台的购物车可以
 * 理解成收藏功能
 */
public class MyCart {
    private int id;
    private int goodid;
    private int userid;
    // 在mycart表中原有内容基础还需要再添加
    private String goodname;
    private String author;
    private String publishertime;
    private double price;

    // 这里只有无参构造
    public MyCart() {
    }

    // 再封装toString方法
    @Override
    public String toString() {
        return "MyCart{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", userid=" + userid +
                ", goodname='" + goodname + '\'' +
                ", author='" + author + '\'' +
                ", publishertime='" + publishertime + '\'' +
                ", price=" + price +
                '}';
    }

    // 再封装getter和setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishertime() {
        return publishertime;
    }

    public void setPublishertime(String publishertime) {
        this.publishertime = publishertime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
