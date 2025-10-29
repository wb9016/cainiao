package laohan.test.exception;

/**
 * @author wb
 * @date 2025/10/29 14:55
 */
public class TryCatchTest04 {
    public static void main(String[] args) {
        int age =16;
        if (!(age<20||age>120)){
            throw new AgeException("年龄范围错误");
        }
        System.out.println("年龄符合条件！");

    }
}

class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}
