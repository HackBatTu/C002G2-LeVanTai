package model;

public class Employee {
    private int id;
    private String name;
    private String birthDay;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;
    private EmployeePosition employeePosition;
    private EducationDegree educationDegree;
    private Division division;
    private User userName;
    private int status;

    public Employee(int id, String name, String birthDay, String idCard, double salary, String phone, String email, String address, EmployeePosition employeePosition, EducationDegree educationDegree, Division division, User userName,int status) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.employeePosition = employeePosition;
        this.educationDegree = educationDegree;
        this.division = division;
        this.userName = userName;
        this.status = status;
    }

    public Employee(int id, String name, String birthDay, String idCard, double salary, String phone, String email, String address, EmployeePosition employeePosition, EducationDegree educationDegree, Division division, User userName) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.employeePosition = employeePosition;
        this.educationDegree = educationDegree;
        this.division = division;
        this.userName = userName;
    }

    public Employee(String name, String birthDay, String idCard, double salary, String phone, String email, String address, EmployeePosition employeePosition, EducationDegree educationDegree, Division division, User userName) {
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.employeePosition = employeePosition;
        this.educationDegree = educationDegree;
        this.division = division;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUserName() {
        return userName;
    }

    public void setUsername(User userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
