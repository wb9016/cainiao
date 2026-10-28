package laohan.list_;

import java.util.ArrayList;

public class ArrayListSource {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 10; i <15 ; i++) {
            list.add(i);
        }
        list.add(199);
        list.add(200);
        list.add(null);
    }
}
