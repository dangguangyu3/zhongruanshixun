package mywords;

import java.util.ArrayList;
import java.util.Scanner;

public class WordListManager {
    public static void main(String[] args) {
        //循环输入单词的中英文，然后放在列表里
        //这里需要存储这里用到ArrayList，这里实例化ArrayList时需要指定一下列表中的数据类型，这里的列表中行储的是单词的对象
        // 这里实例化列表的作用，把列表变成空列表，这里面没有数据
        // ArrayList初始化在循环一次，就置空，然后重新添加数据
        // 保存，把ArrayList置空，这个ArrayList只执行一次
        ArrayList<SimpleWord> mywords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("输入要保存的单词中文，输入q退出：");
            String myword_chinese = scanner.next();
            //退出
            if (myword_chinese.equals("q")){
                break;
            }
            System.out.println("输入要保存的英文单词：");
            String myword_english = scanner.next();
            //创建一个单词对象
            SimpleWord mysimple = new SimpleWord();
            mysimple.chinese = myword_chinese;
            mysimple.english = myword_english;
            //添加
            mywords.add(mysimple);
        }
        //输出结果
        System.out.println("mywords");
        //当数据显出成功后，可以让用户选择操作方法，这个操作方法就是数据库的管理
        System.out.println("-----------------------");
        System.out.println("------请选择操作方法------");
        System.out.println("------1.保存------------");
        System.out.println("------2.查询------------");
        System.out.println("------3.删除------------");
        System.out.println("------4.修改------------");
        System.out.println("------------------------");
        System.out.println("请输入你的选择：");
        //输入选择
        int choice = scanner.nextInt();
        if (choice == 3){
            System.out.println("输入要删除的单词中文索引：");
            //输入索引
            int myindex = scanner.nextInt();
            //删除
            mywords.remove(myindex);
        } else if (choice==4) {
            System.out.println("输入要修改的索引：");
            int myindex = scanner.nextInt();
            //用get方法获取索引对应的单词对象
            SimpleWord myedit = mywords.get(myindex);
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
            mywords.set(myindex,myedit);
            System.out.println("修改成功！");
        }
        System.out.println(mywords);
    }
}
