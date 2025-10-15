package laohan.homework10;

/**
 * @author wb
 * @date 2025/10/14 17:18
 */
public class HomeWork05 {
    public static void main(String[] args) {
        new A().f1();

    }
}

class A{
    private String name="Aname";


    public void f1(){
        class B{
            private final String name="Bname";

            public void show(){
                System.out.println("局部内部类属性："+name+"\n"+"外部属性："+A.this.name);
            }
        }

        new B().show();

    }
}
