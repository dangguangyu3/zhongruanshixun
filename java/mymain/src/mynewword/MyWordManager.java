package mynewword;

import java.util.ArrayList;
import java.util.Scanner;

public class MyWordManager {
    public static void main(String[] args) {
        //实例化一下单词列表
        WordList wordlists = new WordList();
        //这里需要用户输入单词，然后保存
        //总共多少个单词，需要列表长度
        //通过getMywords方法，获取单词量
        int wordnum = wordlists.getMywords().size();
        //练习的所有数据在getMywords
        ArrayList<SimpleWord>mywordlists=wordlists.getMywords();
        //这里只实例化一次输入平台
        Scanner scanner = new Scanner(System.in);
        //计算总分，先初始化分数，不需要再循环里
        int score = 0;
        //喜欢for循环遍历
        for (int i = 0; i < wordnum; i++) {
            System.out.println("输出第"+(i+1)+"个单词的中文：");
            System.out.println(mywordlists.get(i).getChinese());
            System.out.println("请输入中文对应的英文：");
            String myword_english = scanner.next();
            if (mywordlists.get(i).check(myword_english)){
                System.out.println("答对了！");
                score += 10;
            }
            else{
                System.out.println("答错了！");
            }
        }
        //打印分数
        System.out.println("你的分数是：");
        System.out.println(score);
    }
}
