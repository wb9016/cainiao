package laohan.test.exception;

/**
 * @author wb
 * @date 2025/10/29 15:09
 */
public class TryCatchTest02 {
    public static void main(String[] args) {
        System.out.println(method());

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
