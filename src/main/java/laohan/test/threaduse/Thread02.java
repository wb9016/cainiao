package laohan.test.threaduse;

/**
 * @author wb
 * @date 2026/6/12 10:11
 */
public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
//        t2.start();

        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("主线程"+Thread.currentThread().getName()+"输出：Hi!!"+i);
            if (i==5){
                System.out.println("子线程"+t2.getName()+"先吃");
                t2.start();
                t2.join();
//                t2.join();

                Thread.yield();
                System.out.println("主线程"+Thread.currentThread().getName()+"继续输出");
            }
        }

    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i=0;i<=10;i++){
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
            System.out.println("子线程"+this.getName()+"输出：Hello！"+i);
        }
    }
}
