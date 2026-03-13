package mydocuments;

import java.util.ArrayList;

public class HyperversionArticle extends Article{
    @Override
    public void send() {
        System.out.println("推送信息给专业的高血压医师");
    }

    public HyperversionArticle(){
        cate="hyperversion";
    }

}

