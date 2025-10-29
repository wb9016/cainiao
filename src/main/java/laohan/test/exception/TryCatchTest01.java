package laohan.test.exception;

import java.lang.reflect.Type;

/**
 * @author wb
 * @date 2025/10/29 14:55
 */
public class TryCatchTest01 {
    public static void main(String[] args) {
        String i = "12a";
        try {
            int iI = Integer.parseInt(i);
            System.out.println("数字：" + iI);
        }catch (NumberFormatException e){
            System.out.println("发生异常："+e.getMessage());
        }finally {
            System.out.println("必须王城！！");
        }
    }
}
