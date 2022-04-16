package Transport;

public class HangSanXuat {
    private int ma;
    private String nameHangSanXuat;
    private String quocGia;

    public HangSanXuat(int ma, String nameHangSanXuat, String quocGia) {
        this.ma = ma;
        this.nameHangSanXuat = nameHangSanXuat;
        this.quocGia = quocGia;
    }

    public HangSanXuat() {
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getNameHangSanXuat() {
        return nameHangSanXuat;
    }

    public void setNameHangSanXuat(String nameHangSanXuat) {
        this.nameHangSanXuat = nameHangSanXuat;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return "HangSanXuat: " + "\n" +
                "ma: " + ma +
                "nameHangSanXuat: " + nameHangSanXuat + '\n' +
                ", quocGia: " + quocGia;
    }
}
