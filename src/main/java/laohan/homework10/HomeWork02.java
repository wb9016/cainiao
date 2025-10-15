package laohan.homework10;

/**
 * @author wb
 * @date 2025/10/14 16:48
 */
public class HomeWork02 {
    public static void main(String[] args) {

        System.out.println(Frock.getNextNum());

        System.out.println(Frock.getNextNum());


        Frock frock1 = new Frock();
        System.out.println(frock1.getSerialNumber());
        Frock frock2 = new Frock();
        System.out.println(frock2.getSerialNumber());
        Frock frock3 = new Frock();
        System.out.println(frock3.getSerialNumber());

    }
}

class Frock{
    private static int currentNum=100000;
    private  int serialNumber;


    public static int getNextNum(){
        currentNum+=100;

        return currentNum;
    }

    public  int getSerialNumber() {
        return serialNumber;
    }

    public Frock() {
        serialNumber=getNextNum();
    }
}
