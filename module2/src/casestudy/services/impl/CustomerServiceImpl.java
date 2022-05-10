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
    private static final String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private static final String PATH_CUS = "src/casestudy/data/customer.csv.csv";

    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        customerLinkedList = ReadAndWriteBuffer.readCustomer();

        System.out.print("Enter the CustomerID: ");
        int customerID = 0;
        customerID = Regex.getChoice(customerID);
        System.out.print("Enter the Name: ");
        String name = sc.nextLine();
        System.out.print("Enter the Date: ");
        String date = Regex.regexAge(sc.nextLine(),DATE_REGEX);
        System.out.print("Enter the Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter the idCard: ");
        int idCard = 0;
        idCard = Regex.getChoice(idCard);
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
        customerLinkedList = ReadAndWriteBuffer.readCustomer();
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
                    int customerID = 0;
                    customerID = Regex.getChoice(customerID);
                    customerLinkedList.get(i).setId(customerID);
                    System.out.print("Enter the new Name: ");
                    customerLinkedList.get(i).setName(sc.nextLine());
                    System.out.print("Enter the new Date: ");
                    customerLinkedList.get(i).setDate(Regex.regexAge(sc.nextLine(),DATE_REGEX));
                    System.out.print("Enter the new Gender: ");
                    customerLinkedList.get(i).setGender(sc.nextLine());
                    System.out.print("Enter the new idCard: ");
                    int idCard = 0;
                    idCard = Regex.getChoice(idCard);
                    customerLinkedList.get(i).setIdCard(idCard);
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
