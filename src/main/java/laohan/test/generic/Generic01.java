package laohan.test.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author wb
 * @date 2026/6/8 16:46
 */
public class Generic01 {
    public static void main(String[] args) {
//        ArrayList<Dog> dogList1 = new ArrayList();
//        new Dog("旺财", "2",1).show();
//        new Dog("旺财", "2","test").show();

        HashSet<Student> students = new HashSet<>();
        students.add(new Student("小明", 20));
        students.add(new Student("小红", 22));
        students.add(new Student("wb",24));

        for (Student student : students) {
            System.out.println(student.toString());
        }

        HashMap<String, Student> studentMap = new HashMap<>();
        studentMap.put("001", new Student("小明", 20));
        studentMap.put("002", new Student("小红", 22));
        studentMap.put("003", new Student("wb",24));

        Set<Map.Entry<String, Student>> entries = studentMap.entrySet();
        Iterator<Map.Entry<String, Student>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Student> next = entryIterator.next();
            System.out.println(next.getKey() + "----" + next.getValue());
        }

        Set<String> keySet = studentMap.keySet();
        for (String key : keySet) {
            System.out.println(key + "----" + studentMap.get(key));
        }



    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Dog<E>{
    private  String name;
    private String age;
    private E test;
    public void show(){
        System.out.println(test.getClass());
    }
}

class Student{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
