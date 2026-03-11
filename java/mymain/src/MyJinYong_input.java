import java.util.Scanner;

public class MyJinYong_input{
    public static void main(String[] args) {
        String[]  books={
                "连城诀",
                "飞狐外传",
                "雪山飞狐",
                "连城诀",
                "天龙八部",
                "射雕英雄传",
                "白马啸西风",
                "鹿鼎记",
                "笑傲江湖",
                "书剑恩仇录",
                "神雕侠侣",
                "侠客行",
                "倚天屠龙记",
                "碧血剑",
                "鸳鸯刀",
                "越女剑"
        };
        String[] mybooks = {
                "fei hu wai zhuan",
                "xue shan fei hu",
                "lian cheng jue",
                "tian long ba bu",
                "she diao ying xiong zhuan",
                "bai ma xiao xi feng",
                "lu ding ji",
                "xiao ao jiang hu",
                "shu jian en chou lu",
                "shen diao xia lv",
                "xia ke xing",
                "yi tian tu long ji",
                "bi xue jian",
                "yuan yang dao",
                "yue nv jian"
        };
        //完成数组中包含 s 的开头就可以
        System.out.println("--------------------------");
        System.out.println("------金庸小说全集----------");
        for(int i=0;i<books.length;i++){
            System.out.println(books[i]);
        }
        System.out.println("--------------------------");
        //这里用户输入指定的字母
        System.out.println("请输入您想查看的开头字母：");
        //输入字母
        Scanner scanner = new Scanner(System.in);
        String ch = scanner.next();
        //遍历
        for(int i=0;i<mybooks.length;i++){
            if (mybooks[i].startsWith(ch.toLowerCase())||mybooks[i].startsWith(ch.toUpperCase())){
                System.out.println("小说名称：");
                System.out.println(books[i]);
                System.out.println("这部小说以开头，全部英文为：");
                System.out.println(mybooks[i]);
            }
        }
    }
}
