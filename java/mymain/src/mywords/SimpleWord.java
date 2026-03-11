package mywords;
/*
定义一个单词类
 */
public class SimpleWord {
    String chinese;
    String english;

    @Override
    public String toString() {
        return "SimpleWord{" +
                "chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                '}';
    }
}
