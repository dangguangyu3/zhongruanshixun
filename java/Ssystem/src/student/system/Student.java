package student.system;

public class Student {
    //学号
    // 姓名
    //年龄
    //性别
    //身高

    private int id;
    private String name;
    private int age;
    private String sex;
    private double height;
    //有参构造方法
    public Student(int id,String name,int age,String sex,double height){
        this.id = id;//不超6位
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //无参
    public Student(){

    }

}
