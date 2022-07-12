package test;

/**
 * @ClassName : Dog
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/12  16:04
 */

public class Dog {
    String name;
    int age;
    boolean sexual;

    public Dog() {
    }

    public Dog(String name, int age, boolean sexual) {
        this.name = name;
        this.age = age;
        this.sexual = sexual;
    }

    public void play(){
        System.out.println(name + "play");
    }

    public void play(int n){
        System.out.println(name + "play" + n + "minutes");
    }
}
class TestDog{
    public static void main(String[] args) {
        Dog dog = new Dog("joy", 2, false);

        dog.play();
        dog.play(30);
    }
}
