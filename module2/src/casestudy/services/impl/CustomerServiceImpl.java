package casestudy.services.impl;

import casestudy.models.person.Customer;
import casestudy.services.inter_face.ICustomerService;
import casestudy.utils.file.ReadAndWriteBuffer;
import casestudy.utils.regex.Regex;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService, Serializable {
    private static LinkedList<Customer> customerLinkedList = new LinkedList<>();
    private static final String DATE_REGEX ="([12][0-9]|3[01]|0?[1-9])-(0?[1-9]|1[012])-((?:19|20)\\\\d\\\\d)";
    static {
        customerLinkedList.add(new Customer(1, "Hoan", "day", "male", 12345567, "054643", "Hoan@1234", "Vip", "xó núi"));
        customerLinkedList.add(new Customer(2, "Luan", "day", "male", 4366566, "01232323", "Luan@1234", "Vip", "xó núi"));
        customerLinkedList.add(new Customer(3, "Phuong", "day", "male", 1213123, "04543", "Phuong@1234", "Vip", "xó núi"));

        ReadAndWriteBuffer.writeFile(customerLinkedList,"src/casestudy/data/customer.csv");
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        System.out.print("Enter the CustomerID: ");
        int customerID = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the Name: ");
        String name = sc.nextLine();
        System.out.print("Enter the Date: ");
        String date = Regex.regexAge(sc.nextLine(),DATE_REGEX);
        System.out.print("Enter the Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter the idCard: ");
        int idCard = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter the Email: ");
        String email = sc.nextLine();
        System.out.print("Enter the CustomerType: ");
        String customerType = sc.nextLine();
        System.out.print("Enter the Address: ");
        String address = sc.nextLine();
        Customer customer = new Customer(customerID,name,date,gender,idCard,phone,email,customerType,address);
        customerLinkedList.addLast(customer);
        ReadAndWriteBuffer.writeFile(customerLinkedList,"src/casestudy/data/customer.csv");
    }

    @Override
    public void display() {
        System.out.println("*---List Customer---*\n");
//        customerLinkedList = (LinkedList<Customer>) ReadAndWriteBuffer.readFile("src/casestudy/data/customer.csv");
        for (Customer customer : customerLinkedList) {
            System.out.println(customer);
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter the CustomerID you want edit: ");
        int newID = Integer.parseInt(sc.nextLine());
        boolean flag = false;
        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).getID().equals(newID)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < customerLinkedList.size(); i++) {
                if (customerLinkedList.get(i).getID().equals(newID)) {
                    System.out.print("Enter the new EmployeeID: ");
                    customerLinkedList.get(i).setId(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Name: ");
                    customerLinkedList.get(i).setName(sc.nextLine());
                    System.out.print("Enter the new Date: ");
                    customerLinkedList.get(i).setDate(Regex.regexAge(sc.nextLine(),DATE_REGEX));
                    System.out.print("Enter the new Gender: ");
                    customerLinkedList.get(i).setGender(sc.nextLine());
                    System.out.print("Enter the new idCard: ");
                    customerLinkedList.get(i).setIdCard(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Phone: ");
                    customerLinkedList.get(i).setPhone(sc.nextLine());
                    System.out.print("Enter the new Email: ");
                    customerLinkedList.get(i).setEmail(sc.nextLine());
                    System.out.print("Enter the new Level: ");
                    customerLinkedList.get(i).setTypeCustomer(sc.nextLine());
                    System.out.print("Enter the new Position: ");
                    customerLinkedList.get(i).setAddress(sc.nextLine());
                    break;

                }
            }
            ReadAndWriteBuffer.writeFile(customerLinkedList,"src/casestudy/data/customer.csv");
        } else {
            System.out.println("is not found Customer");
        }
    }
}
