package laohan.test.wrapper;

import java.util.Scanner;

/**
 * @author wb
 * @date 2025/11/6 9:40
 */
public class StringBuffer01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String price = "1234566.4353";
        StringBuffer buffer = new StringBuffer(price);
        for (int i = buffer.lastIndexOf(".")-3;i>0;i-=3) {
            buffer = buffer.insert(i, ",");
        }
        System.out.println(buffer);

        StringBuilder stringBuilder = new StringBuilder("");
        StringBuffer stringBuffer = new StringBuffer("");
        String  string="";

        long startTime=0L;
        long endTime=0L;
        startTime=System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {
            stringBuffer.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println("StringBuffer执行时间："+(endTime-startTime));

        startTime=System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println("StringBuilder执行时间："+(endTime-startTime));

        startTime=System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {
            string+=i;
        }
        endTime=System.currentTimeMillis();
        System.out.println("String执行时间："+(endTime-startTime));



    }
}
