package test1;

/**
 * @author wb
 * @date 2026/6/11 11:15
 */
public class CpuNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);

    }
}
