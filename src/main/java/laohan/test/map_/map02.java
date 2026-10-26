package laohan.test.map_;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author wb
 * @date 2026/6/2 16:24
 */
public class map02 {
    public static void main(String[] args) {
        TreeMap<Object, Object> treeMap = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (((String)o2).length())-((String)o1).length();
            }
        });
        treeMap.put("wb","123");
        treeMap.put("john","123");
        treeMap.put("jack","123");
        treeMap.put("rose","123");

        System.out.println("treemap="+treeMap);

    }
}
