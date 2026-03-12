package mynewword;
/*
定义一个单词类
 */
public class SimpleWord {
    private String chinese="中国";
    private String english="china";

    public SimpleWord(String english, String chinese) {
        this.english = english;
        this.chinese = chinese;
    }

    public SimpleWord() {
    }

    //在类中提供一个方法，构造方法在实例化的时候执行
    //默认的构造方法没有参数，所以SimpleWord()
    //这里把两个参数加入其中
    //变量私有化，定义一个访问方法
    public String getChinese() {
        return chinese;
    }
    //定义一方法，根据用户的输入内容来判断用户输入的英文与中文是否一致
    // 返回值 boolean
    public boolean check(String myenglish){
        //这里不能写Scanner,因为别人用你的对象，就得实例化，有可能执行很多遍
        //这里scanner写在主程序中只执行一次，这里就把check接收参数
        if (english.equals(myenglish)){
            return true;
        }
        else{
            return false;
        }
    }
    //setter的做法
    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "SimpleWord{" +
                "chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                '}';
    }
}
