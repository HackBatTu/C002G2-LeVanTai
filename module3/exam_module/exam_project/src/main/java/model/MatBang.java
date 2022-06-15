package model;

public class MatBang {
    private String id;
    private double area;
    private TrangThai status;
    private int numberOfFloor;
    private LoaiVanPhong loaiVanPhong;
    private String moTa;
    private double prince;
    private String dateCheckIn;
    private String dateCheckOut;

    public MatBang() {
    }

    public MatBang(String id, double area, TrangThai status, int numberOfFloor, LoaiVanPhong loaiVanPhong, String moTa, double prince, String dateCheckIn, String dateCheckOut) {
        this.id = id;
        this.area = area;
        this.status = status;
        this.numberOfFloor = numberOfFloor;
        this.loaiVanPhong = loaiVanPhong;
        this.moTa = moTa;
        this.prince = prince;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public TrangThai getStatus() {
        return status;
    }

    public void setStatus(TrangThai status) {
        this.status = status;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public LoaiVanPhong getLoaiVanPhong() {
        return loaiVanPhong;
    }

    public void setLoaiVanPhong(LoaiVanPhong loaiVanPhong) {
        this.loaiVanPhong = loaiVanPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getPrince() {
        return prince;
    }

    public void setPrince(double prince) {
        this.prince = prince;
    }

    public String getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(String dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public String getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(String dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }
}
