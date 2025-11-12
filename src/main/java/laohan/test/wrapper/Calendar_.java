package laohan.test.wrapper;

import java.util.Calendar;

/**
 * @author wb
 * @date 2025/11/11 17:10
 */
public class Calendar_ {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        System.out.println(c);

        System.out.println("年："+c.get(Calendar.YEAR));
        System.out.println("月："+(c.get(Calendar.MONTH)+1));
        System.out.println("日："+c.get(Calendar.DAY_OF_MONTH));
        System.out.println("时："+c.get(Calendar.HOUR));
        System.out.println("分："+c.get(Calendar.MINUTE));
        System.out.println("秒："+c.get(Calendar.SECOND));

        System.out.println(c.get(Calendar.YEAR)+"年"+((c.get(Calendar.MONTH))+1)+"月"+c.get(Calendar.DAY_OF_MONTH)+"日"+c.get(Calendar.HOUR)+"时"+c.get(Calendar.MINUTE)+"分"+c.get(Calendar.SECOND)+"秒");
    }
}
