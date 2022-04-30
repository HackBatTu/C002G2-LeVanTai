package casestudy.services.impl;


import casestudy.models.person.Employee;
import casestudy.services.inter_face.IEmployeeService;
import casestudy.utils.file.ReadAndWriteBuffer;
import casestudy.utils.regex.Regex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService, Serializable {
    List<Employee> employees = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private static final String DATE_REGEX ="^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/(((19)[2-9]{1}[0-9]{1})|(200)[1-4]{1})$";

    {
        Employee employee1 = new Employee(1,"hoan", "01/01/2001", "male", 1001, "0909", "gaHoan@gmail.com",  "con gà", "xách dép", 1000);
        Employee employee2 = new Employee(2,"phương", "01/02/2001", "male", 2002, "0909", "gaHoan@gmail.com",  "hơi non", "culi", 2000);
        Employee employee3 = new Employee(3,"luận", "01/03/2001", "male", 3003, "0909", "gaHoan@gmail.com",  "con gà", "nhặt ống bơ", 1500);
        Employee employee4 = new Employee(4,"hậu", "01/04/2001", "male", 4004, "0909", "gaHoan@gmail.com",  "con gà", "xách dép", 1500);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        ReadAndWriteBuffer.writeEmployee("src/casestudy/data/employee.csv",employees);
    }

    @Override
    public void add() {
        System.out.print("Enter the EmployeeID: ");
        int employeeID = Integer.parseInt(sc.nextLine());
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
        System.out.print("Enter the Level: ");
        String lever = sc.nextLine();
        System.out.print("Enter the Position: ");
        String position = sc.nextLine();
        System.out.print("Enter the Wage: ");
        int wage = Integer.parseInt(sc.nextLine());
        Employee employee = new Employee(employeeID,name, date, gender, idCard, phone, email, lever, position, wage);
        employees.add(employee);
        ReadAndWriteBuffer.writeEmployee("src/casestudy/data/employee.csv",employees);

    }

    @Override
    public void display() {
        employees = ReadAndWriteBuffer.readEmployee();
        System.out.print("*----List Employee----*\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter the EmployeeID you want edit: ");
        int newEdit = Integer.parseInt(sc.nextLine());
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID().equals(newEdit)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (Employee employee : employees) {
                if (employee.getID().equals(newEdit)) {
                    System.out.print("Enter the new EmployeeID: ");
                    employee.setId(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Name: ");
                    employee.setName(sc.nextLine());
                    System.out.print("Enter the new Date: ");
                    employee.setDate(Regex.regexAge(sc.nextLine(),DATE_REGEX));
                    System.out.print("Enter the new Gender: ");
                    employee.setGender(sc.nextLine());
                    System.out.print("Enter the new idCard: ");
                    employee.setIdCard(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Phone: ");
                    employee.setPhone(sc.nextLine());
                    System.out.print("Enter the new Email: ");
                    employee.setEmail(sc.nextLine());
                    System.out.print("Enter the new Level: ");
                    employee.setLevel(sc.nextLine());
                    System.out.print("Enter the new Position: ");
                    employee.setPosition(sc.nextLine());
                    System.out.print("Enter the new Wage: ");
                    employee.setSalary(Integer.parseInt(sc.nextLine()));
                    break;
                }
            }
            ReadAndWriteBuffer.writeEmployee("src/casestudy/data/employee.csv",employees);
        }else {
            System.out.print("is not found EmployeeID");
        }

    }
}
