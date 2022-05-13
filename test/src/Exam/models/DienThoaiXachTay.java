package Exam.models;

public class DienThoaiXachTay extends Mobile{
    private String quocGia;
    private String trangThai;

    public DienThoaiXachTay() {
    }

    public DienThoaiXachTay(int id, String name, String price, String soLuong, String nhaSanXuat, String quocGia, String trangThai) {
        super(id, name, price, soLuong, nhaSanXuat);
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "DienThoaiXachTay [" + super.toString()+
                "quocGia: " + quocGia + '\'' +
                ", trangThai: " + trangThai + '\'' +
                ']';
    }
    public String line(){
        return super.line()+ ","+this.quocGia+","+this.trangThai;
    }
}
