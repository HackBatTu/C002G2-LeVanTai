package test_module2_java.quan_li_sach;

public class Book {
    private  String name ;
    private double gia ;
    private int yearXB ;
    private TenTacGia tenTG ;

    public Book() {
    }

    public Book(String name, double gia, int yearXB, TenTacGia tenTG) {
        this.name = name;
        this.gia = gia;
        this.yearXB = yearXB;
        this.tenTG = tenTG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getYearXB() {
        return yearXB;
    }

    public void setYearXB(int yearXB) {
        this.yearXB = yearXB;
    }

    public TenTacGia getTenTG() {
        return tenTG;
    }

    public void setTenTG(TenTacGia tenTG) {
        this.tenTG = tenTG;
    }
    public String layTenTG(){
        return this.tenTG.getTenTacGia();
    }
    public void inNameBook(){
        System.out.println(this.name);
    }
    public boolean KTNXB(Book sachKhac){
       return this.yearXB == sachKhac.yearXB;
    }
    public double GiaSauKhiGiam(double x ){
        return this.gia*(1-x/100);
    }
}
