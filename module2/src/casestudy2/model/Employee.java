package casestudy2.model;

public class Employee extends Person{
    private String level;
    private String position;
    private String salary;

    public Employee() {
    }

    public Employee(String id, String name, String birthDay, String gender, String idCart, String email, String phone, String level, String position, String salary) {
        super(id, name, birthDay, gender, idCart, email, phone);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee : " + super.toString()+
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                '.';
    }
}
