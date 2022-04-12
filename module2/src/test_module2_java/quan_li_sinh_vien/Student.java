package test_module2_java.quan_li_sinh_vien;

import test_module2_java.Date;

public class Student {
    private int maSV;
    private String name;
    private double diemTB;
    private Date date;
    private Class classes;

    public Student() {
    }

    public Student(int maSV, String name, double diemTB, Date date, Class classes) {
        this.maSV = maSV;
        this.name = name;
        this.diemTB = diemTB;
        this.date = date;
        this.classes = classes;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }
    public String layTenKhoa(){
        return this.classes.getNameKhoa();
    }
    public boolean kTDTB(){
        return this.diemTB <= 5;
    }
    public boolean kTNgaySinh(Student obj){
        return  this.date.equals(obj.date);
    }
}
