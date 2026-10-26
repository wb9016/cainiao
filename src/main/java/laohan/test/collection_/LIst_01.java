package laohan.test.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wb
 * @date 2025/12/16 17:07
 */
public class LIst_01 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        list1.add("hello");
        list1.add("world");
        list1.add("java");

        LinkedList<Object> linkedList = new LinkedList<>();

        linkedList.add("hello");
        System.out.println(linkedList);
        System.out.println("--------------------");
        for (Object o : list1) {
            System.out.println("list="+o);
        }

        list1.add(1,"javaee");
        System.out.println("--------------------");
        for (Object o :list1) {
            System.out.println("list="+o);
        }

        Iterator<String > iterator = list1.iterator();
        System.out.println("Iterator遍历结果：");
        while(iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }

        list1.remove("hello");
        System.out.println("--------------------");
        for (Object o :list1) {
            System.out.println("list="+o);
        }



    }
}
class Solution01 {
    public int[][] largestLocal(int[][] grid) {
        int side=grid.length;
        int[][] result= new int[side-2][side-2];
        for(int y=1;y<side-1;y++){
            for(int x=1;x<side-1;x++){
                result[y-1][x-1]=Math.max(Math.max(grid[y-1][x-1],Math.max(grid[y-1][x],grid[y-1][x+1])),Math.max(Math.max(grid[y][x-1],Math.max(grid[y][x],grid[y][x+1])),Math.max(grid[y+1][x-1],Math.max(grid[y+1][x],grid[y+1][x+1]))));
            }
        }
        return result;
    }
}
