package com.mybook.carts.views;

import com.mybook.carts.beans.MyCart;
import com.mybook.carts.controller.MyCartController;
import com.mybook.goods.beans.MyBook;
import com.mybook.orders.views.OrderView;
import com.mybook.tools.instance.UserSimpleInstance;
import com.mybook.tools.myjdbc.CommonSearch;
import com.mybook.tools.myjdbc.FindHashMap;

import java.util.List;
import java.util.Scanner;

public class CartView {

    public static void showcartsall() {
        // 先实例化Controller
        MyCartController mycartcontroller = new MyCartController();
        // 调用所有的购物车列表，这里需要传入一个userid，这里暂时先设置为1
        // 在查询的时候，userid通过单例来获取的
        int myuserid = UserSimpleInstance.getMyInstance().getUserId();
        List<MyCart> mycarts = mycartcontroller.findallcarts(myuserid);
        // 打印标题
        System.out.println("\n🛒 *** 您 的 购 物 车 *** 🛒");

        if (mycarts.isEmpty()) {
            // 空购物车显示
            System.out.println("┌──────────────────────────┐");
            System.out.println("│                          │");
            System.out.println("│        🛒 购物车空空如也  │");
            System.out.println("│        赶 快 去 逛 一 逛 吧 │");
            System.out.println("│                          │");
            System.out.println("└──────────────────────────┘");

            // 打印菜单（带框）
            System.out.println("\n┌──────────────┐");
            System.out.println("│   操作菜单   │");
            System.out.println("│              │");
            System.out.println("│  1 --- ↩️ 返回 │");
            System.out.println("│              │");
            System.out.println("└──────────────┘");
            System.out.print("🛎️  再敲击回车后，返回到商品列表 🛎️");
            Scanner emptycar = new Scanner(System.in);
            emptycar.nextLine();
            FindHashMap.searchall(CommonSearch.findalldata("mybook", 1));

        } else {
            // 有数据时显示表格
            // 表格头部分分隔线
            System.out.println("┌────┬──────────────────┬──────────────┬────────────┬──────────┐");
            System.out.printf("| %-2s | %-26s | %-16s | %-12s | %-6s |%n",
                    "ID", "商品名称", "作者", "上架时间", "价格(元)");
            System.out.println("├────┼──────────────────┼──────────────┼────────────┼──────────┤");

            // 打印每个商品
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for (MyCart item : mycarts) {
                System.out.printf("| %-2d | %-26s | %-16s | %-12s | %6.2f |%n",
                        item.getId(),
                        item.getGoodname(),
                        item.getAuthor(),
                        item.getPublishertime(),
                        item.getPrice());
            }

            // 表格底部
            System.out.println("└────┴──────────────────┴──────────────┴────────────┴──────────┘");

            // 打印菜单（带框）
            System.out.println("\n┌──────────────────────────┐");
            System.out.println("│        操作菜单          │");
            System.out.println("│                          │");
            System.out.println("│  1 --- 🗑️  删除           │");
            System.out.println("│  2 --- 📦  选择商品下单   │");
            System.out.println("│  3 --- ↩️  返回           │");
            System.out.println("│                          │");
            System.out.println("└──────────────────────────┘");
            System.out.print("请选择操作 (1/2/3): ");

            // 用户输入内容
            Scanner carscanner = new Scanner(System.in);
            int caroption = carscanner.nextInt();

            switch (caroption) {
                case 1:
                    // 这里打印一个提示信息
                    System.out.println("✏️  *** 输入需要删除的购物车id *** ✏️");
                    // 提示输入id后接收id
                    int cartid = carscanner.nextInt();
                    // 根据id进行删除的操作，实例化CarController
                    boolean carflag = mycartcontroller.delCart(cartid);
                    if (carflag) {
                        System.out.println("\n┌──────────────────────────┐");
                        System.out.println("│        操作提示          │");
                        System.out.println("│                          │");
                        System.out.println("│      删除购物车成功       │");
                        System.out.println("│                          │");
                        System.out.println("└──────────────────────────┘");
                    } else {
                        System.out.println("\n┌──────────────────────────┐");
                        System.out.println("│        操作提示          │");
                        System.out.println("│                          │");
                        System.out.println("│      删除购物车失败       │");
                        System.out.println("│                          │");
                        System.out.println("└──────────────────────────┘");
                    }
                    // 继续回到购物车的管理界面，递归调用自己
                    showcartsall();
                    break;

                case 2:
                    // 直接进入到下单的页面
                    System.out.println("✏️  *** 输入需要下单的商品顺序号:1,2,3 *** ✏️");
                    int inputid = carscanner.nextInt();
                    // 代码前面获取过购物车的列表，列表的索引值从0开始
                    int mygoodid = mycarts.get(inputid - 1).getGoodid();
                    // 接下来根据goodid进行商品的下单，根据OrderView的参数，需要传入MyBook
                    MyBook mybooknew = new MyBook();
                    mybooknew.setId(mygoodid);
                    mybooknew.setTitle(mycarts.get(inputid - 1).getGoodname());
                    mybooknew.setAuthor(mycarts.get(inputid - 1).getAuthor());
                    mybooknew.setPrice(mycarts.get(inputid - 1).getPrice());
                    mybooknew.setPublishtime(mycarts.get(inputid - 1).getPublishertime());
                    OrderView.showorder(mybooknew);
                    break;

                case 3:
                    FindHashMap.searchall(CommonSearch.findalldata("mybook", 1));
                    break;
            }
        }
    }

    // 下面做一个测试方法
    public static void main(String[] args) {
        showcartsall();
    }
}