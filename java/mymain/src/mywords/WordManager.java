package mywords;

import java.util.Scanner;

public class WordManager {
    public static void main(String[] args) {
        System.out.println("欢迎来到单词管理系统");
        System.out.println("----------------");
        System.out.println("输入要保存的单词中文：");
        Scanner scanner = new Scanner(System.in);
        String myword_chinese = scanner.next();
        System.out.println("输入要保存的英文单词：");
        String myword_english = scanner.next();
        SimpleWord myword = new SimpleWord();
        myword.chinese = myword_chinese;
        myword.english = myword_english;
        System.out.println("保存成功！");
        System.out.println(myword.toString());
    }
}
