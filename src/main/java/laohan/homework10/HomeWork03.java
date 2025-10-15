package laohan.homework10;

/**
 * @author wb
 * @date 2025/10/14 17:02
 */


public class HomeWork03 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.shout();
        Animal dog = new Dog();
        dog.shout();
    }
}
abstract class Animal {
    abstract void shout();
}

class Cat extends Animal{
    @Override
    void shout() {
        System.out.println("喵喵哇哇叫！");
    }
}

class Dog extends Animal{
    @Override
    void shout() {
        System.out.println("不要给我哇哇叫！");
    }
}
