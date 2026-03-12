package mywords;

import java.util.ArrayList;
import java.util.Scanner;

/*
这里完成维护
多个单词的列表
 */
public class WordManagerList {
    public static void main(String[] args) {
        //循环输入单词的中英文，然后放在列表里
        //这里需要存储这里用到ArrayList，这里实例化ArrayList时需要指定一下列表中的数据类型，这里的列表中行储的是单词的对象
        // 这里实例化列表的作用，把列表变成空列表，这里面没有数据
        // ArrayList初始化在循环一次，就置空，然后重新添加数据
        // 保存，把ArrayList置空，这个ArrayList只执行一次
        ArrayList<SimpleWord> mywords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            //在这个循环中，让序号的选择一直操作
            System.out.println("-----------------------");
            System.out.println("------请选择操作方法------");
            System.out.println("------1.删除------------");
            System.out.println("------2.修改------------");
            System.out.println("------3.增加------------");
            System.out.println("------4.查询------------");
            System.out.println("------5.退出------------");
            System.out.println("------------------------");
            System.out.println("请输入你的选择：");
            //输入选择
            int choice = scanner.nextInt();
            //退出
            if (choice == 5){
                break;
            }
            switch (choice){
                case 1:
                    System.out.println("输入要删除的索引：");
                    //输入索引
                    int removeindex = scanner.nextInt();
                    //删除
                    mywords.remove(removeindex);
                    System.out.println("删除成功！");
                    System.out.println(mywords);
                    break;
                case 2:
                    System.out.println("输入要修改的索引：");
                    int Modifyindex = scanner.nextInt();
                    //用get方法获取索引对应的单词对象
                    SimpleWord myedit = mywords.get(Modifyindex);
                    //修改需要打印出原来的值，再询问用户修改成什么样的值
                    System.out.println("修改前的中文：");
                    System.out.println(myedit.chinese);
                    System.out.println("修改前的英文：");
                    System.out.println(myedit.english);
                    System.out.println("请输入修改后的中文：");
                    String myedit_chinese = scanner.next();
                    System.out.println("请输入修改后的英文：");
                    String myedit_english = scanner.next();
                    myedit.chinese = myedit_chinese;
                    myedit.english = myedit_english;
                    mywords.set(Modifyindex,myedit);
                    System.out.println("修改成功！");
                    System.out.println(mywords);
                    break;
                case 3:
                    System.out.println("输入要保存的英文单词：");
                    String myword_english = scanner.next();
                    if (myword_english.equals("q"))
                        break;
                    System.out.println("输入要保存的英文单词：");
                    String myword_chinese = scanner.next();
                    SimpleWord myword = new SimpleWord();
                    myword.chinese = myword_chinese;
                    myword.english = myword_english;
                    mywords.add(myword);
                    System.out.println("保存成功！");
                    System.out.println(mywords);
                    break;
                case 4:
                    System.out.println("输入要查询的索引：");
                    int queryindex = scanner.nextInt();
                    SimpleWord myquery = mywords.get(queryindex);
                    System.out.println("查询结果：");
                    System.out.println(myquery.chinese);
                    System.out.println(myquery.english);
                    System.out.println(mywords);
                    break;
                case 5:
                    System.out.println("已退出！");
                    break;
            }
        }
    }
}
