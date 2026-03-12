package mynewword;

import java.util.ArrayList;

/*
这里是练习十个单词的列表
 */
public class WordList {
    private ArrayList<SimpleWord> mywords=new ArrayList<>();
    //这个变量需要外部访问，所以需要定义一个方法
    //这里为了方便，在new实例化时，列表中就有单词
    //这里把赋值操作的代码放在构造方法中
    public WordList(){
        mywords.add(new SimpleWord("china", "中国"));
        mywords.add(new SimpleWord("beijing", "北京"));
        mywords.add(new SimpleWord("shanghai", "上海"));
        mywords.add(new SimpleWord("guangzhou", "广州"));
        mywords.add(new SimpleWord("shenzhen", "深圳"));
        mywords.add(new SimpleWord("hangzhou", "杭州"));
        mywords.add(new SimpleWord("nanjing", "南京"));
        mywords.add(new SimpleWord("wuhan", "武汉"));

    }
    public ArrayList<SimpleWord> getMywords() {
        return mywords;
    }

}
