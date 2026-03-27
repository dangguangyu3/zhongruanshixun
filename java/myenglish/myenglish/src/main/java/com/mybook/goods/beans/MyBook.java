package com.mybook.goods.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyBook {
    private int id;
    private String title;
    private double price;
    private String author;
    private String publisher;
    private String publishtime;
    private int cate;
    private String isbn;
    private String description;
    private ArrayList<MyUnit> booklists=new ArrayList<>();
    //封装时只产生一个无参构造，在实例时比较方便
    public MyBook() {
    }
    //再把toString方法生成

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        // 头部装饰
        sb.append("\n");
        sb.append("📚==================================================== 书籍详情 ====================================================\n");
        sb.append("\n");

        // 基本信息 - 每个字段单独一行，清晰明了
        sb.append("📖 书名：《" + title + "》\n");
        sb.append("💰 价格：¥" + price + "\n");
        sb.append("✍️ 作者：" + author + "\n");
        sb.append("🏢 出版社：" + publisher + "\n");
        sb.append("📅 出版时间：" + publishtime + "\n");
        sb.append("🔖 ISBN：" + isbn + "\n");
        sb.append("🎯 分类编号：" + cate + "\n\n");

        // 内容简介 - 保持原样，不截断
        sb.append("📝 内容简介：\n");
        // 移除开头的全角空格，但保留其他格式
        String cleanDesc = description.replaceAll("^[　 ]+", "");
        sb.append(cleanDesc + "\n\n");

        // 目录
        sb.append("📖==================================================== 目录 ====================================================\n");
        if (booklists != null && !booklists.isEmpty()) {
            for (MyUnit unit : booklists) {
                String unitName = unit.getUnitname();

                // 根据单元类型添加不同的emoji
                if (unitName.contains("Unit")) {
                    sb.append("  📌 " + unitName + "\n");
                } else if (unitName.contains("Tests")) {
                    sb.append("  ✅ " + unitName + "\n");
                } else if (unitName.contains("Answers")) {
                    sb.append("  ✅ " + unitName + "\n");
                } else if (unitName.contains("Word list")) {
                    sb.append("  📝 " + unitName + "\n");
                } else if (unitName.contains("Word list")) {
                    sb.append("  📝 " + unitName + "\n");
                } else {
                    sb.append("  • " + unitName + "\n");
                }

            }
        } else {
            sb.append("  暂无目录信息\n");
        }

        // 底部装饰
        sb.append("\n✨==================================================== 结束 ====================================================\n");

        return sb.toString();
    }

    //然后再getter和setter方法
    //这里是单元的getter
    public ArrayList<MyUnit> getBooklists() {
        return booklists;
    }
    //这里是单元内容的setter，数据库中存储的是字符串，
    //这里操作简易，把传入的字符串处理
    public void setBooklists(String bookunits) {
        //这里把字符串进行处理
        //这里Arrays是数组操作的工具类，后面asList变成列表，split方法结果是数组
        List<String> mylists=Arrays.asList(bookunits.split( ","));
        //遍历构建List<MyUnit>
        for(int i=0;i<mylists.size();i++){
            MyUnit myunit=new MyUnit();
            myunit.setUnitname(mylists.get(i));
            this.booklists.add(myunit);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public int getCate() {
        return cate;
    }

    public void setCate(int cate) {
        this.cate = cate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}