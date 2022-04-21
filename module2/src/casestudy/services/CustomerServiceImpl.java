package casestudy.services;

import casestudy.models.Customer;
import ss10_array_list_link_list.bai_tap.link_list.MainMyLinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private static final LinkedList<Customer> customerLinkedList = new LinkedList<>();

    static {
        Customer customer1 = new Customer("Hoàn1", "01/01/2001", "male", 2001, "0909", "Hoanchodien@email", 101, "vip", "xó núi");
        Customer customer2 = new Customer("Luận1", "01/02/2001", "male", 2002, "0908", "Luanchodien@email", 102, "gà", "bãi rác");
        Customer customer3 = new Customer("Phương1", "01/03/2001", "male", 2003, "0907", "Hoanchodien@email", 103, "non", "xó núi");
        Customer customer4 = new Customer("Hậu1", "01/04/2001", "male", 2004, "0906", "Hoanchodien@email", 104, "vippro", "bãi rác");
        customerLinkedList.add(customer1);
        customerLinkedList.add(customer2);
        customerLinkedList.add(customer3);
        customerLinkedList.add(customer4);
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        System.out.print("Enter the Name: ");
        String name = sc.nextLine();
        System.out.print("Enter the Date: ");
        String date = sc.nextLine();
        System.out.print("Enter the Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter the idCard: ");
        int idCard = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter the Email: ");
        String email = sc.nextLine();
        System.out.print("Enter the CustomerID: ");
        int customerID = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the CustomerType: ");
        String customerType = sc.nextLine();
        System.out.print("Enter the Address: ");
        String address = sc.nextLine();
        Customer customer = new Customer(name, date, gender, idCard, phone, email, customerID, customerType, address);
        customerLinkedList.addLast(customer);
    }

    @Override
    public void display() {
        System.out.println("*---List Customer---*\n");
        for (Customer x : customerLinkedList) {
            System.out.println(x);
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter the CustomerID you want edit: ");
        int newID = Integer.parseInt(sc.nextLine());
        boolean flag = false;
        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).getCustomerID().equals(newID)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < customerLinkedList.size(); i++) {
                if (customerLinkedList.get(i).getCustomerID().equals(newID)) {
                    System.out.print("Enter the new Name: ");
                    customerLinkedList.get(i).setName(sc.nextLine());
                    System.out.print("Enter the new Date: ");
                    customerLinkedList.get(i).setDate(sc.nextLine());
                    System.out.print("Enter the new Gender: ");
                    customerLinkedList.get(i).setGender(sc.nextLine());
                    System.out.print("Enter the new idCard: ");
                    customerLinkedList.get(i).setIdCard(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Phone: ");
                    customerLinkedList.get(i).setPhone(sc.nextLine());
                    System.out.print("Enter the new Email: ");
                    customerLinkedList.get(i).setEmail(sc.nextLine());
                    System.out.print("Enter the new EmployeeID: ");
                    customerLinkedList.get(i).setCustomerID(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Level: ");
                    customerLinkedList.get(i).setCustomerType(sc.nextLine());
                    System.out.print("Enter the new Position: ");
                    customerLinkedList.get(i).setAddress(sc.nextLine());
                    break;

                }
            }
        } else {
            System.out.println("is not found Customer");
        }
    }
}
