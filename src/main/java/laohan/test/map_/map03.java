package laohan.test.map_;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wb
 * @date 2026/6/2 17:55
 */
public class map03 {
    public static void main(String[] args) {
        HashMap<String ,Integer> map = new HashMap<>();
        map.put("java",100);
        map.put("python",90);
        map.put("c++",80);

        //1
        map.replace("java",200);
        System.out.println(map);

        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            Integer oldVal=map.get(s);
            map.put(s,oldVal+10);
        }

        System.out.println(map);


    }
}


