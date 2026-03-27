package com.mybook.orders.views;

import com.mybook.goods.beans.MyBook;

public class OrderView {

    //界面中显示订单,然后增删改查
    public static void showorder(MyBook mybook){

        // 商品信息显示
        System.out.println("\n" + "🔖 " + "======================================" + " 🔖");
        System.out.println("             商品详情");
        System.out.println("🔖 " + "======================================" + " 🔖\n");

        System.out.println("📦 商品名称：《" + mybook.getTitle() + "》");
        System.out.println("💰 商品价格：¥" + mybook.getPrice());
        System.out.println("📅 上架时间：" + mybook.getPublishtime());
        System.out.println("✍️ 作者：" + mybook.getAuthor());

        // 分隔线
        System.out.println("\n" + "----------------------------------------");

        // 菜单显示
        System.out.println("\n 请选择操作：");
        System.out.println("        ┌─────────────────────┐");
        System.out.println("        │  1  📝  输入购买数量   │");
        System.out.println("        │  2  📦  下单         │");
        System.out.println("        │  3  📜  查询以往订单   │");
        System.out.println("        └─────────────────────┘");

        // 底部提示
        System.out.print("\n🔔 请输入序号 [1-3]: ");
    }

    //这里增加一个测试方法
    public static void main(String[] args) {

    }
}
