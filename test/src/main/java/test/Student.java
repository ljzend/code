package test;

/**
 * @ClassName : Student
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/12  16:14
 */

public class Student {

    public void Student(){
    }
    void init(){
        age = 10;
        name = "aa";
    }
    int age ;
    String name;

    public Student(String name) {
        this.init();
        this.name = name;
    }

    public Student(int age, String name) {
        this(name);
        this.init();
        this.age = age;
    }
}
