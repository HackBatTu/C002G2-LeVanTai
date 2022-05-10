package bai_tap_lam_them.bai_3_exam;

public class Teacher extends Person{
    private Double salary;

    public Teacher() {
    }

    public Teacher(Double salary) {
        this.salary = salary;
    }

    public Teacher(int id, String name, Double salary) {
        super(id, name);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String convertLine() {
        String comma = ",";
        return super.convertLine() + comma + this.salary;
    }

    @Override
    public String toString() {
        return "Teacher {" +
                super.toString() +
                ", salary: " + salary +
                '}';
    }
}
