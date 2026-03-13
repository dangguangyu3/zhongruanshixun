package mydocuments;
/**
 为程序提供可扩展性
 网页上面的是作者链接
 将通过添加作者的相关信息可以在此类中说明
 */

public class Author extends Object{
    private String name;
    public Author(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public Author(){

    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
