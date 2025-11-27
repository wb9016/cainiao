package laohan.homework11;

/**
 * @author wb
 * @date 2025/11/20 14:50
 */
public class HomeWork495 {
    public static void main(String[] args) {
        String s = "Wang Yi Bo";
        printType(s);
    }

    /**
     * 输出格式自服务编写
     */
    private static void printType(String str){
        if (str==null){
            System.out.println("输入不能为空");
            return;
        }
        String[] s = str.split(" ");
        if (s.length!=3){
            System.out.println("输入字符串格式错误，要求:*** *** ***");
        }
        String format = String.format("%s,%s .%c", s[2], s[0], s[1].toUpperCase().charAt(0));
        System.out.println(format);
    }

    static int hassNum(String str){
        char[] chars = str.toCharArray();
        int Num=0;
        for (char c : chars) {
            if (c>'a'&&c<'z'){
                Num++;
            }
        }
        return Num;
    }

}
