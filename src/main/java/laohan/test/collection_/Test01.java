package laohan.test.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wb
 * @date 2025/12/10 16:11
 */
public class Test01 {
//    Collection

//    Map

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
//        arrayList.add("wb");
//        arrayList.add(123456);
//        arrayList.add(23.23);
//        arrayList.add(true);

        arrayList.add(new Person("wb",12));
        arrayList.add(new Person("wyt",10));
        arrayList.add(new Person("wlm",15));

//        System.out.println("arrayList:  "+arrayList);

        Iterator iterator = arrayList.iterator();
        System.out.println(iterator.hasNext());
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println("obj= "+obj);
        }


        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size() - 1 - i; j++) {
                Person person1 = (Person) arrayList.get(j);
                Person person2 = (Person) arrayList.get(j + 1);
                if (person1.getAge()>person2.getAge()){
                    arrayList.set(j,person2);
                    arrayList.set(j+1,person1);
                }
            }
        }
//        System.out.println("二迭--------------------");
//        for (Object o : arrayList) {
//            System.out.println("Obj="+o);
//        }


        int[] ints= {234,345,346,239849182};
        Solution solution = new Solution();
        System.out.println(solution.sumOfEncryptedInt(ints));


    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int summation=0;
        for(int num : nums){
            int max_int=0;
            int remainder=num;
            int times=0;
            while(remainder>0){
                int consult=remainder%10;
                if(max_int<consult){
                    max_int=consult;
                }
                times=times*10+1;
                remainder=remainder/10;
            }
            num=max_int*times;
            summation=summation+num;
        }
        return summation;
    }

}
