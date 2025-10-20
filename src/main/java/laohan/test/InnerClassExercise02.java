package laohan.test;

/**
 * @author wb
 * @date 2025/10/17 13:56
 */
public class InnerClassExercise02 {
    public static void main(String[] args) {
        new Cellphone().alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("该起床了，嘚嘚！！");
            }
        });

        new Cellphone().alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("该上课了！！！");
            }
        });

    }
}

interface Bell{
    public void ring();
}

class Cellphone{
    public void alarmclock(Bell bell){
        bell.ring();

    }
}
