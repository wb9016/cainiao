package laohan.test.map_;

import java.util.*;

/**
 * @author wb
 * @date 2026/5/21 14:24
 */
public class map01 {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
//        map.put("john", 100);
//        map.put("wb", 100);
//        System.out.println(map);
        Worker john = new Worker("001", "john", 10032);
        Worker wb = new Worker("002", "wb", 189000);
        Worker worker = new Worker("003", "john", 10055);

        Hashtable<Object, Object> hashtable = new Hashtable<>();


        map.put(john.getId(), john);
        map.put(wb.getId(), wb);
        map.put(worker.getId(), worker);
//        map.put("cs1", "cs1");
//        map.put("cs2", "cs2");
//        map.put("cs3", "cs3");
//        map.put(null, "cs4");
//        map.put("cs5", null);


//        System.out.println("-------------方法1----------------");
//        Set keySet = map.keySet();
//        //1.增强for循环
//        System.out.println("-------------增强for循环----------------");
//        for (Object key:keySet) {
//            System.out.println(key+"---"+map.get(key));
//        }
//        //2.迭代器
//        Iterator iterator1 = keySet.iterator();
//        System.out.println("-------------迭代器----------------");
//        while (iterator1.hasNext()){
//            Object next =  iterator1.next();
//            System.out.println(next+"---"+map.get(next));
//        }
//
//        System.out.println("-------------方法2----------------");
//        Collection values = map.values();
//        System.out.println("-------------增强for循环----------------");
//        for (Object value : values) {
//            System.out.println(value);
//        }
//        System.out.println("-------------迭代器----------------");
//        Iterator iterator2 = values.iterator();
//        while (iterator2.hasNext()){
//            Object next =  iterator2.next();
//            System.out.println(next);
//        }
//
//        System.out.println("-------------方法3----------------");
//        Set entries = map.entrySet();
//        System.out.println("-------------增强for循环----------------");
//        for (Object entry : entries) {
//            Map.Entry entry1 = (Map.Entry) entry;
//            System.out.println(entry1.getKey()+"---"+entry1.getValue());
//        }
//
//        System.out.println("-------------迭代器----------------");
//        Iterator iterator3 = entries.iterator();
//        while (iterator3.hasNext()){
//            Object next = iterator3.next();
//            Map.Entry entry = (Map.Entry) next;
//            System.out.println(entry.getKey()+"---"+entry.getValue());
//        }
        System.out.println("-------------使用keySet----------------");
        Set set = map.keySet();
        for (Object o : set) {
            Worker o1 = (Worker)map.get(o);
            if (o1.getWages()>18000){
                System.out.println(o1);
            }
        }
        System.out.println("-------------使用entrySet----------------");
        Set entries = map.entrySet();
        for (Object entry : entries) {
            Map.Entry entry1 = (Map.Entry) entry;
            Worker o1 = (Worker)entry1.getValue();
            if (o1.getWages()>18000){
                System.out.println(o1);
            }
        }
        System.out.println("-------------使用values----------------");
        Collection values = map.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()){
            Worker next = (Worker)iterator.next();
            if (next.getWages()>18000){
                System.out.println(next);
            }
        }

    }
}

class Worker{
    private String id;
    private String name;
    private Integer wages;

    public Worker(String id, String name, Integer wages) {
        this.id = id;
        this.name = name;
        this.wages = wages;
    }

    public Worker(String name, Integer wages) {
        this.name = name;
        this.wages = wages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) {
        this.wages = wages;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", wages=" + wages +
                '}';
    }
}

