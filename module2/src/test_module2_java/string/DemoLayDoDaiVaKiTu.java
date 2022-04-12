package test_module2_java.string;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DemoLayDoDaiVaKiTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String : ");
        String str = sc.nextLine();

        // hàm length() lấy độ dài của chuỗi
        System.out.println("độ dài = " + str.length());
        int length = str.length();

        // hàm charAt -> lấy ra 1 kí tự tại vị trí
        for(int i =0 ; i<str.length(); i++){
            System.out.println("vị trí " + i + "là : " +str.charAt(i));
        }

        // Hàm getChars(vị trí đầu ,vị trí cuối-1 ,mảng lưu dữ liệu,vị trí bắt đầu lưu của mảng)
        char[] arrChar = new char[100];
        str.getChars(2,6,arrChar ,0);
        for (int i=0 ; i<arrChar.length; i++){
            System.out.println("giá trị của mảng "+i +"là :" + arrChar[i] );
        }

        //hàm getBytes -> có 3 cách ,lấy giá trị của các kí tự thành 1 mảng
        byte[] arrBytes = str.getBytes();
        for (byte a:arrBytes) {
            System.out.println(a);
        }
    }
}
