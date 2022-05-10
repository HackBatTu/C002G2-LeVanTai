package bai_tap_lam_them.bai_3_exam;

public class Student extends Person {
    private Integer point;

    public Student() {
    }

    public Student(Integer point) {
        this.point = point;
    }

    public Student(int id, String name, Integer point) {
        super(id, name);
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String convertLine() {
        String comma = ",";
        return super.convertLine() + comma + this.point;
    }

    @Override
    public String toString() {
        return "Student {" +
                super.toString() +
                ", point: " + point +
                '}';
    }
}
