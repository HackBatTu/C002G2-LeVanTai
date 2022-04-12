package test_module2_java.array;

import java.util.Arrays;

public class SinhVien implements Comparable<SinhVien> {
    private int maSV;
    private String name;
    private String lop;
    private double diemTB;

    public SinhVien() {
    }

    public SinhVien(int maSV, String name, String lop, double diemTB) {
        this.maSV = maSV;
        this.name = name;
        this.lop = lop;
        this.diemTB = diemTB;
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

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }
    public String getTen(){
        String s = this.name.trim();
        if(s.indexOf(" ")>=0){
            int index = s.lastIndexOf(" ");
            return s.substring(index + 1);
        }else {
            return s;
        }
    }

    @Override
    public String toString() {
        return "SinhVien : " +
                "maSV = " + maSV +
                "name='" + name + '\'' +
                "lop='" + lop + '\'' +
                "diemTB=" + diemTB ;
    }

    @Override
    public int compareTo(SinhVien o) {
        String tenThis = this.getTen();
        String tenO = o.getTen();
        return tenThis.compareTo(tenO);

//        return this.maSV - o.maSV;
//        if(this.diemTrungBinh<o.diemTrungBinh)
//            return -1;
//        else if(o.diemTrungBinh<this.diemTrungBinh)
//            return 1;
//        return 0;

    }

    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(01,"yasou","G2",10.0);
        SinhVien sv2 = new SinhVien(02,"yone","G3",10.0);
        SinhVien sv3 = new SinhVien(010,"Ayone","G1",10.0);
        System.out.println(sv1.compareTo(sv2));
        System.out.println(sv1.compareTo(sv3));
        SinhVien[] sv = new SinhVien[]{sv1,sv2,sv3};

        System.out.println("mảng ban đầu : " + Arrays.toString(sv));
        // hàm sắp xếp ( sort)
        Arrays.sort(sv);
        System.out.println("mảng sau sắp xếp : " + Arrays.toString(sv));
        //tìm kiếm : vị trí index sau sắp xếp
        System.out.println("tìm yasou : " + Arrays.binarySearch(sv,sv1));
        System.out.println("tìm yasou : " + Arrays.binarySearch(sv,sv3));
        // chuỗi thành mãng và trính xuất mảng
        String str = "hello , i am a student .Student CodeGym";
        String[] str1 = str.split("\\.|\\,");
        System.out.println(Arrays.toString(str1));
        System.out.println("tên: " + str1[str1.length-1]);


    }
}
