package test;

/**
 * @ClassName : Worker
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/12  16:17
 */

public class Worker {
    String name;
    int age;
    double salary;
    Address address;

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Worker() {
    }

    public Worker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void work() {
        Worker worker = new Worker("aa", 18, 1.1);
        System.out.println(worker);
    }

    public void work(int hours){
        Worker worker = new Worker("aa", 18, 1.1);
        System.out.println(worker);
        System.out.println(hours);
    }
}
