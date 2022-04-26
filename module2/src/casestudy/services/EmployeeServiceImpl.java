package casestudy.services;


import casestudy.models.Employee;
import casestudy.utils.ReadAndWrite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService, Serializable {
    List<Employee> employees = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    {
        Employee employee1 = new Employee("hoàn", "01/01/2001", "male", 1001, "0909", "gaHoan@gmail.com", 1, "con gà", "xách dép", 1000);
        Employee employee2 = new Employee("phương", "01/02/2001", "male", 2002, "0909", "gaHoan@gmail.com", 2, "hơi non", "culi", 2000);
        Employee employee3 = new Employee("luận", "01/03/2001", "male", 3003, "0909", "gaHoan@gmail.com", 3, "con gà", "nhặt ống bơ", 1500);
        Employee employee4 = new Employee("hậu", "01/04/2001", "male", 4004, "0909", "gaHoan@gmail.com", 4, "con gà", "xách dép", 1500);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        ReadAndWrite.write(employees,"src/casestudy/data/employee.csv");
    }

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
        System.out.print("Enter the EmployeeID: ");
        int employeeID = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the Level: ");
        String lever = sc.nextLine();
        System.out.print("Enter the Position: ");
        String position = sc.nextLine();
        System.out.print("Enter the Wage: ");
        int wage = Integer.parseInt(sc.nextLine());
        Employee employee = new Employee(name, date, gender, idCard, phone, email, employeeID, lever, position, wage);
        employees.add(employee);
        ReadAndWrite.write(employees,"src/casestudy/data/employee.csv");

    }

    @Override
    public void display() {
//        employees = ReadAndWrite.read("E:\\C002G2-LeVanTai-Module2\\module2\\src\\casestudy\\data\\employee.csv");
        List<Employee> employeess = (List<Employee>) ReadAndWrite.read("src/casestudy/data/employee.csv");
        System.out.print("*----List Employee----*\n");
        for (Employee x : employeess) {
            System.out.println(x);
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter the EmployeeID you want edit: ");
        int newEdit = Integer.parseInt(sc.nextLine());
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID().equals(newEdit)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (Employee employee : employees) {
                if (employee.getEmployeeID().equals(newEdit)) {
                    System.out.print("Enter the new Name: ");
                    employee.setName(sc.nextLine());
                    System.out.print("Enter the new Date: ");
                    employee.setDate(sc.nextLine());
                    System.out.print("Enter the new Gender: ");
                    employee.setGender(sc.nextLine());
                    System.out.print("Enter the new idCard: ");
                    employee.setIdCard(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Phone: ");
                    employee.setPhone(sc.nextLine());
                    System.out.print("Enter the new Email: ");
                    employee.setEmail(sc.nextLine());
                    System.out.print("Enter the new EmployeeID: ");
                    employee.setEmployeeID(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter the new Level: ");
                    employee.setLevel(sc.nextLine());
                    System.out.print("Enter the new Position: ");
                    employee.setPosition(sc.nextLine());
                    System.out.print("Enter the new Wage: ");
                    employee.setWage(Integer.parseInt(sc.nextLine()));
                    break;
                }
            }
            ReadAndWrite.write(employees,"src/casestudy/data/employee.csv");
        }else {
            System.out.print("is not found EmployeeID");
        }

    }
}
