package casestudy.services;


import casestudy.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements  IEmployeeService{
    List<Employee> employees = new ArrayList<>();

    {
        Employee employee1 = new Employee("hoàn","01/01/2001","male",1001,"0909","gaHoan@gmail.com",1,"con gà","xách dép",1000);
        Employee employee2 = new Employee("phương","01/02/2001","male",2002,"0909","gaHoan@gmail.com",2,"hơi non","culi",2000);
        Employee employee3 = new Employee("luận","01/03/2001","male",3003,"0909","gaHoan@gmail.com",3,"con gà","nhặt ống bơ",1500);
        Employee employee4 = new Employee("hậu","01/04/2001","male",4004,"0909","gaHoan@gmail.com",4,"con gà","xách dép",1500);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
    }
    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
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
        System.out.print("Enter the EmployeeID: ");
        int employeeID =Integer.parseInt(sc.nextLine());
        System.out.print("Enter the Level: ");
        String lever = sc.nextLine();
        System.out.print("Enter the Position: ");
        String position = sc.nextLine();
        System.out.print("Enter the Wage: ");
        int wage =Integer.parseInt(sc.nextLine());
        Employee employee = new Employee(name,date,gender,idCard,phone,email,employeeID,lever,position,wage);
        employees.add(employee);

    }

    @Override
    public void display() {
        System.out.print("*----List Employee----*");
        for (Employee x: employees) {
            System.out.println(x);
        }
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the EmployeeID you want edit: ");
        int newEdit = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<employees.size();i++){
            if(newEdit == employees.get(i).getEmployeeID()){
                System.out.print("Enter the new Name: ");
                employees.get(i).setName(sc.nextLine());
                System.out.print("Enter the new Date: ");
                employees.get(i).setDate(sc.nextLine());
                System.out.print("Enter the new Gender: ");
                employees.get(i).setGender(sc.nextLine());
                System.out.print("Enter the new idCard: ");
                employees.get(i).setIdCard(Integer.parseInt(sc.nextLine()));
                System.out.print("Enter the new Phone: ");
                employees.get(i).setPhone(sc.nextLine());
                System.out.print("Enter the new Email: ");
                employees.get(i).setEmail(sc.nextLine());
                System.out.print("Enter the new EmployeeID: ");
                employees.get(i).setEmployeeID(Integer.parseInt(sc.nextLine()));
                System.out.print("Enter the new Level: ");
                employees.get(i).setLevel(sc.nextLine());
                System.out.print("Enter the new Position: ");
                employees.get(i).setPosition(sc.nextLine());
                System.out.print("Enter the new Wage: ");
                employees.get(i).setWage(Integer.parseInt(sc.nextLine()));
                break;
            }else {
                System.out.print("is not found EmployeeID");
            }
        }

    }
}
