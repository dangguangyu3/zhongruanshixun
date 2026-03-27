package com.mybook.orders.beans;

public class MyOrder {
    private int id;
    private int userid;
    private String goodname;
    private int mycount;
    private double myprice;
    private String address;
    private String tel;

    //属性比较多的，封装时只封装无参
    public MyOrder() {
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "id=" + id +
                ", userid=" + userid +
                ", goodname='" + goodname + '\'' +
                ", mycount=" + mycount +
                ", myprice=" + myprice +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public int getMycount() {
        return mycount;
    }

    public void setMycount(int mycount) {
        this.mycount = mycount;
    }

    public double getMyprice() {
        return myprice;
    }

    public void setMyprice(double myprice) {
        this.myprice = myprice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
