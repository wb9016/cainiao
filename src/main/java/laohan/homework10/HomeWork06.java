package laohan.homework10;

/**
 * @author wb
 * @date 2025/10/15 14:17
 */
public class HomeWork06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse());
        person.common();
        person.passRiver();
        person.flamingMountains();


    }
}



interface Vehicles{
    public void work();

}
class Horse implements Vehicles{


    @Override
    public void work() {
        System.out.println("骑马前进！！");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("开船前进！！");
    }
}

class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("打飞机了~~~");
    }
}

class VehicleFactory{
    public static Horse horse= new Horse();
    public static Boat boat=new Boat();
    public static Plane plane=new Plane();

    public VehicleFactory() {
    }

    public static Horse getHorse(){
        return horse;
    }

    public static Boat getBoat(){
        return boat;
    }

    public static Plane getPlane(){
        return plane;
    }
}

class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public  void passRiver(){
        if (!(vehicles instanceof Boat)) {
            vehicles = VehicleFactory.getBoat();
        }
        vehicles.work();
    }

    public void common(){
        if (!(vehicles instanceof Horse)) {
            vehicles = VehicleFactory.getHorse();
        }
        vehicles.work();
    }
    public void flamingMountains(){
        if (!(vehicles instanceof Plane)) {
            vehicles = VehicleFactory.getPlane();
        }
        vehicles.work();
    }
}
