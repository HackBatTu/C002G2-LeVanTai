package test_module2_java.string;

public class HamSoSanhString {
    public static void main(String[] args) {
        String str1 = "vlxx.xx";
        String str2 = "VLXX.xx";
        String str3 = "vlxx.xx";

        // hàm equals-> so sánh chuỗi giống nhau, có phân biệt hoa thường
        System.out.println("str1 and str2: "+ str1.equals(str2));
        System.out.println("str1 and str3: "+str1.equals(str3));
        // hàm equalsIgnoreCase-> so sánh nội dung chuỗi , k phân biệt hoa thường
        System.out.println("str1 and str2: "+ str1.equalsIgnoreCase(str2));
        System.out.println("str1 and str3: "+str1.equalsIgnoreCase(str3));

        // Hàm compareTo -> so sánh >,< ,=
        String sv1 = "Lê Văn A";
        String sv2 = "Lê Văn B";
        String sv3 = "Lê Văn";
        String sv4 = "Lê Văn a";
        System.out.println(sv1.compareTo(sv2));
        System.out.println(sv1.compareTo(sv3));
        System.out.println(sv1.compareTo(sv4));

        // Hàm compareToIgnoreCase ( không phân biệt hoa thường )
        System.out.println(sv1.compareToIgnoreCase(sv2));
        System.out.println(sv1.compareToIgnoreCase(sv3));
        System.out.println(sv1.compareToIgnoreCase(sv4));

        // Hàm regionMatches -> so sánh một đoạn
        String s1 = "Bolero.vn";
        String s2 = "Vn.rapper";
        boolean check  = s1.regionMatches(7,s2,0,1); //vị tris1, s2, vị trí đầu , vị trí cuối so sánh
        System.out.println(check);
        boolean check1  = s1.regionMatches(true,7,s2,0,1); // không phân việt hoa thường
        System.out.println(check1);

        // Hàm startWith -> hàm kiểu tra chuỗi bắt đầu bằng...(thường dùng kiểm tra sđt hoặc mã)
        String sdt = "0936369999";
        System.out.println(sdt.startsWith("0936"));
        System.out.println(sdt.startsWith("0937"));

        // Hàm endWith -> Hàm kiểm tra chuỗi kết thúc bằng...(thường kiểm tra file)
        String tenFile1 = "onepiece.JPG";
        String tenFile2 = "naruto.PDF";
        if(tenFile1.endsWith(".JPG")){
            System.out.println("file là hình ảnh");
        }else if(tenFile1.endsWith("PDG")){
            System.out.println("file là file PDG ");
        }

        if(tenFile2.endsWith(".JPG")){
            System.out.println("file là hình ảnh");
        }else if(tenFile2.endsWith("PDG")){
            System.out.println("file là file PDG ");
        }



    }
}
