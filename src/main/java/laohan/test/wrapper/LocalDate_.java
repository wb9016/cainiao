package laohan.test.wrapper;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author wb
 * @date 2025/11/12 16:57
 */
public class LocalDate_ {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        System.out.println(date);
        System.out.println(format.format(date));

        System.out.println(now);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分种ss秒 E");
        String now1 = dateTimeFormatter.format(now);
        System.out.println("格式化第三代日期："+now1);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());

        System.out.println("-------------------------------");

        System.out.println(Instant.now());
        Date date1 = Date.from(Instant.now());
        System.out.println("Instant转为Date："+date1);
        System.out.println(date1.toInstant());

        System.out.println("第三代日期运算：");
        LocalDateTime now2 = LocalDateTime.now();
        LocalDateTime now2Plus = now2.plusDays(890);
        System.out.println("890天后是："+now2Plus);

        LocalDateTime now2Minus = now2.minusMinutes(5000);
        System.out.println("5000分钟前是："+dateTimeFormatter.format(now2Minus));

    }
}
