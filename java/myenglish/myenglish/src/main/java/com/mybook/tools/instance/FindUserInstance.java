package com.mybook.tools.instance;
/*
单例的方法
只实例化一次即可
 */
public  class FindUserInstance {

    //这里存在一个用户的变量
    private int userid=1;
    //在单例的实例化类中添加identify的身份验证,如果值为0,就是普通用户
    private int identify=0;
    //封装getter和setter方法


    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}


