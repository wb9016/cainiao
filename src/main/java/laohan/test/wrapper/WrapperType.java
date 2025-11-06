package laohan.test.wrapper;

/**
 * @author wb
 * @date 2025/11/4 16:23
 */
public class WrapperType {
    /**
     * 包装类
     * bo
     */
    public static void main(String[] args) {
        int n1=19;

        Integer integer1=Integer.valueOf(n1);

        //三元运算符要看作一个整体，其中精度最高的为Double，所以输出1.0
        Object object1 = true ? Integer.valueOf(1) : Double.valueOf(2.0);
//        System.out.println(object1);

        Integer i = 1234;

        //转String类的方法
        String s1=i+"；";
        String string = i.toString();
        String string1 = String.valueOf(n1);

        //String类转包装类
        String s = "12345";
        Integer i1 = Integer.parseInt(s);
        Integer i2 = Integer.valueOf(s);


    }


}
