package Exam.controllers;
import Exam.services.MobileChinhHangImpl;
import Exam.services.MobileXachTayImpl;
import Exam.utils.Regex;

public class DisplayMobileControllers {
           private static MobileChinhHangImpl mobileChinhHang = new MobileChinhHangImpl();
           private static MobileXachTayImpl mobileXachTay = new MobileXachTayImpl();

    public void display(){
        while (true){
            System.out.println("**---Menu Manager---***");
            System.out.print("1. Mobile Chính Hãng Manager\n"+
                    "2. Mobie Xach Tay Manager\n"+
                    "0. Thoát.\n" +
                    "you choice : ");
            int choice =  Regex.checkParseInt();
            switch (choice){
                case 1:
                    displayMobileChinhHang();
                    break;
                case 2:
                    displayMobileXachTay();
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Re- choice: ");
            }
        }
    }
    public void displayMobileChinhHang(){
        while (true){
            System.out.println("**---Menu Mobile Chính Hãng Manager---***");
            System.out.print("1. Display mobile \n"+
                    "2. Add mobile\n"+
                    "3. Delete mobie\n"+
                    "4. Search mobile by id\n"+
                    "0. Thoát.\n" +
                    "you choice : ");
            int choice =  Regex.checkParseInt();
            switch (choice){
                case 1:
                    mobileChinhHang.display();
                    break;
                case 2:
                    mobileChinhHang.add();
                    break;
                case 3:
                    mobileChinhHang.delete();
                    break;
                case 4:
                    mobileChinhHang.search();
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Re- choice: ");
            }
        }
    }
    public void displayMobileXachTay(){
        while (true){
            System.out.println("**---Menu Mobiele Xách Tay Manager---***");
            System.out.print("1. Display mobile \n"+
                    "2. Add mobile\n"+
                    "3. Delete mobie\n"+
                    "4. Search mobile by id\n"+
                    "0. Thoát.\n" +
                    "you choice : ");
            int choice =  Regex.checkParseInt();
            switch (choice){
                case 1:
                    mobileXachTay.display();
                    break;
                case 2:
                    mobileXachTay.add();
                    break;
                case 3:
                    mobileXachTay.delete();
                    break;
                case 4:
                    mobileXachTay.search();
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Re- choice: ");
            }
        }
    }

}
