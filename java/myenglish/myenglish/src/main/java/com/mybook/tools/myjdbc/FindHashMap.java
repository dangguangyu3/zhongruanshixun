package com.mybook.tools.myjdbc;

import java.util.*;

public class FindHashMap {
    //给定哈希表中文与英文的对应关系
    static Map<String,String> fieldMap=new HashMap<String,String>(){{
        //id
        //title
        //price
        //author
        //publisher
        //publishtime
        //cate
        //isbn
        //description
        //booklists
        put("id","图书ID");
        put("title","图书名称");
        put("price","图书价格");
        put("author","作者");
        put("publisher","出版社");
        put("publishtime","出版时间");
        put("cate","图书类别");
        put("isbn","ISBN");
        put("description","图书简介");
    }};
    public static void searchall(List<Map<String,String>> mylist){
        if (mylist == null || mylist.size() == 0) {
            System.out.println("\n⚠️  暂无数据\n");
            return;
        }
        
        int len = mylist.size();
        
        // 定义列宽
        final int TITLE_WIDTH = 35;
        final int PRICE_WIDTH = 12;
        final int TIME_WIDTH = 22;
        final int TOTAL_WIDTH = TITLE_WIDTH + PRICE_WIDTH + TIME_WIDTH + 8;
        
        // 打印顶部装饰和标题
        System.out.println();
        System.out.println("╔" + repeatChar("═", TOTAL_WIDTH - 2) + "╗");
        System.out.println("║" + centerText("     📚 图书信息列表 📚     ",  TOTAL_WIDTH - 4) + "║");
        System.out.println("╠" + repeatChar("═", TOTAL_WIDTH - 2) + "╣");
        System.out.println("║ " + centerText("📖 图书名称", TITLE_WIDTH) + " │ " + centerText("💰 价格", PRICE_WIDTH) + " │ " + centerText("📅 出版时间", TIME_WIDTH) + " ║");
        System.out.println("╟" + repeatChar("─", TITLE_WIDTH) + "┼" + repeatChar("─", PRICE_WIDTH) + "┼" + repeatChar("─", TIME_WIDTH) + "╢");
        
        // 输出数据行
        for (int i = 0; i < len; i++) {
            Map<String, String> book = mylist.get(i);
            
            String mytitle_book = getFieldValue(book, "title");
            String myprice_book = getFieldValue(book, "price");
            String mypublishtime = getFieldValue(book, "publishtime");
            
            // 截断过长的文本
            mytitle_book = truncate(mytitle_book, TITLE_WIDTH);
            myprice_book = truncate(myprice_book, PRICE_WIDTH);
            mypublishtime = truncate(mypublishtime, TIME_WIDTH);
            
            System.out.println("║ " + padRight(mytitle_book, TITLE_WIDTH) + " │ " + 
                              padRight(myprice_book, PRICE_WIDTH) + " │ " + 
                              padRight(mypublishtime, TIME_WIDTH) + " ║");
        }


        // 底部边框和统计信息
        System.out.println("╚" + repeatChar("═", TOTAL_WIDTH - 2) + "╝");
        System.out.println("✅ 共查询到：" + len + " 条记录\n");
        Scanner mypage=new Scanner(System.in);
        System.out.println("请输入页码：");
        int pagenum=mypage.nextInt();
        if (pagenum>Integer.parseInt(mylist.get(0).get("total"))){
            System.out.println("没有更多数据");
            searchall(CommonSearch.findalldata("mybook",1));
        }
        else {
            searchall(CommonSearch.findalldata("mybook",pagenum));
        }
    }
    
    // 获取字段值（不区分大小写）
    private static String getFieldValue(Map<String, String> data, String fieldName) {
        if (data == null || fieldName == null) {
            return "";
        }
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(fieldName)) {
                return entry.getValue() != null ? entry.getValue() : "";
            }
        }
        return "";
    }
    
    // 重复字符
    private static String repeatChar(String ch, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
    
    // 文本居中
    private static String centerText(String text, int totalLength) {
        int textLen = calcLength(text);
        int leftPad = (totalLength - textLen) / 2;
        int rightPad = totalLength - textLen - leftPad;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leftPad; i++) sb.append(" ");
        sb.append(text);
        for (int i = 0; i < rightPad; i++) sb.append(" ");
        return sb.toString();
    }
    
    // 左对齐（右填充）
    private static String padRight(String text, int totalLength) {
        StringBuilder sb = new StringBuilder(text);
        while (calcLength(sb.toString()) < totalLength) {
            sb.append(" ");
        }
        return sb.toString();
    }
    
    // 截断文本
    private static String truncate(String text, int maxLength) {
        if (text == null) return "";
        if (calcLength(text) <= maxLength) return text;
        
        if (maxLength >= 3) {
            StringBuilder sb = new StringBuilder();
            int currentLen = 0;
            for (char c : text.toCharArray()) {
                int charLen = (c > 127 || Character.isSurrogate(c)) ? 2 : 1;
                if (currentLen + charLen > maxLength - 2) break;
                sb.append(c);
                currentLen += charLen;
            }
            sb.append("..");
            return sb.toString();
        }
        return text.substring(0, Math.min(maxLength, text.length()));
    }
    
    // 计算文本显示长度
    private static int calcLength(String text) {
        if (text == null) return 0;
        int len = 0;
        for (char c : text.toCharArray()) {
            len += (Character.isSurrogate(c) || c > 127) ? 2 : 1;
        }
        return len;
    }
    public static void main(String[] args) {
        searchall(CommonSearch.findalldata("mybook",1));
    }
}