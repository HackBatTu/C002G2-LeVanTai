package casestudy.services;

import casestudy.models.Customer;
import casestudy.utils.ReadAndWrite;
import ss10_array_list_link_list.bai_tap.link_list.MainMyLinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private static final LinkedList<Customer> customerLinkedList = new LinkedList<>();

    static {
        customerLinkedList.add(new Customer("Hoàn", "01/01/2001", "male", 1001, "01234", "Hoan@gmail.com", 1, "Vip", "xó núi"));
        customerLinkedList.add(new Customer("Luận", "01/01/2002", "male", 1001, "01234", "Luan@gmail.com", 2, "Vip", "xó núi"));
        customerLinkedList.add(new Customer("Phương", "01/02/2003", "male", 1002, "012345", "phuong@gmail.com", 3, "Normal", "xó núi"));
        ReadAndWrite.write(customerLinkedList,"src/casestudy/data/customer.csv");
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
        ReadAndWrite.write(customerLinkedList,"src/casestudy/data/customer.csv");
    }

    @Override
    public void display() {
        System.out.println("*---List Customer---*\n");
        List<Customer> customerLists =  (List<Customer>) ReadAndWrite.write(customerLinkedList,"src/casestudy/data/customer.csv");
        for (Customer x : customerLists) {
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
            ReadAndWrite.write(customerLinkedList,"src/casestudy/data/customer.csv");
        } else {
            System.out.println("is not found Customer");
        }
    }
}
