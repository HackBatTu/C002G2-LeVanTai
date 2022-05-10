package bai_tap_lam_them.bai_3_exam;

public abstract class Person {
    private static Integer countId;
    private Integer id;
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getCountId() {
        return countId;
    }

    public static void setCountId(Integer countId) {
        Person.countId = countId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String convertLine() {
        String comma = ",";
        return this.id + comma + this.name;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name;
    }
}
