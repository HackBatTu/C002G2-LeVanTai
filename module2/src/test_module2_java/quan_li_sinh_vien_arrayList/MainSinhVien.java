package test_module2_java.quan_li_sinh_vien_arrayList;

import java.util.Scanner;

public class MainSinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListSinhVien list = new ListSinhVien();
        int choice =0;
        do{
            System.out.println("Menu : "+"\n"+
                    "---Vui lòng chọn chức năng ---"+"\n"+
                    "1. Add Student ."+"\n"+
                    "2. In ra màn hình ."+"\n"+
                    "3. Kiểm tra rỗng ."+"\n"+
                    "4. Số lượng sv."+"\n"+
                    "5. Làm rỗng list"+"\n"+
                    "6. Kiểm tra SV có tồn tại,dựa trên mãSV."+"\n"+
                    "7. Delete Student" +"\n"+
                    "8. Tìm kiếm student dựa trên Tên nhập từ bàn phím" +"\n"+
                    "9. In ra student có điểm từ cao đến thấp" +"\n"+
                    "0. Exit");
            System.out.print("lựa chọn của bạn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 :
                    System.out.print("Enter the Mã Sv: ");
                    String maSv = sc.nextLine();
                    System.out.print("Enter the tên: ");
                    String name = sc.nextLine();
                    System.out.print("Enter the year: ");
                    int namSinh = sc.nextInt();
                    System.out.print("Enter the diemTB: ");
                    double diemTB = sc.nextDouble();
                    SinhVien sv = new SinhVien(maSv,name,namSinh,diemTB);
                    list.add(sv);
                    break;
                case 2:
                    list.inList(); // in ds
                    break;
                case 3:
                    System.out.println("Kt list rỗng : " + list.kTListRong());
                    break;
                case 4:
                    System.out.println("số lượng sinh viên hiện tại : "+ list.length());
                    break;
                case 5:
                    list.lmRong();
                    break;
                case 6:
                    System.out.print("Enter the maSv: "); String maSV = sc.nextLine();
                    SinhVien sv1 = new SinhVien(maSV);
                    System.out.println("Kiểm tra sv có trong list: "+ list.kTTonTai(sv1));
                    break;
                case 7:
                    System.out.print("Enter the maSv: ");
                    String maSV1 = sc.nextLine();
                    SinhVien sv2 = new SinhVien(maSV1);
                    System.out.println("Xóa Sinh Viên : "+ list.deleteSV(sv2));
                    break;
//                case 8:
//                    System.out.println("Enter the name : "); String name = sc.nextLine();
//                    System.out.println("Kết quả tìm kiếm: "+ list.findSV(name));
//
//                    break;
                case 9:
                    list.sapXep();
                    list.inList();
                    break;
                case 0 :
                    System.out.println(" bạn đã thoát .");
            }
        }while (choice !=0);
    }
}
