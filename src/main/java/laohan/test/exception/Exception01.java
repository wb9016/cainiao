package laohan.test.exception;

/**
 * @author wb
 * @date 2025/10/20 17:08
 */
public class Exception01 {
    public static void main(String[] args) {
        int a = 10, b = 0;

        try {
            int res = a / b;
        } catch (Exception e) {
            System.out.println("报错"+e.getMessage());
        }

        System.out.println("拦不住我~~~");
    }


}
