package test1;

/**
 * @author wb
 * @date 2025/6/23 22:20
 */
public class shuzu03 {
    public static void main(String[] args) {
        String str = "hello world! Hello wb";
        String s = "Hello World!";
        Object o=str;

        int lastIndex=s.lastIndexOf("wb");
        if (lastIndex==-1){
            System.out.println("无wb");
        }else {
            System.out.println("wb出现在："+lastIndex);
        }
    }
}
