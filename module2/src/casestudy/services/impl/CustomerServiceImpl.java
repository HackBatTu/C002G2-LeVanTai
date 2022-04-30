package casestudy.services.impl;

import casestudy.models.person.Customer;
import casestudy.services.inter_face.ICustomerService;
import casestudy.utils.file.ReadAndWriteBuffer;
import casestudy.utils.regex.Regex;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService, Serializable {
    private static List<Customer> customerLinkedList = new LinkedList<>();
    private static final String DATE_REGEX ="^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/(((19)[2-9]{1}[0-9]{1})|(200)[1-4]{1})$";
    static {
        customerLinkedList.add(new Customer(1, "Hoan", "01/01/2001", "male", 12345567, "054643", "Hoan@1234", "Vip", "xó núi"));
        customerLinkedList.add(new Customer(2, "Luan", "02/02/2001", "male", 4366566, "01232323", "Luan@1234", "Vip", "xó núi"));
        customerLinkedList.add(new Customer(3, "Phuong", "03/03/2001", "male", 1213123, "04543", "Phuong@1234", "Vip", "xó núi"));

        ReadAndWriteBuffer.writeCustomer("src/casestudy/data/customer.csv",customerLinkedList);
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
        customerLinkedList.add(customer);
        ReadAndWriteBuffer.writeCustomer("src/casestudy/data/customer.csv",customerLinkedList);
    }

    @Override
    public void display() {
        System.out.println("*---List Customer---*\n");
        customerLinkedList = ReadAndWriteBuffer.readCustomer();
        for (Customer customer : customerLinkedList) {
            System.out.println(customer);
        }
    }
    public static List<Customer> getCustomers() {
        customerLinkedList =  ReadAndWriteBuffer.readCustomer();
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
            ReadAndWriteBuffer.writeCustomer("src/casestudy/data/customer.csv",customerLinkedList);
        } else {
            System.out.println("is not found Customer");
        }
    }
}
