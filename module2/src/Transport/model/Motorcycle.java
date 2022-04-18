package Transport.model;

import Transport.model.HangSanXuat;
import Transport.model.Transport;

import java.util.Scanner;

public class Motorcycle extends Transport {
    private int congSuat;

    public Motorcycle(int congSuat) {
        this.congSuat = congSuat;
    }
    public Motorcycle(){}

    public Motorcycle(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.println("Enter công suất: ");
        this.congSuat = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Motorcycle: ["+super.toString() +
       " , congSuat='" + congSuat + '\'';

    }
}
