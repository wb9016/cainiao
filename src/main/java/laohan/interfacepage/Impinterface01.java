package laohan.interfacepage;

/**
 * @author wb
 * @date 2025/9/28 15:00
 */
public class Impinterface01 implements interface01{
    public static void main(String[] args) {
        f1(new Ni(){
            @Override
            public void show() {
                System.out.println("匿名内部类实现");
            }
        });

    }

    @Override
    public void start() {
        System.out.println("hello!");
    }

    @Override
    public void stop() {
        System.out.println("bye");
    }



    public static void f1(Ni ni){
        ni.show();
    }
}

interface Ni{
    public void show();
}


