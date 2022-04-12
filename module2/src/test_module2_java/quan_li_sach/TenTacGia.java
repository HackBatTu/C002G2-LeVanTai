package test_module2_java.quan_li_sach;

import test_module2_java.Date;

public class TenTacGia {
    private String tenTacGia;
    private Date ngaySinh;

    public TenTacGia(String tenTacGia, Date ngaySinh) {
        this.tenTacGia = tenTacGia;
        this.ngaySinh = ngaySinh;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
