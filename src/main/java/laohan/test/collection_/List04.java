package laohan.test.collection_;

import java.util.ArrayList;

/**
 * @author wb
 * @date 2026/6/2 17:36
 */
public class List04 {
    public static void main(String[] args) {
        Car2 car1 = new Car2("宝马", "100万");
        Car2 car2 = new Car2("奔驰", "80万");
        Car2 car3 = new Car2("奥迪", "50万");
        Car2 car4 = new Car2("大众", "150万");
        ArrayList cars = new ArrayList();
        cars.add(car1);
        cars.add(car2);
        System.out.println(cars.contains(car1));
        System.out.println(cars.size());
        System.out.println(cars.isEmpty());


        cars.remove(1);
        System.out.println(cars);
        cars.clear();
        System.out.println(cars);

        ArrayList<Object> cars2 = new ArrayList<>();
        cars2.add(car3);
        cars2.add(car4);
        cars.addAll(cars2);
         System.out.println(cars);

         cars.removeAll(cars2);
        System.out.println(cars);



    }
}

class Car2{
    private String name;
    private String price;

    public Car2(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
