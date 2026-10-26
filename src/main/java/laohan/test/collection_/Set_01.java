package laohan.test.collection_;

import java.time.DayOfWeek;
import java.util.*;

/**
 * @author wb
 * @date 2026/5/12 15:09
 */
public class Set_01 {
    public static void main(String[] args) {

//        Set set = new HashSet();
//        System.out.println(set.add("john"));
//        System.out.println(set.add("wb"));
//        System.out.println(set.add("john"));
//        System.out.println(set.add("jack"));
//
//        set.add(new String("john"));
//        set.add(new String("john"));
//
//        set.remove("john");
//        System.out.println("set:"+set);

//        HashSet hashSet = new HashSet();
//        hashSet.add(new Employee("john", 18));
//        hashSet.add(new Employee("wb", 18));
//        hashSet.add(new Employee("jack", 18));
//        System.out.println("hashSet:"+hashSet);

    }

}
class Employee implements Comparable<Employee>{
    private String name;
    private Integer age;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, Integer age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}

class MyDate{
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(year, myDate.year) && Objects.equals(month, myDate.month) && Objects.equals(day, myDate.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}


class Pair<T>{
    private T first;
    private  T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }


}
