package laohan.test.generic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wb
 * @date 2026/6/9 17:54
 */
public class Generic03 {
    public static void main(String[] args) {
        DAO<User> userMap = new DAO<>();
        userMap.save("001", new User(1, 20, "小明"));
        userMap.save("002", new User(2, 22, "小红"));
        userMap.save("003", new User(3, 24, "wb"));
        System.out.println(userMap);

        System.out.println(userMap.get("002"));

        userMap.update("002", new User(2, 23, "小红"));

        System.out.println(userMap);

        userMap.delete("002");
        System.out.println(userMap);
    }
    @Test
    public void testJunit(){
        System.out.println("testJunit方法被调用");
    }
}

class DAO<T>{
    Map<String,T> map=new HashMap<>();

    public void save(String id ,T entity){
        this.map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        if (map.containsKey(id)){
            map.put(id,entity);
        }else {
            System.out.println("id不存在，无法修改");
        }
    }

    public List<T> list(){
        return map.values().stream().toList();
    }

    public void delete(String id){
        if (map.containsKey(id)) {
        map.remove(id);
        }else {
            System.out.println("id不存在，无法删除");
        }
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}

class User{
    private int id;
    private int age;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}
