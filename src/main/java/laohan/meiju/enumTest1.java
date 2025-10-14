package laohan.meiju;

/**
 * @author wb
 * @date 2025/10/14 15:43
 */
public class enumTest1 {
    public static void main(String[] args) {
        //获取所有对象
        Week[] weeks = Week.values();

        System.out.println("所有信息如下：");
        for (Week week : weeks) {
            System.out.println(week);
        }

    }


}

enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期七"),;
    private String name;

    Week(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
