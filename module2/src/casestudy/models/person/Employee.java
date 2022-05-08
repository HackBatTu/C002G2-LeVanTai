package casestudy.models.person;

public class Employee extends Person {
    private String level;
    private String position;
    private Integer salary;
//     Trình độ, Vị trí, lương
    public Employee() {
    }

    public Employee(Integer id, String name, String date, String gender, Integer idCard, String phone, String email, String level, String position, Integer salary) {
        super(id, name, date, gender, idCard, phone, email);
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String convertLine(){
        String line = super.convertLine() + ","+
                this.level+","+
                this.position+","+
                this.salary;
        return line;
    }

    @Override
    public String toString() {
        return "Employee [" + super.toString()+
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary: " + salary +
                ']';
    }
}
