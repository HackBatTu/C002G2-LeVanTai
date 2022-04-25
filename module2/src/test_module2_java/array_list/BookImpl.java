package test_module2_java.array_list;


import com.sun.javaws.IconUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class BookImpl {

    public void f1(ArrayList<Book> list){
        int count =0 ;
        for (Book o: list) {
            if(o.getPrice()>10000){
                count++;
            }
        }
        System.out.println("count: "+ count);
    }
    public  void f2(ArrayList<Book> list){
        int count = 0;
        for (Book o : list){
            if(o.getPrice()>10000 && o.getPrice()<20000){
                count++;
            }
        }
        System.out.println("count : "+ count);

    }
    public  void  f3(ArrayList<Book> list){
        System.out.println(list.get(2));
    }
    public  void  f4(ArrayList<Book> list){
        list.add(new Book("lol",5,50000,"truyện tiếu lâm"));
        System.out.println(list.get(4));
    }
    public void f5(ArrayList<Book> list){
        list.add(4,new Book("xxx",5,100000,"tiếu lâm"));
        for (Book o: list) {
            System.out.println(o);
        }
    }
    public void f6(ArrayList<Book> list){
        boolean check = true;
        Scanner sc = new Scanner(System.in);
       while (true){
           System.out.println(" nhập code cần edit: ");
           int code = Integer.parseInt(sc.nextLine());
           for (int i = 0; i < list.size(); i++) {
               if(list.get(i).getCode() == code){
                   check = true;
                   break;
               }
           }
           if(check) {
               for (int i = 0; i < list.size(); i++) {
                   if(list.get(i).getCode() == code) {
                       list.get(i).setName(sc.nextLine());
                       list.get(i).setCode(Integer.parseInt(sc.nextLine()));
                       list.get(i).setPrice(Double.parseDouble(sc.nextLine()));
                       list.get(i).setBrand(sc.nextLine());
                   }
               }
           }else {
               System.out.println("not found code");
           }
           for (Book o: list) {
               System.out.println(o);
           }

           }
       }
    public void f7(ArrayList<Book> list){
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(" nhập code cần xóa: ");
            int codes = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getCode() == codes){
                    check = true;
                    break;
                }
            }
            if(check) {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).getCode() == codes) {
                        list.remove(i);
                    }
                }
            }else {
                System.out.println("not found code");
            }
            for (Book o: list) {
                System.out.println(o);
            }

        }
    }
    public void f8(ArrayList<Book> list){
        int count = 0;
        for (Book o: list) {
            if(o.getBrand().contains("t")){// nếu mà tìm đầu vị trí .startsWith("k")
                count++;
            }
        }
        System.out.println("count truyện tranh : "+count);
    }
    public void f9(ArrayList<Book> list){
        for (Book o: list) {
            double newPrince = o.getPrice()*0.9;
            o.setPrice(newPrince);
            System.out.println(o);
        }
    }
    public void f10(ArrayList<Book> list){
        for (Book o: list) {
            if(o.getBrand().equals("tiếu lâm")) {
                double newPrince = o.getPrice() * 0.9;
                o.setPrice(newPrince);
                System.out.println(o);
            }
        }
    }
    public void f11(ArrayList<Book> list){
        System.out.println("-------------");
        Collections.sort(list);
        for (Book o: list) {
            System.out.println(o);
        }
    }



    public void f12(ArrayList<Book> list){
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
//                return o1.getCode() - o2.getCode(); //// kiểu int
//                return o1.getName().compareToIgnoreCase(o2.getName()); kiểu String
//          kiểu double phải so sánh if else
                if(o1.getPrice() > o2.getPrice()){
                    return 1;
                }else if(o1.getPrice() < o2.getPrice()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println("------");
        for (Book o: list) {
            System.out.println(o);
        }
    }

}


