package laohan.homework10;

/**
 * @author wb
 * @date 2025/10/15 15:13
 */
public class HomeWork08 {
    public static void main(String[] args) {
        Color green = Color.BlUE;
        green.show();

        switch (green){
            case BlUE :
                System.out.println("匹配到蓝色");
                break;
            case RED:
                System.out.println("匹配到红色");
                break;
            default:
                System.out.println("没有匹配项");
                break;

        }

    }
}


interface IInterface{
    public void show();
}

enum Color implements IInterface{
    RED(255,0,0),BlUE(0,0,255),GREEN(0,255,0),BLACK(0,0,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show(){
        System.out.println("属性值:"+redValue+","+greenValue+","+blueValue);
    }
}