package test_module2_java.string;

import java.util.Locale;

public class ChuyenDoiString {
    public static void main(String[] args) {
        String str1 = "Hello.CodeGym";
        String str2 = " I am a Student";

        // hàm concat (nối chuỗi)
        String str3 = str1.concat(str2);
        System.out.println(str3);

        // Hàm replaceAll (thay thế , thay đổi) thường dùng để thay thế tên miền .
        String str4 = str1.replaceAll("Hello","Xin Chao");
        System.out.println("str 4 = :"+ str4);

        //toLowerCase (hàm chuyển về chữ thường )
        // toUpperCase (hàm chuyển về chữ hoa)
        String str5 = str1.toLowerCase();
        String str6 = str1.toUpperCase();
        System.out.println(str5 +"\n"+ str6);

        // trim()> xóa khoảng trắng dư thừa ở đầu và cuối chuỗi
        String str7 = "    alo CodeGym   ";
        String s8 = str7.trim();
        System.out.println(s8);

        //toCharArray , đưa chuỗi về mảng các kí tự
        char[] s1 = str1.toCharArray();
        System.out.println(s1);
        for(int i =0 ; i<s1.length; i++){
            System.out.print(s1[i] +" ");
        }
        //subString -> cắt chuỗi con
        String str10 = "Hello CodeGym, I am a Student";
        String s10 = str10.substring(15);
        String s11 = str10.substring(6,13);
        System.out.println("\n" + s10);
        System.out.println(s11);

    }
}
