package casestudy.controllers;

import casestudy.models.Employee;
import casestudy.services.CustomerServiceImpl;
import casestudy.services.EmployeeServiceImpl;
import casestudy.services.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {


    EmployeeServiceImpl employee = new EmployeeServiceImpl();
    CustomerServiceImpl customer = new CustomerServiceImpl();
    FacilityServiceImpl facility= new FacilityServiceImpl();
    Scanner sc= new Scanner(System.in);
    int choice;
    public void displayMainMenu(){
        do{
            System.out.println("*-----Menu Manager-----* ");
            System.out.print("1.Employee Management\n" +
                    "2.Customer Management\n" +
                    "3.Facility Management \n" +
                    "4.Booking Management\n" +
                    "5.Promotion Management\n" +
                    "0.Exit\n"+
            "Enter the choice : ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1:
                   employeeMenu();
                   break;
                case 2:
                   customerMenu();
                   break;
                case 3:
                   facilityMenu();
                   break;
                case 4:
                   bookingAndContractMenu();
                   break;
                case 5:
                   promotionMenu();
                   break;
                case 0:
                    return;
                default:
                    System.out.println("***See you again");
                    break;
            }
        }while (true);

    }

    public void employeeMenu(){
        while (true){
            System.out.println("*-----Employee Management-----*  ");
            System.out.println("1\tDisplay list employees\n" +
                    "2.Add new employee\n" +
                    "3.Edit employee\n" +
                    "0.Return main menu\n"+
                    "Enter the choice : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    employee.display();
                    break;
                case 2:
                    employee.add();
                    break;
                case 3:
                    employee.edit();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("***See you again");
                    break;
            }

        }
    }
    public void customerMenu(){
        while (true){
            System.out.println("*-----Customer Management-----*  ");
            System.out.println("1.Display list customers\n" +
                    "2.Add new customer\n" +
                    "3.Edit customer\n" +
                    "0.Return main menu\n"+
                    "Enter the choice : ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    customer.display();
                    break;
                case 2:
                    customer.add();
                    break;
                case 3:
                    customer.edit();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("***See you again");
            }
            break;
        }
    }
    public  void facilityMenu(){
        while (true){
            System.out.println("*-----Facility Management -----* ");
            System.out.println("1.Display list facility\n" +
                    "2.Add new facility\n" +
                    "3.Display list facility maintenance\n" +
                    "0.Return main menu\n"+
                    "Enter the choice : ");
           int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    facility.display();
                    break;
                case 2:
                    facility.add();
                    break;
                case 3:
                    facility.edit();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("***See you again");
            }
        }

    }
    public void bookingAndContractMenu(){
        while (true){
            System.out.println("*-----Booking Management-----*: ");
            System.out.println("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new constracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "0.\tReturn main menu\n"+
                    "Enter the choice : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 0:
                    return;
                default:
                    System.out.println("***See you again");
            }
        }
    }
    public void promotionMenu(){
        while (true){
            System.out.println("*-----Promotion Management-----*");
            System.out.println("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "0.\tReturn main menu\n"+
                    "Enter the choice : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                case 2:
                case 0:
                    return;
                default:
                    System.out.println("***See you again");
                    break;
            }
        }
    }
}
