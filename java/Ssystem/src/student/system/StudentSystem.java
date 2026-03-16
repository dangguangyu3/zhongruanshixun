package student.system;

import java.util.ArrayList;
import java.util.Scanner;

/**
学生管理系统主界面的实现
 */
public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        //循环的名字叫Circulation
        Ciraulation:while (true) {
            System.out.println("-----------欢迎来到学生管理系统---------");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查询学生");
            System.out.println("5. 退出");
            System.out.println("请输入你的选择：");
            Scanner scanner = new Scanner(System.in);
            //用next()防止报错
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("添加学生");
                    addStudent(list);
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteStudent(list);
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent(list);
                    break;
                case "4":
                    System.out.println("查询学生");
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("退出");
                    break Ciraulation;
                default:
                    System.out.println("没有此选项");
            }
        }
    }
    public static void addStudent(ArrayList<Student> list){
        //创建Student对象
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生学号：");
            int id2 = scanner.nextInt();
            if (contains(list,id2)){
                System.out.println("学号已存在,重新输入");
            }
            else{
                student.setId(id2);
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name2 = scanner.next();
        student.setName(name2);
        System.out.println("请输入学生年龄：");
        int age2 = scanner.nextInt();
        student.setAge(age2);
        System.out.println("请输入学生性别：");
        String sex2 = scanner.next();
        student.setSex(sex2);
        System.out.println("请输入学生身高：");
        double height2 = scanner.nextDouble();
        student.setHeight(height2);
        //添加
        list.add(student);
        System.out.println("添加成功");
    }
    public static void deleteStudent(ArrayList<Student> list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的学号：");
        int id = scanner.nextInt();
        if (!contains(list,id)) {
            System.out.println("没有此学生，删除失败");
        }
        else {
        //查找学生在数组中的位置
        int index = -1;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        list.remove(index);
        System.out.println("删除成功");
         }
    }
    public static void updateStudent(ArrayList<Student> list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的学号：");
        int id1 = scanner.nextInt();
        //不存在
        if (!contains(list,id1)) {
            System.out.println("没有此学生，修改失败");
        }
        else {
            //查找学生在数组中的位置
            int index = -1;
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getId() == id1) {
                    index = i;
                    break;
                }
            }
            Student student = list.get(index);
            //输入其他信息并修改
            System.out.println("请输入学生姓名：");
            String name1 = scanner.next();
            student.setName(name1);
            System.out.println("请输入学生年龄：");
            int age1 = scanner.nextInt();
            student.setAge(age1);
            System.out.println("请输入学生性别：");
            String sex1 = scanner.next();
            student.setSex(sex1);
            System.out.println("请输入学生身高：");
            double height1 = scanner.nextDouble();
            student.setHeight(height1);
            System.out.println("修改成功");
        }
    }
    public static void queryStudent(ArrayList<Student> list){
        //如果没有学生
        if (list.size() == 0) {
            System.out.println("没有学生");
            return;
        }
        //有数据
        System.out.println("学号\t\t姓名\t\t年龄\t\t性别\t\t身高");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getAge() + "\t\t" + student.getName() + "\t\t" + student.getAge() + "\t\t" + student.getSex() + "\t\t" + student.getHeight());
        }
    }
    //判断学生是否存在
    //学号唯一
    public static boolean contains(ArrayList<Student> list,int id){
        //遍历
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
