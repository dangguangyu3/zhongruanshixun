package com.mybook.goods.views;

import com.mybook.carts.beans.MyCart;
import com.mybook.carts.controller.MyCartController;
import com.mybook.goods.beans.MyBook;
import com.mybook.goods.controller.BookController;
import com.mybook.orders.views.OrderView;
import com.mybook.tools.instance.UserSimpleInstance;
import com.mybook.tools.myjdbc.CommonSearch;
import com.mybook.tools.myjdbc.FindHashMap;

import java.util.Scanner;

public class BookView {

    //这里查询商品的方法中给定一个id，便于商品列表的调用
    public static void myviewbook(int id){

        //调用Controller方法
        BookController mybookcontroller=new BookController();
        MyBook mybook=mybookcontroller.findById(id);
        System.out.println(mybook);

        System.out.println("\n" + "🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗");
        System.out.println("        🔔 商品操作菜单 🔔");
        System.out.println("🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗🔗");

        System.out.println("        ┌─────────────────────┐");
        System.out.println("        │  1  🛒  加入购物车   │");
        System.out.println("        │  2  🛍️  直接购买     │");
        System.out.println("        │  3  🔄  返回         │");
        System.out.println("        └─────────────────────┘");

        System.out.println("-------------------------------------------");
        System.out.print("🔍 请选择操作 [1-3]: ");
        Scanner mybookscanner = new Scanner(System.in);
        //这里接收1,2,3
        int bookoption=mybookscanner.nextInt();
        switch(bookoption){
            case 1:
                //第一个加入购物车
                MyCartController myCartController = new MyCartController();
                //这里实例化一个MyCart
                MyCart mynewcart=new MyCart();
                mynewcart.setGoodid(id);
                //这里需要登录的用户id
                mynewcart.setUserid(UserSimpleInstance.getMyInstance());

                boolean cartflag=myCartController.addCart(mynewcart);
                if(cartflag){
                    System.out.println("\n" + "✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
                    System.out.println("         🛍️ 加入购物车成功 🛍️");
                    System.out.println("         🛍️ 敲回车键进入到商品列表 🛍️");
                    System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
                }else{
                    System.out.println("\n" + "✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
                    System.out.println("         🛍️ 加入购物车失败 🛍️");
                    System.out.println("         🛍️ 敲回车键进入到商品列表 🛍️");
                    System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
                }
                //然后再敲一下回车,回到商品列表
                Scanner enterline=new Scanner(System.in);
                //nextLine表示遇到回车换行,这个数据不接收

                enterline.nextLine();
                //这个nextLine不接收,直接返回商品列表
                FindHashMap.searchall(CommonSearch.findalldata("mybook",1));
                break;
            case 2:
                OrderView.showorder(mybook);
                break;
            case 3:
                //这里在另个一个类中，返回，返回动作是返回到列表
                FindHashMap.searchall(CommonSearch.findalldata("mybook",1));
                break;
        }
    }

    //给定一个主类的测试方法
    public static void main(String[] args) {
        myviewbook(  32);
    }
}
