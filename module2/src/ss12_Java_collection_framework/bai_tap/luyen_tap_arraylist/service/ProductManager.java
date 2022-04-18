package ss12_Java_collection_framework.bai_tap.luyen_tap_arraylist.service;

import ss12_Java_collection_framework.bai_tap.luyen_tap_arraylist.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements IProduct {
    List<Product> products = new ArrayList<>();
    {
    Product product1 = new Product(01,"Phương",10000);
    Product product2 = new Product(03,"Hoàn",20000);
    Product product3 = new Product(02,"Luận",50000);
    Product product4 = new Product(04,"Hậu",30000);
    products.add(product1);
    products.add(product2);
    products.add(product3);
    products.add(product4);
}


    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("enter the name");
        String name = sc.nextLine();
        System.out.println("enter the Money");
        int money = Integer.parseInt(sc.nextLine());
        Product product = new Product(id,name,money);
        products.add(product);
    }

    @Override
    public void display() {
        System.out.println("List Product: ");
        for (Product x : products) {
            System.out.println(x);
        }

    }

    @Override
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id you want delete: ");
        int id = Integer.parseInt(sc.nextLine());
        for(int i = 0 ; i< products.size();i++){
            if(id == products.get(i).getId()){
                products.remove(i);
            }
        }
    }

    @Override
    public void findname() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name you want find: ");
        boolean flag = true;
        String name = sc.nextLine();
        for(int i = 0 ; i< products.size();i++){
           if(products.get(i).getName().contains(name)){
               flag = true;
               break;
           }
        }
        if(flag){
            for(int i = 0 ; i< products.size();i++){
                if(products.get(i).getName().contains(name)){
                    System.out.println(products.get(i));
                    break;
                }
            }
        }else {
            System.out.println("không tìm thấy");
        }
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id you want edit : ");
        int id = Integer.parseInt(sc.nextLine());

        for(int i = 0;i<products.size();i++){
            if( id == products.get(i).getId()){
                System.out.println("Enter the new id : ");
                int newId = Integer.parseInt(sc.nextLine());
                products.get(i).setId(newId);
                System.out.println("Enter the new name : ");
                String newName = sc.nextLine();
                products.get(i).setName(newName);
                System.out.println("Enter the new money : ");
                int money = Integer.parseInt(sc.nextLine());
                products.get(i).setMoney(money);
                break;
            }
            else {
                System.out.println("id not found: ");
            }
        }
    }

    @Override
    public void sort() {
        Collections.sort(products);
    }

}
