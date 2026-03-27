package com.mybook.goods.beans;

public class MyUnit {
    // 私有成员变量
    private String unitname;

    // 无参构造方法
    public MyUnit() {
    }

    // 有参构造方法
    public MyUnit(String unitname) {
        this.unitname = unitname;
    }

    // Getter 方法
    public String getUnitname() {
        return unitname;
    }

    // Setter 方法
    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    // toString 方法（结合之前截图补全）
    @Override
    public String toString() {
        return "MyUnit{" +
                "unitname='" + unitname + '\'' +
                '}';
    }
}