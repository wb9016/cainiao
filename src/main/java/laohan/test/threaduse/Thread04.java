package laohan.test.threaduse;

/**
 * @author wb
 * @date 2026/7/30 16:09
 */
public class Thread04 {
    public static void main(String[] args) {
        Black black = new Black();
        Thread thread1 = new Thread(black, "线程1");
        Thread thread2 = new Thread(black, "线程2");
        thread1.start();
        thread2.start();

    }
}

class Black implements Runnable{
    private int money=10000;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (money<1000){
                    System.out.println("余额不足，无法取款");
                    break;
                }

                money -=1000;
                System.out.println(Thread.currentThread().getName()+"取款1000元，余额："+money);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
