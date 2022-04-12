package test_module2_java.quan_li_sinh_vien_arrayList;

import java.util.Objects;

public class SinhVien implements Comparable<SinhVien>{
    private String maSV;
    private String name;
    private int namSinh;
    private double diemTB;

    public SinhVien(String maSV) {
        this.maSV = maSV;

    }

    public SinhVien(String maSV, String name, int namSinh, double diemTB) {
        this.maSV = maSV;
        this.name = name;
        this.namSinh = namSinh;
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "SinhVien: [" +
                "maSV= " + maSV + '\'' +
                ", name= " + name + '\'' +
                ", namSinh= " + namSinh +
                ", diemTB= " + diemTB +
                ']';
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.maSV.compareTo(o.maSV);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinhVien)) return false;
        SinhVien sinhVien = (SinhVien) o;
        return namSinh == sinhVien.namSinh && Double.compare(sinhVien.diemTB, diemTB) == 0 && maSV.equals(sinhVien.maSV) && name.equals(sinhVien.name);
    }


}
