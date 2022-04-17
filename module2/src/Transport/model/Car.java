package Transport.model;

import java.util.Scanner;

public class Car extends Transport {
    private int soChoNgoi;
    private String kieuXe;

    public Car(int soChoNgoi, String kieuXe) {
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public Car() {
    }

    public Car(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu, int soChoNgoi, String kieuxe) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.println("Enter số chỗ ngồi : ");
        this.soChoNgoi = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the type : ");
        this.kieuXe  = sc.nextLine();
    }
    @Override
    public String toString() {
        return "Car [" +
                super.toString() +
                ", chỗ ngồi : " + soChoNgoi +
                ", kiểu xe : '" + kieuXe + '\'' +
                ']';

    }

}
