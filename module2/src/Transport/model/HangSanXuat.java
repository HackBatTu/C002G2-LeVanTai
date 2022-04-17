package Transport.model;

public class HangSanXuat {
    private int id;
    private String name;
    private String nation;

    public HangSanXuat(int id, String name, String nation) {
        this.id = id;
        this.name = name;
        this.nation = nation;
    }

    public HangSanXuat() {
    }

    public int getMa() {
        return id;
    }

    public void setMa(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "[ ma: " + id +
                ",ten hangSX: " + name + '\'' +
                ", quocGia: " + nation+ '\'' +"]";
    }
}
