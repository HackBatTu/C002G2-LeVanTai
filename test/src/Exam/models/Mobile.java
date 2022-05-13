package Exam.models;

public abstract class Mobile {
    private static Integer countID;
    private int id;
    private String name;
    private String price;
    private String soLuong;
    private String nhaSanXuat;

    public Mobile(int id, String name, String price, String soLuong, String nhaSanXuat) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public Mobile() {
    }

    public static Integer getCountID() {
        return countID;
    }

    public static void setCountID(Integer countID) {
        Mobile.countID = countID;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return  " id: "+ id +
                "name: " + name + '\'' +
                ", price: " + price + '\'' +
                ", soLuong: " + soLuong + '\'' +
                ", nhaSanXuat: " + nhaSanXuat + '\'' +
                ',';
    }
    public String line(){
        return this.id+"," +this.name+","+this.price+","+this.soLuong+","+this.nhaSanXuat;
    }
}
