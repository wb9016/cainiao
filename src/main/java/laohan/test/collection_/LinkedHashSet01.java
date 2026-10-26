package laohan.test.collection_;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author wb
 * @date 2026/5/21 11:03
 */
public class LinkedHashSet01 {
    public static void main(String[] args) {
//        LinkedHashSet linkedHashSet = new LinkedHashSet();
//        linkedHashSet.add(new String("Wb"));
//        linkedHashSet.add(456);
//        linkedHashSet.add(456);
//        linkedHashSet.add(new Customer("john", 1));
//        linkedHashSet.add(123);
//        linkedHashSet.add("jack");
//
//        System.out.println(linkedHashSet);

        LinkedHashSet hashSet = new LinkedHashSet();
//        hashSet.add(new Car("宝马", "100万"));
//        hashSet.add(new Car("宝马", "100万"));
//        hashSet.add(new Car("奔驰", "80万"));
//        hashSet.add(new Car("奥迪", "50万"));
//        hashSet.add(new Car("奥迪", "50万"));
//        System.out.println(hashSet);

        Car car1 = new Car("宝马", "100万");
        Car car2 = new Car("奔驰", "50万");
        hashSet.add(car1);
        hashSet.add(car2);
        System.out.println(hashSet);

        car1.setPrice("80万");
        System.out.println(hashSet);

        hashSet.remove(car1);
        System.out.println(hashSet);

        hashSet.add(new Car("宝马", "100万"));
        System.out.println(hashSet);
    }
}

class Customer{
    private String name;
    private Integer no;

    public Customer(String name, Integer no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}

class Car{
    private String name;
    private String price;

    public Car(String name, String price) {
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
        return "Car{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
