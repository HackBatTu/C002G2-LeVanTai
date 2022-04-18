package ss12_Java_collection_framework.bai_tap.luyen_tap_arraylist.controller;

import ss12_Java_collection_framework.bai_tap.luyen_tap_arraylist.service.ProductManager;

import java.util.Scanner;

public class MenuProduct {
    public void menuProduct() {
        ProductManager productManager = new ProductManager();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(" ***Menu Product :\n" +
                    " 1. Add\n" +
                    " 2. Display\n" +
                    " 3. Delete(id)\n" +
                    " 4. Find Name\n" +
                    " 5. Edit\n" +
                    " 6. Sort\n" +
                    " 0. Exit"+"\n"+
                    "Enter the choice : ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    productManager.add();
                    break;
                case 2:
                    productManager.display();
                    break;
                case 3:
                    productManager.delete();
                    break;
                case 4:
                    productManager.findname();
                    break;
                case 5:
                    productManager.edit();
                    break;
                case 6:
                    productManager.sort();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(" see you again ");
            }

        } while (true);
    }
}