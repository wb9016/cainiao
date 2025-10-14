package laohan.interfacepage;

/**
 * @author wb
 * @date 2025/9/28 15:00
 */
public class Impinterface01 implements interface01{
    @Override
    public void start() {
        System.out.println("hello!");
    }

    @Override
    public void stop() {
        System.out.println("bye");
    }
}
