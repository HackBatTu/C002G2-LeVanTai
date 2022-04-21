package casestudy.controllers;

import casestudy.models.Employee;
import casestudy.services.*;

import java.util.Scanner;

public class FuramaController {
    EmployeeServiceImpl employee = new EmployeeServiceImpl();
    CustomerServiceImpl customer = new CustomerServiceImpl();
    FacilityServiceImpl facility= new FacilityServiceImpl();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    ContactServiceImpl contactService = new ContactServiceImpl();
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
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You Re- choice");
            }
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
                    System.out.println("***You Re-Choice: ");
                    break;
            }
        }while (true);

    }

    public void employeeMenu(){
        while (true){
            System.out.println("*-----Employee Management-----*  ");
            System.out.println("1.Display list employees\n" +
                    "2.Add new employee\n" +
                    "3.Edit employee\n" +
                    "0.Return main menu\n"+
                    "Enter the choice : ");
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You Re- choice");
            }
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
                    System.out.println("***You Re-Choice: ");
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
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You Re- choice");
            }
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
                    System.out.println("***You Re-Choice: ");
                    break;
            }
        }
    }
    public void facilityMenu(){
        while (true){
            System.out.println("*-----Facility Management -----* ");
            System.out.println("1.Display list facility\n" +
                    "2.Add new facility\n" +
                    "3.Display list facility maintenance\n" +
                    "0.Return main menu\n"+
                    "Enter the choice : ");
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You Re- choice");
            }
            switch (choice){
                case 1:
                    facility.display();
                    break;
                case 2:
                    addFacilityMenu2();
                    break;
                case 3:

                    break;
                case 0:
                    return;
                default:
                    System.out.println("***You Re-Choice: ");
                    break;
            }
        }

    }
    public void addFacilityMenu2() {
        while (true){
            System.out.println("*---Menu add Service add New---*"+"\n" +
                    "1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "0.Back to menu\n"+"Enter the Service you want add : ");
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You Re- choice");
            }
            switch (choice){
                case 1:
                    facility.addNewVilla();
                    facilityMenu();
                    break;
                case 2:
                    facility.addNewHouse();
                    facilityMenu();
                    break;
                case 3:
                    facility.addNewRoom();
                    facilityMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("You re-choice : ");
                    break;
            }
        }
    }
    public void bookingAndContractMenu(){
        while (true){
            System.out.println("*-----Booking Management-----*: ");
            System.out.println("1.\tAdd new booking\n" +
                    "2.Display list booking\n" +
                    "3.Create new constracts\n" +
                    "4.Display list contracts\n" +
                    "5.Edit contracts\n" +
                    "0.Return main menu\n"+
                    "Enter the choice : ");
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You Re- choice");
            }
            switch (choice){
                case 1:
                    bookingService.addBooking();
                    bookingAndContractMenu();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    bookingAndContractMenu();
                    break;
                case 3:
                    contactService.createNewContract();
                    break;
                case 4:
                    contactService.displayListContract();
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("***You Re-Choice: ");
            }
        }
    }
    public void promotionMenu(){
        while (true){
            System.out.println("*-----Promotion Management-----*");
            System.out.println("1.Display list customers use service\n" +
                    "2.Display list customers get voucher\n" +
                    "0.Return main menu\n"+
                    "Enter the choice : ");
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You Re- choice");
            }
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("***You Re-Choice:");
                    break;
            }
        }
    }
}
