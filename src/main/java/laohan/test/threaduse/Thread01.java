package laohan.test.threaduse;

/**
 * @author wb
 * @date 2026/6/11 11:18
 */
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
//        cat.start();
        Dog dog = new Dog();
        Thread thread1 = new Thread(dog);
        Thread thread2 = new Thread(dog);
        Thread thread3 = new Thread(dog);
        Thread thread4 = new Thread(dog);
        Thread thread5 = new Thread(dog);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        T t = new T();
//        t.start();
//        t.setPriority();
    }
}

class Cat extends Thread{

    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("线程"+this.getName()+"：法师刘海柱在此！输出次数："+(++times));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (times==6) break;
        }
    }
}

class Dog implements Runnable{
    private static int times=100;

    Object object=new Object();

    @Override
    public  void run() {
        jao();
    }

    public /*synchronized*/ void jao(){
//        synchronized (object) {
            while (true) {
                if (times <= 0) {
                    System.out.println("线程" + Thread.currentThread().getName() + "：狗子不在了！输出次数：" + times);
                    return;
                }
                System.out.println("狗" + Thread.currentThread().getName() + "：狗子在此！狗叫次数剩余" + (--times));
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//        }
    }
}

class T extends Thread{
    private int times=0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("T运行中,运行次数："+(++times));
        }
    }
}
