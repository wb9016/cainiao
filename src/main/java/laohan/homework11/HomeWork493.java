package laohan.homework11;

/**
 * @author wb
 * @date 2025/11/18 16:46
 */
public class HomeWork493 {
    public static void main(String[] args) {
        String s = "abcdefghijklm";
        String s1= null;
        try {
            s1 = reverse(s,-1,6);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());;
            return;
        }
        System.out.println(s1);

    }


    public static String reverse(String str,int start,int end){
        //参数校验
        //《要找全错的情况很难，但是找到正确的情况稍简单，所有列出正确的情况，然后取反》
        if (!(str!=null&&start>=0&&start<end&&end<=str.length())){
            throw new RuntimeException("输入参数错误");
        }

        char[] chars=str.toCharArray();
        while (start<end){
            char temporaryChar=chars[start-1];
            chars[start-1]=chars[end-1];
            chars[end-1]=temporaryChar;
            start++;
            end--;
        }
        System.out.println(new String(chars));
        return new String(chars);
    }
}
