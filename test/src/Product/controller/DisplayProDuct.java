package Product.controller;

import Product.service.TransportImpl;
import Product.utils.Regex;

public class DisplayProDuct {
   static TransportImpl transport = new TransportImpl();

    public void display(){
        while (true) {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Tìm kiếm theo biển kiểm soát\n" +
                    "0. Thoát\n"+
                    "enter the choice : ");
            int choice = 0;
            choice = Regex.regexChoice(choice);
            switch (choice){
                case 1:
                    menuAdd();
                    break;
                case 2:
                    menuDisplay();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Re choice! : ");

            }
        }
    }
    public static void menuAdd(){
        while (true){
            System.out.println(" Enter the Product you want add:");
            System.out.println("1. Thêm xe tải,\n" +
                    " 2. Thêm ôtô, \n" +
                    "3. Thêm  xe máy\n"+
                    "0. Thoát\n"+
                    "enter the choice : ");
            int choiceAdd = 0;
            choiceAdd = Regex.regexChoice(choiceAdd);
            switch (choiceAdd){
                case 1:
                    transport.addNewTruck();
                    break;
                case 2:
                    transport.addNewOto();
                    break;
                case 3:
                    transport.addNewMoto();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Re choice! : ");

            }
        }
    }
    public static void menuDisplay(){
        while (true){
            System.out.println(" Enter the Product you want display:");
            System.out.print("1. list Moto,\n" +
                    " 2. list Oto, \n" +
                    "3. list Truck\n"+
                    "4. list Transport\n"+
                    "0. Thoát\n"+
                    "enter the choice : ");
            int choiceAdd = 0;
            choiceAdd = Regex.regexChoice(choiceAdd);
            switch (choiceAdd){
                case 1:
                    transport.displayMoto();
                    break;
                case 2:
                    transport.displayOto();
                    break;
                case 3:
                    transport.displayTruck();
                    break;
                case 4:
                    transport.displayTransport();
                case 0:
                    return;
                default:
                    System.out.println("Re choice! : ");

            }
        }
    }

}
