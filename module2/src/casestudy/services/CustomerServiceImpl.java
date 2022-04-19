package casestudy.services;

import casestudy.models.Customer;
import ss10_array_list_link_list.bai_tap.link_list.MainMyLinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService{
    LinkedList<Customer> customerLinkedList= new LinkedList<>();
    {
        Customer customer1 = new Customer("Hoàn1","01/01/2001","male",2001,"0909","Hoanchodien@email",101,"vip","xó núi");
        Customer customer2 = new Customer("Luận1","01/02/2001","male",2002,"0908","Luanchodien@email",101,"gà","bãi rác");
        Customer customer3 = new Customer("Phương1","01/03/2001","male",2003,"0907","Hoanchodien@email",101,"non","xó núi");
        Customer customer4 = new Customer("Hậu1","01/04/2001","male",2004,"0906","Hoanchodien@email",101,"vippro","bãi rác");
        customerLinkedList.addFirst(customer1);
        customerLinkedList.addLast(customer2);
        customerLinkedList.addFirst(customer3);
        customerLinkedList.addLast(customer4);
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
        int customerID =Integer.parseInt(sc.nextLine());
        System.out.print("Enter the CustomerType: ");
        String customerType = sc.nextLine();
        System.out.print("Enter the Address: ");
        String address = sc.nextLine();
        Customer customer = new Customer(name,date,gender,idCard,phone,email,customerID,customerType,address);
        customerLinkedList.addLast(customer);
    }

    @Override
    public void display() {
        System.out.println("*---List Customer---*");
        for (Customer x: customerLinkedList) {
            System.out.println(x);
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter the CustomerID you want edit: ");
        int newID = Integer.parseInt(sc.nextLine());
        for(int i=0; i< customerLinkedList.size();i++){
            if(newID == customerLinkedList.get(i).getCustomerID()){
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
            }else {
                System.out.println("is not found Customer");
            }
        }

    }
}
