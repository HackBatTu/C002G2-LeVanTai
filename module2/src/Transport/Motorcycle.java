package Transport;

public class Motorcycle extends Transport {
    private String congSuat;

    public Motorcycle(String congSuat) {
        this.congSuat = congSuat;
    }
    public Motorcycle(){}

    public Motorcycle(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu, String congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "Motorcycle: " +"\n"+
                "congSuat='" + congSuat + '\n'
                + super.toString();
    }
}
