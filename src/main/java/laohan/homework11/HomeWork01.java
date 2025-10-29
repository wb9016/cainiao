package laohan.homework11;

import java.util.Scanner;

/**
 * @author wb
 * @date 2025/10/29 15:55
 */
public class HomeWork01 {
    public static void main(String[] args) {
        int n1,n2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入两个整数：");
        while (true) {

                while (true) {
                    try {
                        System.out.print("输入除数：");
                        String n1str=scanner.next();
                        n1=Integer.parseInt(n1str);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("输入整数");;
                    }
                }
                while (true) {
                    try {
                        System.out.print("输入被除数：");
                        String n2str=scanner.next();
                        n2=Integer.parseInt(n2str);
                        if (n2==0){
                            throw new ArithmeticException("被除数不能为0！");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("输入整数");;
                    }catch (ArithmeticException e){
                        System.out.println(e.getMessage());
                    }
                }

                double res=cal(n1,n2);
                System.out.println(res);
                break;

            }
        }



    public static double cal(int n1,int n2){
        return n1/n2;
    }
}
