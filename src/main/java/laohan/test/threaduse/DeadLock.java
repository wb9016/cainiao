package laohan.test.threaduse;

/**
 * @author wb
 * @date 2026/7/27 16:29
 */
public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo thread1 = new DeadLockDemo(true);
        thread1.setName("线程1");
        DeadLockDemo thread2 = new DeadLockDemo(false);
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }
}

class DeadLockDemo extends Thread{
    static Object o1=new Object();
    static Object o2=new Object();
    boolean flag;

    public DeadLockDemo(boolean flag){
        this.flag=flag;
    }

    public void run(){
        if (flag){
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+"进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"进入2");
                }
            }
        }else {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"进入3");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"进入4");
                }
            }
        }
    }
}
