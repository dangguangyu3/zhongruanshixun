package mydocuments;

import java.util.ArrayList;

public class CancerArticle extends Article{

    public void send() {
        System.out.println("推送信息到肿瘤专业医师");
    }

    public CancerArticle(){
        cate="cancer";
    }
}

