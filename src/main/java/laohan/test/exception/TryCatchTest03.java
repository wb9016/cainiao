package laohan.test.exception;

import java.util.Scanner;

/**
 * @author wb
 * @date 2025/10/29 15:09
 */
public class TryCatchTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个整数：");
        int num =0;
        while (true){
            try {
                num=Integer.parseInt(scanner.next());

                System.out.println("谢谢配合！");
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的不是一个整数！！重新输入");
            }
        }
        System.out.println("num="+num);


    }

    public static int method(){
        int i=1;
        try {
            i++;
            String[] names=new String[3];
            if (names[0].equals("tom")){
                System.out.println(names[0]);
            }else {
                names[2]="wb";
            }
            return 1;
        }catch (ArrayIndexOutOfBoundsException e){
            return 2;
        }catch (NullPointerException e){
            return ++i;
        }catch (Exception e){
            return ++i;
        }finally {
            ++i;
            System.out.println(i);
        }
    }

}
