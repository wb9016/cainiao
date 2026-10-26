package laohan.test.collection_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wb
 * @date 2026/6/2 16:47
 */
public class List02 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        list1.add("hello");
        list1.add("world");
        list1.add("java");

        System.out.println("list1="+list1);

        Collections.reverse(list1);
        System.out.println("reverse list1="+list1);

         Collections.shuffle(list1);
        System.out.println("shuffle list1="+list1);

         Collections.sort(list1);
        System.out.println("sort list1="+list1);

        Collections.swap(list1,0,1);
        System.out.println("swap list1="+list1);
    }
}
