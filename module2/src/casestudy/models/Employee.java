package casestudy.models;

public class Employee extends Person{
    private Integer employeeID;
    private String level;
    private String position;
    private Integer wage;
//    Mã nhân viên, Họ tên, Ngày sinh, Giới tính, Số CMND, Số Điện Thoại, Email, Trình độ, Vị trí, lương
    public Employee() {
    }
    public Employee(String name, String date, String gender, Integer idCard, String phone, String email, Integer employeeID, String level, String position, Integer wage) {
        super(name, date, gender, idCard, phone, email);
        this.employeeID = employeeID;
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public Employee(Integer employeeID, String level, String position, Integer wage) {
        this.employeeID = employeeID;
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
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

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee [" +super.toString()+
                "employeeId: " + employeeID +
                ", level: " + level + '\'' +
                ", position: " + position + '\'' +
                ", wage: " + wage +
                ']';
    }
}
