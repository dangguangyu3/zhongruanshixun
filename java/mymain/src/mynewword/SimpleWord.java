package mynewword;
/*
定义一个单词类
 */
public class SimpleWord {
    private String chinese="中国";
    private String english="china";
    //变量私有化，定义一个访问方法
    public String getChinese() {
        return chinese;
    }


    @Override
    public String toString() {
        return "SimpleWord{" +
                "chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                '}';
    }
}
