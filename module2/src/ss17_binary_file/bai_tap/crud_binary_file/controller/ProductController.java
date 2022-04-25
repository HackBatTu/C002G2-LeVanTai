package ss17_binary_file.bai_tap.crud_binary_file.controller;

import ss17_binary_file.bai_tap.crud_binary_file.services.ProductImpl;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductController {
    public  void displayProduct(){
        ProductImpl product = new ProductImpl();
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        int choose;
        displayMenu();
        while (true) {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    product.display();
                    break;
                case 2:
                    product.add();
                    break;
                case 3:
                    product.edit();
                    break;
                case 4:
                    product.delete();
                    break;
                case 5:
                    product.search();
                    break;
                case 6:
                    product.sortProductByName();
                    break;
                case 7:
                    product.sortProductByPrice();
                    break;
                case 8:
                    product.sortProductById();
                    break;
                case 0:
                    System.out.println("exited!");
                    check = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (check) {
                break;
            }
         displayMenu();
        }
    }
    public static void displayMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. display Product.");
        System.out.println("2. Add product by id.");
        System.out.println("3. Edit product by id.");
        System.out.println("4. Delete product by id.");
        System.out.println("5. Search product by id.");
        System.out.println("6. Sort product by name.");
        System.out.println("7. Sort product by price .");
        System.out.println("8. Sort product by ID .");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose :  ");
    }
}
