package test_module2_java.string;

public class TimKiemChuoi {
    public static void main(String[] args) {
        String s1 = " Hello CodeGym , xxx , Hello";
        String s2 = " Hello";
        String s3 = " Hello con ga";
        char kiTu = 'o';

        // indexOf từ vị trí index 0 , đầu -> cuối
        System.out.println(s1.indexOf(s2)); //trả về vị trí xuất hiện s2 trong s1
        System.out.println(s1.indexOf(s3)); // trả về -1 là k tìm thấy s3 trong s1

        // sd vị trí bắt đầu
        System.out.println(s1.indexOf(s2,2));

        // tìm kí tự
        System.out.println(s1.indexOf(kiTu)); // bắt đầu từ index 0
        System.out.println(s1.indexOf(kiTu,6));

        // lastIndexOf từ vị trí length , cuối -> đầu , phải qua trái (thường dùng xử lí tên file)
        System.out.println(s1.lastIndexOf(kiTu));

    }

}
