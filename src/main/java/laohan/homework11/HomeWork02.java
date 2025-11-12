package laohan.homework11;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wb
 * @date 2025/11/10 16:10
 */
public class HomeWork02 {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0]=new Book("红楼梦1",199.7);
        books[1]=new Book("西游记",23.5);
        books[2]=new Book("水浒传",324.6);
        books[3]=new Book("精瓶梅第六",99);
        books[4]=new Book("大话西游之月光宝盒",99);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {

                return o1.getPrice()-o2.getPrice()>0?-1:1;
            }
        });

        System.out.println(Arrays.toString(books));

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {

                return o1.getPrice()-o2.getPrice()>0?1:-1;
            }
        });
        System.out.println(Arrays.toString(books));

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {

                return o1.getName().length()-o2.getName().length()>0?1:-1;
            }
        });
        System.out.println(Arrays.toString(books));
        System.out.println("----------------------------------");

        BigInteger bigInteger = new BigInteger("99898989898989898998");



    }
}


class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}