package model;

public class Student {
    private int id;
    private String name;
    private Double point;
    private Integer gender;


    public Student(int id, String name, Double point, Integer gender) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.gender = gender;

    }

    public Student(String name, Double point, Integer gender) {
        this.name=name;
        this.point=point;
        this.gender = gender;
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

    public Double getPoint() {
        return point;
    }

    public void setPont(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        return "Student: [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pont=" + point +
                ", gender=" + gender +
                ']';
    }
}
