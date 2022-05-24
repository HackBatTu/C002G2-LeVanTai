package Exam.models;

public class DienThoaiChinhHang extends Mobile{
    private String thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang(int id, String name, String price, String soLuong, String nhaSanXuat, String thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, name, price, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public DienThoaiChinhHang() {
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "DienThoaiChinhHang [" + super.toString()+
                "thoiGianBaoHanh: " + thoiGianBaoHanh + '\'' +
                ", phamViBaoHanh: " + phamViBaoHanh + '\'' +
                ']';
    }
    public String line(){
        return super.line()+","+ this.thoiGianBaoHanh+","+this.thoiGianBaoHanh;
    }
}
