package test_module2_java.quan_li_sinh_vien_arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ListSinhVien {
    private ArrayList<SinhVien> list;


    public ListSinhVien() {
        this.list = new ArrayList<SinhVien>();
    }


    public ListSinhVien(ArrayList<SinhVien> list) {
        this.list = list;
    }
// 1.thêm danh sách sinh viên
    public void  add(SinhVien sv){
        this.list.add(sv);
    }
// 2.in danh sách
    public void inList(){
        for (SinhVien sv : list) {
            System.out.println(sv);
        }
    }
    // 3.kiểm tra rỗng
    public boolean kTListRong(){
        return this.list.isEmpty();
    }
    // 4.lấy ra số lượng sinh viên
    public int length(){
        return this.list.size();
    }
    // 5.làm rỗng ds( xóa tất cả)
    public void lmRong(){
        this.list.removeAll(list);
    }
    // 6.Kiểm tra tồn tại
    public boolean kTTonTai(SinhVien sv){
        return this.list.contains(sv);
    }
    // 7.xóa sv ra khỏi danh sách
    public boolean deleteSV(SinhVien sv){
        return this.list.remove(sv);
    }
//     8.tìm sv dựa theo tên
//    public boolean findSV(SinhVien name){
//        for (SinhVien sv: list){
//            if(sv.getName().indexOf(name))>=0){
//                System.out.println(sv);
//            }
//        }
//    }
    // 9. in ra sv điểm cao- thấp
    public void sapXep(){
        Collections.sort(this.list, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                if(sv1.getDiemTB()<sv2.getDiemTB()){
                    return -1;
                }else if(sv1.getDiemTB()>sv2.getDiemTB()){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
    }
}
