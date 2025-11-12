package laohan.test.wrapper;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wb
 * @date 2025/11/7 16:03
 */
public class ArrayMethou01 {
    public static void main(String[] args) {
        Integer arr[]={1,2,3,4,5,7,83,32,23,54};
//        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer o11 = (Integer) o1;
                Integer o21 = (Integer) o2;
                return o21-o11;
            }
        });
        System.out.println(Arrays.toString(arr));


    }
}
