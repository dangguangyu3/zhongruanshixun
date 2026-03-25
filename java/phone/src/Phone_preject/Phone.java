package Phone_preject;

public class Phone {
    //机型
    //芯片
    //评分
    private String model;
    private String chip;
    private double score;
    public Phone(String model,String chip,double score){
        this.model=model;
        this.chip=chip;
        this.score=score;
    }
    public String getModel(){
        return model;
    }
    public String getChip(){
        return chip;
    }
    public double getScore(){
        return score;
    }
    public Phone(){

    }
}
