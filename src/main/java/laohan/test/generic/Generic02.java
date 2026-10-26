package laohan.test.generic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author wb
 * @date 2026/6/9 10:56
 */
public class Generic02 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("wb", 100000, new MyDate(1990, 1, 1)));

        list.add(new Employee("小红", 60000, new MyDate(1992, 3, 3)));
        list.add(new Employee("小明", 50000, new MyDate(1995, 5, 5)));
        System.out.println(list);
        System.out.println("-------------------");
        System.out.println(list.get(1));
        System.out.println("-------------------");
        Employee test = new Employee("test", 1000, new MyDate(2000, 1, 1));
        test.fly("test", 100);

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().compareTo(o2.getName())!=0)
                    return o1.getName().compareTo(o2.getName());
                else if (o1.getBirthday().compareTo(o2.getBirthday())!=0)
                    return o1.getBirthday().compareTo(o2.getBirthday());
                return 0;
            }
        });
        System.out.println(list);

    }
}

class Employee {
    private String name;
    private Integer sal;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public Employee(String name, Integer sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public <T,R> void fly(T t,R r){
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}

class MyDate implements Comparable<MyDate>{
    private Integer year;
    private Integer month;
    private Integer day;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        if (this.getYear().compareTo(o.getYear()) != 0)
            return this.getYear().compareTo(o.getYear());
        else if (this.getMonth().compareTo(o.getMonth()) != 0)
            return this.getMonth().compareTo(o.getMonth());
         else if (this.getDay().compareTo(o.getDay()) != 0)
            return this.getDay().compareTo(o.getDay());

        return 0;
    }
}


interface IUsb<U,R>{
    int n=10;
//    U name="usb";

    U get(U u);





}