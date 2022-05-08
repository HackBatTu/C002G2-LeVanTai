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
    private static final String DATE_REGEX ="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private static final String PATH_EM="src/casestudy/data/employee.csv";

//    {
//        Employee employee1 = new Employee(1,"hoan", "01/01/2001", "male", 1001, "0909", "gaHoan@gmail.com",  "Undergraduate", "Waiter", 1000);
//        Employee employee2 = new Employee(2,"phương", "01/02/2001", "male", 2002, "0909", "gaHoan@gmail.com",  "College", "Waiter", 2000);
//        Employee employee3 = new Employee(3,"luận", "01/03/2001", "male", 3003, "0909", "gaHoan@gmail.com",  "Graduate", "Waiter", 1500);
//        Employee employee4 = new Employee(4,"hậu", "01/04/2001", "male", 4004, "0909", "gaHoan@gmail.com",  "Graduate", "Director", 1500);
//        employees.add(employee1);
//        employees.add(employee2);
//        employees.add(employee3);
//        employees.add(employee4);
//        ReadAndWriteBuffer.writeEmployee(PATH_EM,employees);
//    }

    @Override
    public void add() {
        employees = ReadAndWriteBuffer.readEmployee();
        System.out.print("Enter the EmployeeID: ");
        int employeeID = 0;
        employeeID = Regex.getChoice(employeeID);
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
        String lever = menuLevel();
        String position = menuPosition();
        System.out.print("Enter the Salary: ");
        int salary = 0;
        salary = Regex.getChoice(salary);
        Employee employee = new Employee(employeeID,name, date, gender, idCard, phone, email, lever, position, salary);
        employees.add(employee);
        ReadAndWriteBuffer.writeEmployee(PATH_EM,employees);
    }
    public String menuPosition() {
        while (true) {
            System.out.println("*--Position Employee : " + "\n" +
                    "1.Receptionist  " + "\n" +
                    "2.Waiter  " + "\n" +
                    "3.Specialist " + "\n" +
                    "4.Supervisor " + "\n" +
                    "5.Manager" + "\n" +
                    "6.Director" + "\n" +
                    "you choice: ");
            int choice = 0;
            choice = Regex.getChoice(choice);
            switch (choice) {
                case 1:
                    return "Receptionist";
                case 2:
                    return "Waiter";
                case 3:
                    return "Specialist";
                case 4:
                    return "Supervisor";
                case 5:
                    return "Manager";
                case 6:
                    return "Director";
                default:
                    System.out.println("Re choice: ");

            }
        }
    }
    public String menuLevel() {
        while (true) {
            System.out.println("*--Level Employee : " + "\n" +
                    "1.Intermediate  " + "\n" +
                    "2.College  " + "\n" +
                    "3.Undergraduate " + "\n" +
                    "4.Graduate " + "\n" +
                    "you choice: ");
            int choiceLevel = 0;
            choiceLevel = Regex.getChoice(choiceLevel);
            switch (choiceLevel) {
                case 1:
                    return "Intermediate";
                case 2:
                    return "College";
                case 3:
                    return "Undergraduate";
                case 4:
                    return "Graduate";
                default:
                    System.out.println("Re choice: ");

            }
        }
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
        employees = ReadAndWriteBuffer.readEmployee();
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
                    int employeeID = 0;
                    employeeID = Regex.getChoice(employeeID);
                    employee.setId(employeeID);
                    System.out.print("Enter the new Name: ");
                    employee.setName(sc.nextLine());
                    System.out.print("Enter the new Date: ");
                    employee.setDate(Regex.regexAge(sc.nextLine(),DATE_REGEX));
                    System.out.print("Enter the new Gender: ");
                    employee.setGender(sc.nextLine());
                    System.out.print("Enter the new idCard: ");
                    int idCard = 0;
                    idCard = Regex.getChoice(idCard);
                    employee.setIdCard(idCard);
                    System.out.print("Enter the new Phone: ");
                    employee.setPhone(sc.nextLine());
                    System.out.print("Enter the new Email: ");
                    employee.setEmail(sc.nextLine());
                    employee.setLevel(menuLevel());
                    employee.setPosition(menuPosition());
                    System.out.print("Enter the new Wage: ");
                    int salary = 0;
                    salary = Regex.getChoice(salary);
                    employee.setSalary(salary);
                    break;
                }
            }
            ReadAndWriteBuffer.writeEmployee(PATH_EM,employees);
        }else {
            System.out.print("is not found EmployeeID");
        }

    }
}
