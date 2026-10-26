package laohan.test.collection_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author wb
 * @date 2026/6/2 17:12
 */
public class List03 {
    public static void main(String[] args) {
        news new1 = new news("新闻一","内容一");
        news new2 = new news("新闻二扫大街","内容二");

        ArrayList<news> list = new ArrayList();
        list.add(new1);
        list.add(new2);
        for (int i= list.size()-1;i>=0;i--){
            System.out.println(processTitle(list.get(i).getTitle()));
        }



    }

    public static String processTitle(String title){
        if (title==null){
            return "";
        }
        if (title.length()>5){
            return title.substring(0, 5)+"...";
        }else {
            return title;
        }
    }
}


class news{
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "news{" +
                "title='" + title + '\'' +
                '}';
    }

    public news(String title, String content) {
        this.title = title;
        this.content = content;
    }


}