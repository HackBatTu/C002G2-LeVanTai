package test_module2_java.casestudy.services.impl;

import test_module2_java.casestudy.models.person.Customer;
import test_module2_java.casestudy.services.inter_face.ICustomerService;
import test_module2_java.casestudy.utils.file.ReadAndWriteBuffer;
import test_module2_java.casestudy.utils.regex.Regex;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService, Serializable {
    private static List<Customer> customerLinkedList = new LinkedList<>();
    private static final String DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/(((19)[2-9]{1}[0-9]{1})|(200)[1-4]{1})$";
    private static final String PATH_CUS = "src/test_module2_java/casestudy/data/customer.csv";
    static {
        customerLinkedList.add(new Customer(1, "Hoan", "01/01/2001", "male", 12345567, "054643", "Hoan@1234", "Member", "xó núi"));
        customerLinkedList.add(new Customer(2, "Luan", "02/02/2001", "male", 4366566, "01232323", "Luan@1234", "Gold", "xó núi"));
        customerLinkedList.add(new Customer(3, "Phuong", "03/03/2001", "male", 1213123, "04543", "Phuong@1234", "Diamond", "xó núi"));

        ReadAndWriteBuffer.writeCustomer(PATH_CUS, customerLinkedList);
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        System.out.print("Enter the CustomerID: ");
        int customerID = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the Name: ");
        String name = sc.nextLine();
        System.out.print("Enter the Date: ");
        String date = Regex.regexAge(sc.nextLine(), DATE_REGEX);
        System.out.print("Enter the Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter the idCard: ");
        int idCard = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter the Email: ");
        String email = sc.nextLine();
        String customerType = menuTypeCustomer();
        System.out.print("Enter the Address: ");
        String address = sc.nextLine();
        Customer customer = new Customer(customerID, name, date, gender, idCard, phone, email, customerType, address);
        customerLinkedList.add(customer);
        ReadAndWriteBuffer.writeCustomer(PATH_CUS, customerLinkedList);
    }

    public String menuTypeCustomer() {
        while (true) {
            System.out.print("*--CustomerType : " + "\n" +
                    "1.Diamond  " + "\n" +
                    "2.Platinium  " + "\n" +
                    "3.Gold " + "\n" +
                    "4.Silver " + "\n" +
                    "5.Member" + "\n" +
                    "you choice: ");
            int choice = 0;
            choice = Regex.getChoice(choice);
            switch (choice) {
                case 1:
                    return "Diamond";
                case 2:
                    return "Platinium";
                case 3:
                    return "Gold";
                case 4:
                    return "Silver";
                case 5:
                    return "Menber";
                default:
                    System.out.println("Re choice: ");
                    break;

            }
        }
    }

    @Override
    public void display() {
        System.out.println("*---List Customer---*");
        customerLinkedList = ReadAndWriteBuffer.readCustomer();
        for (Customer customer : customerLinkedList) {
            System.out.println(customer);
        }
    }

    public static List<Customer> getCustomers() {
        customerLinkedList = ReadAndWriteBuffer.readCustomer();
        return customerLinkedList;
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
                    customerLinkedList.get(i).setDate(Regex.regexAge(sc.nextLine(), DATE_REGEX));
                    System.out.print("Enter the new Gender: ");
                    customerLinkedList.get(i).setGender(sc.nextLine());
                    System.out.print("Enter the new idCard: ");
                    customerLinkedList.get(i).setIdCard(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Phone: ");
                    customerLinkedList.get(i).setPhone(sc.nextLine());
                    System.out.print("Enter the new Email: ");
                    customerLinkedList.get(i).setEmail(sc.nextLine());
                    customerLinkedList.get(i).setTypeCustomer(menuTypeCustomer());
                    System.out.print("Enter the new Address: ");
                    customerLinkedList.get(i).setAddress(sc.nextLine());
                    break;

                }
            }
            ReadAndWriteBuffer.writeCustomer(PATH_CUS, customerLinkedList);
        } else {
            System.out.println("is not found Customer");
        }
    }
}
