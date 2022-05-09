package test_module2_java.array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookImpl book = new BookImpl();
        List<Book> listArr = new ArrayList<>();

        listArr.add(new Book("con cò", 4, 20000.0, "dân gian"));
        listArr.add(new Book("doremon", 1, 20000.0, "truyện tranh"));
        listArr.add(new Book("mắt biếc", 3, 15000.0, "truyện ngắn"));
        listArr.add(new Book("lão hạc", 2, 5000.0, "văn học"));
        for (Book o : listArr) {
            System.out.println(o);
        }

        book.f1((ArrayList<Book>) listArr);
        book.f2((ArrayList<Book>) listArr);
        book.f3((ArrayList<Book>) listArr);
        book.f4((ArrayList<Book>) listArr);
        System.out.println("------");
        book.f5((ArrayList<Book>) listArr);
        System.out.println("----");
//        book.f6((ArrayList<Book>) listArr);
//        System.out.println("-----");
//        book.f7((ArrayList<Book>) listArr);
        book.f8((ArrayList<Book>) listArr);
        book.f9((ArrayList<Book>) listArr);
        book.f10((ArrayList<Book>) listArr);
        book.f11((ArrayList<Book>) listArr);
        book.f12();
    }
}
