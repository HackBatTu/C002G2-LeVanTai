package Transport.model;

import Transport.model.HangSanXuat;
import Transport.model.Transport;

import java.util.Scanner;

public class Truck extends Transport {
    private int trongTai;

    public Truck(int trongTai) {
        this.trongTai = trongTai;
    }
    public Truck() {

    }
    public Truck(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu, int trongTai) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter tonnage (T): ");
        this.trongTai = Integer.parseInt(sc.nextLine());
    }
    @Override
    public String toString() {
        return "Truck: " +
                "trongTai: " + trongTai +
                super.toString();

    }
}
