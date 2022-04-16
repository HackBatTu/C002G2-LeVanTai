package Transport;

public class Truck extends Transport {
    private String trongTai;

    public Truck(String trongTai) {
        this.trongTai = trongTai;
    }
    public Truck() {

    }
    public Truck(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu, String trongTai) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "Truck: " +
                "trongTai: " + trongTai +
                super.toString();

    }
}
