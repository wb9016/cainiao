package laohan.test.collection_;

import java.util.*;

/**
 * @author wb
 * @date 2026/2/25 11:45
 */
public class List_test01 {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 25;

        LinkedList<Object> list1 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        Collections.shuffle(list); // 打乱顺序
        System.out.println(list.toString());
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");

        Map<String, Integer> scores = new HashMap<>();

        // 存储多个键值对
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);
        scores.put("David", 85); // 又添加了一个

        System.out.println(scores);
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        for (int i=start;i<=end;i++){
            if (!list.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
