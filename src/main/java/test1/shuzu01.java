package test1;

/**
 * @author wb
 * @date 2025/6/23 22:20
 */
public class shuzu01 {
    public static void main(String[] args) {
        String str = "hello world!";
        String s = "Hello World!";
        Object o=str;

//        System.out.println(str.compareTo(s));
//        System.out.println(str.compareToIgnoreCase(s));
//        System.out.println(str.compareTo(o.toString()));
        StringBuilder stringBuilder = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(",");
            stringBuilder.append(i);
            String string = stringBuilder.toString();
            System.out.println(string);
        }
    }
}
