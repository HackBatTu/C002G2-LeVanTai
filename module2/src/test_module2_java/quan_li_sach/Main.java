package test_module2_java.quan_li_sach;

import test_module2_java.Date;

public class Main {
    public static void main(String[] args) {
            Date ngay1 = new Date(1,1,2001);
            Date ngay2 = new Date(2,1,2001);
            Date ngay3 = new Date(3,1,2001);

            System.out.println(ngay1 +"\n" + ngay2 +'\n' + ngay3);

            TenTacGia tacGia1 = new TenTacGia("xx",ngay1);
            TenTacGia tacGia2 = new TenTacGia("xx",ngay2);
            TenTacGia tacGia3 = new TenTacGia("xx",ngay3);

            Book book1 = new Book("xxx",5000,2000,tacGia1);
            Book book2 = new Book("xxy",5000,2001,tacGia2);
            Book book3 = new Book("xxz",5000,2000,tacGia3);

            book1.inNameBook();
            book2.inNameBook();
            book3.inNameBook();

            System.out.println(book1.layTenTG());

            System.out.println("so sánh năm xuất bản : " + book1.KTNXB(book2));
            System.out.println("so sánh năm xuất bản : " + book1.KTNXB(book3));

            System.out.println("giá sách1 sau khi giảm 10% : " + book1.GiaSauKhiGiam(10));
            System.out.println("giá sách2 sau khi giảm 10% : " + book2.GiaSauKhiGiam(10));
            System.out.println("giá sách3 sau khi giảm 10% : " + book3.GiaSauKhiGiam(10));
    }
}
