package mydocuments;

public class Category {
    protected String cate;
    public Category(String cate){
        this.cate = cate;
    }
    public String getCate(){
        return cate;
    }
    public Category(){

    }
    public void setCate(String cate) {
        this.cate = cate;
    }
    @Override
    public String toString() {
        return "Category{" +
                "cate='" + cate + '\'' +
                '}';
    }
}
