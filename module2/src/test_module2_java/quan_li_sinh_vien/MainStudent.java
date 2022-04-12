package test_module2_java.quan_li_sinh_vien;

import test_module2_java.Date;

public class MainStudent {
    public static void main(String[] args) {
        Date ngay1 = new Date(01,02,2022);
        Date ngay2 = new Date(01,03,2022);
        Date ngay3 = new Date(01,02,2022);

        Class class1 = new Class("G1","IT");
        Class class2 = new Class("G2","TT");
        Class class3 = new Class("G3 ","ITT");

        Student student1 = new Student(01,"lê văn A",8.0,ngay1,class1);
        Student student2 = new Student(02,"lê văn B",9.0,ngay2,class2);
        Student student3 = new Student(03,"lê văn C",8.0,ngay3,class3);

        System.out.println(student1.layTenKhoa());

        System.out.println(student1.kTNgaySinh(student2));
        System.out.println(student1.kTNgaySinh(student3));
    }
}
