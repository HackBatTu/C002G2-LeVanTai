package Transport.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Transport {
    protected String bienKiemSoat;
    private HangSanXuat hangSanXuat;
    private int namSanXuat;
    private String chuSoHuu;

    public Transport() {
    }

    public Transport(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }


    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public HangSanXuat getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(HangSanXuat hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the BKS : ");
        this.bienKiemSoat =sc.nextLine();

        this.hangSanXuat = hangSX();

        System.out.println("Enter the year: ");
        this.namSanXuat = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the tên chủ : ");
        this.chuSoHuu = sc.nextLine();
    }

    public HangSanXuat hangSX() {
        Scanner sc = new Scanner(System.in);
        List<HangSanXuat> hangSXList = new ArrayList<>();
//        System.out.println("enter the id(mã) : ");
//        int id = Integer.parseInt(sc.nextLine());
//        System.out.println("enter the name( hãng) :");
//        String name = sc.nextLine();
//        System.out.println("enter the nation: ");
//        String nation = sc.nextLine();
//        hangSXList.add(new HangSanXuat(id, name, nation));
        hangSXList.add(new HangSanXuat(1, "Make in Vn", "VN"));
        hangSXList.add(new HangSanXuat(3, "Make in Lao", "Lao"));
        hangSXList.add(new HangSanXuat(4, "Make in China", "China"));
        hangSXList.add(new HangSanXuat(6, "Make in Japan", "Japan"));
        hangSXList.add(new HangSanXuat(6, "Make in Chú bộ đội", "Chú bộ đội"));
        int choice;
        do {
            for (int i = 0; i < hangSXList.size(); i++) {
                System.out.println((i + 1) + ": " + hangSXList.get(i).getName());
            }
            System.out.print("Your choice Hãng SX: ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice > 0 && choice < hangSXList.size()) {
                return hangSXList.get(choice - 1);
            } else {
                System.out.println(" see you again ");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return " bienKiemSoat: " + bienKiemSoat + '\'' +
                ", hangSanXuat: " + hangSanXuat +'\'' +
                ", namSanXuat: " + namSanXuat +'\'' +
                ", chuSoHuu: " + chuSoHuu;
    }
}
