package Transport.controller;

import Transport.service.TransportManager;

import java.util.Scanner;

public class Menu {

    public static void menu() {
        System.out.print("Menu Transport: " + "\n" +
                "1.Add" + "\n" +
                "2.Display" + "\n" +
                "3.Delete" + "\n" +
                "4.FindBKS" + "\n" +
                "0.Exit" + "\n" +
                "Enter the choise: ");
    }
    public static void menuTransport() {
        System.out.println("1.*****Car: "+"\n" +
                "2.*****Moto: "+"\n" +
                "3.*****Truck: "+"\n" +
                "0.*****Exit"+"\n" +
                "Enter the choice: ");
    }

    public void displayManager() {
        TransportManager transportManager = new TransportManager();
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            menu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter the Transport you want add: ");
                    menuTransport();
                    transportManager.add();
                    break;
                case 2:
                    System.out.println("Enter the Transport you want display");
                    menuTransport();
                    transportManager.display();
                    break;
                case 3:
                    transportManager.delete();
                    break;
                case 4:
                    transportManager.update();
                    break;
                case 0:
                    System.out.println("see you again");
                    return;
                default:
                    System.out.println("Bạn nhập sai mời nhập lại ");


            }
        }
    }


}
