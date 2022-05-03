package casestudy_module2.controller;

import casestudy_module2.util.Regex;

public class FuramaController {

    public void displayMainMenu(){
        System.out.println("***----Menu Management----***");
        System.out.print("1.Employee Management\n" +
                "2.Customer Management\n" +
                "3.Facility Management \n" +
                "4.Booking Management\n" +
                "5.Promotion Management\n" +
                "0.Exit\n"+
        "enter the choice: ");
        int choice1 = 0;
        choice1 = Regex.regexChoice(choice1);
        switch (choice1){
            case 1 :
                employeeMenu();
                break;
            case 2 :
                customerMenu();
                break;
            case 3 :
                facilityMenu();
                break;
            case 4 :
                bookingMenu();
                break;
            case 5 :
                promotionMenu();
                break;
            case 0 :
                return;
            default:
                System.out.print("Re choice: ");
        }

    }
    public void employeeMenu(){
        System.out.println("***---Employees Menu---***");
        System.out.print("1.Display list employees\n" +
                "2.Add new employee\n" +
                "3.Edit employee\n" +
                "0.Return main menu\n"+
                "enter the choice: ");
    }
    public void customerMenu(){
        System.out.println("***---Customer Menu---***");
        System.out.print("1.Display list customers\n" +
                "2.Add new customer\n" +
                "3.Edit customer\n" +
                "0.Return main menu\n"+
                "enter the choice: ");
    }
    public void facilityMenu(){
        System.out.println("***---Facility Menu---***");
        System.out.print("1.Display list facility\n" +
                "2.Add new facility\n" +
                "3.Display list facility maintenance\n" +
                "0.Return main menu\n"+
                "enter the choice: ");
    }
    public void menu2(){
        System.out.println("***---Add new Menu---***");
        System.out.print("1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "0.Back to menu\n"+"" +
                "enter the choice: ");
    }
    public void bookingMenu(){
        System.out.println("***---Booking Menu---***");
        System.out.print("1.Add new booking\n" +
                "2.Display list booking\n" +
                "3.Create new contracts\n" +
                "4.Display list contracts\n" +
                "5.Edit contracts\n" +
                "0.Return main menu\n"+"enter the choice: ");
    }
    public void promotionMenu(){
        System.out.println("***---Promotion Menu---***");
        System.out.print("1.Display list customers use service\n" +
                "2.Display list customers get voucher\n" +
                "0.Return main menu\n"+"enter the choice: ");
    }
}
