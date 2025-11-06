package laohan.test.wrapper;

/**
 * @author wb
 * @date 2025/11/5 16:11
 */
public class String01 {
    public static void main(String[] args) {
        String a1="wb";
        String a2=new String("wb");
        String a3 = new String("wb");
        a1.compareTo(a3);


        System.out.println(a1.equals(a2));
        System.out.println(a1==a2);
        System.out.println(a1==a2.intern());
        System.out.println(a2==a1.intern());
        System.out.println(a2==a3);

    }
}
