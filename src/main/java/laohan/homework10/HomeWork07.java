package laohan.homework10;

/**
 * @author wb
 * @date 2025/10/15 14:50
 */
public class HomeWork07 {
    public static void main(String[] args) {
        Car car1 = new Car(60);
        car1.getAir().flow();
        Car car2 = new Car(20);
        car2.getAir().flow();
        Car car3 = new Car(-10);
        car3.getAir().flow();




    }
}

class Car{
    private double temperature;
     class Air{
        public Air() {}
        public void flow(){
            if (temperature<0){
                System.out.println("吹热风~~~");
            } else if (temperature>=0&&temperature<40) {
                System.out.println("吹常温风~~~");
            }else {
                System.out.println("吹冷风~~~");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }
}

