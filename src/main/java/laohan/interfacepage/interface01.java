package laohan.interfacepage;

/**
 * @author wb
 * @date 2025/9/28 14:57
 */
public interface interface01 {

    int n1=10;
    void start();

    void stop();

    public default void ok(){
        System.out.println("ok....");
    }
}
