import java.util.Scanner;

public class MyJinYong_input2 {
    public static void main(String[] args) {
        //先把小说和英文罗列出来
        String[] books = find_books();
        String[] mybooks = find_english_books();
        print_books(books);
        print_books_by_char(books,mybooks);
    }
    //定义一个根据首字母打印的方法
    public static void print_books_by_char(String[] books,String[] mybooks){
        //定义一个标志位
        boolean flag = true;
        //需要不停的问用户是否继续，不知道什么时候结束
        while(true){
            flag=true;
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
            if ( flag){
                break;
            }
        }
    }
    //在定义打印小说的函数
    public static void print_books(String[] books){
        System.out.println("--------------------------");
        System.out.println("------金庸小说全集----------");
        for(int i=0;i<books.length;i++){
            System.out.println(books[i]);
        }
        System.out.println("--------------------------");
    }
    //定义金庸小说的函数，返回金庸小说的列表
    public static String[] find_books(){
        String[] books={
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
                "碧血剑"
        };
        return books;
    }
    //定义金庸小说的英文函数，返回金庸小说的英文列表
    public static String[] find_english_books(){
        String[] books={
                "fei hu wai zhuan",
                "xue shan fei hu",
                "lian cheng jue",
                "tian long ba bu",
                "she diao ying xiong zhuan",
                "bai ma xiao xi feng",
                "lu ding ji",
                "xiao ao jiang hu",
                "shu jian en chou lu",
                "shen diao xia lv"
        };
        return books;
    }
}
