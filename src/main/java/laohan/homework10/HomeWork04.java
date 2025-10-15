package laohan.homework10;

/**
 * @author wb
 * @date 2025/10/14 17:09
 */
public class HomeWork04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculate() {
            @Override
            public double work(double n1, double n2) {
                return n1*n2;
            }
        },20,200);

    }
}

interface Calculate{
    public double work(double n1,double n2);
}

class Cellphone{
    public void testWork(Calculate calculate,double n1,double n2){
        double result= calculate.work(n1, n2);
        System.out.println("结果为："+result);
    }
}
