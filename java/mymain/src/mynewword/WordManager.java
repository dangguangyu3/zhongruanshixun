package mynewword;

import java.util.Scanner;

public class WordManager {
    public static void main(String[] args) {
        System.out.println("欢迎来到单词管理系统");
        SimpleWord myword = new SimpleWord();
        System.out.println("----------------");
        System.out.println("输出一个的单词中文：");
        System.out.println(myword.getChinese());
        Scanner scanner = new Scanner(System.in);
        System.out.println("根据输入的中文输入英文单词：");
//        String myword_chinese = scanner.next();
        String myword_english = scanner.next();
        //当用户输入的英文单词，判断是否和保存的英文单词一致
        if (myword.check(myword_english)){
            System.out.println("答对了！");
        }
        else{
            System.out.println("答错了！");
        }
//        myword.chinese = myword_chinese;
//        myword.english = myword_english;
//        System.out.println("保存成功！");
//        System.out.println(myword.toString());
    }
}
