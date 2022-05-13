package Exam.services;

import Exam.models.DienThoaiChinhHang;
import Exam.models.Mobile;
import Exam.utils.FileService;
import Exam.utils.Regex;
import Exam.utils.NotFoundProductException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobileChinhHangImpl implements IMobieChinhHangService{
    List<DienThoaiChinhHang> dienThoaiChinhHangs = new ArrayList<>();
    private static final String FILE_NAME_CHINH_HANG = "E:\\C002G2-LeVanTai-Module2\\test\\src\\Exam\\data\\mobilec.csv";
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        dienThoaiChinhHangs = FileService.readMobileChinhHang(FILE_NAME_CHINH_HANG);
        if (!dienThoaiChinhHangs.isEmpty()) {
            for (DienThoaiChinhHang mobiec : dienThoaiChinhHangs) {
                System.out.println(mobiec);
            }
        } else {
            System.out.println("Mobie list is empty!");
        }
    }

    @Override
    public void add() {
        dienThoaiChinhHangs = FileService.readMobileChinhHang(FILE_NAME_CHINH_HANG);

        if (dienThoaiChinhHangs.isEmpty()) {
            Mobile.setCountID(1);
        } else {
            int max = dienThoaiChinhHangs.get(0).getId();
            for (DienThoaiChinhHang mobiec : dienThoaiChinhHangs) {
                if (mobiec.getId() > max) {
                    max = mobiec.getId();
                }
            }
            Mobile.setCountID(max);
            if (Mobile.getCountID() == null) {
                Mobile.setCountID(1);
            } else {
                Mobile.setCountID(Mobile.getCountID() + 1);
            }
        }
        System.out.print("Enter the Name: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá bán :");
        String gia = Regex.inputInt();
        System.out.print("Nhập số lượng: ");
        String num = Regex.inputInt();
        System.out.print("Nhập nhà sản xuất");
        String nhaSX = sc.nextLine();

        String thoiGian = Regex.inputYear();

        String phamVi = menuPhamVi();
        dienThoaiChinhHangs.add(new DienThoaiChinhHang(Mobile.getCountID(), name,gia,num,nhaSX,thoiGian,phamVi));
        FileService.writeMobileChinhHang(FILE_NAME_CHINH_HANG,dienThoaiChinhHangs);
    }

    @Override
    public void delete() {
        dienThoaiChinhHangs = FileService.readMobileChinhHang(FILE_NAME_CHINH_HANG);
        boolean check = false;
        System.out.println("*---Delete Mobile!!!");
        System.out.println("enter the id want delete");
        Integer idDell = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < dienThoaiChinhHangs.size(); i++) {
            if (dienThoaiChinhHangs.get(i).getId() == idDell) {
                check = true;
                break;
            }
        }
        if (check) {
            while (check) {
                System.out.print("you want delete mobile: \n" +
                        "1.yes"+"\n"+
                        "2.no\n"+
                        "you choice : ");
                int choice = Regex.checkParseInt();
                switch (choice){
                    case 1:
                        for (int i = 0; i < dienThoaiChinhHangs.size(); i++) {
                            if (dienThoaiChinhHangs.get(i).getId()== idDell) {
                                dienThoaiChinhHangs.remove(i);
                                break;
                            }
                        }
                        System.out.println("***Deleted!!!");
                        check = false;
                        break;
                    case 2:
                        System.out.println("no");
                        check = false;
                        break;
                    default:
                        System.out.println("Re- choice: ");
                }
            }
            FileService.writeMobileChinhHang(FILE_NAME_CHINH_HANG,dienThoaiChinhHangs);
        }else {
            try {
                throw new NotFoundProductException("ID điện thoại không tồn tại");
            } catch (NotFoundProductException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void search() {
        dienThoaiChinhHangs = FileService.readMobileChinhHang(FILE_NAME_CHINH_HANG);
        boolean check = true;
        while (check){
            System.out.println("nhập tên tìm kiếm");
            String name = sc.nextLine();
            for(int i=0; i< dienThoaiChinhHangs.size() ; i++){
                if(dienThoaiChinhHangs.get(i).getName().contains(name)){
                    check = false;
                    break;
                }
            }
            if(!check){
                for(int i=0; i< dienThoaiChinhHangs.size() ; i++){
                    if(dienThoaiChinhHangs.get(i).getName().contains(name)){
                        System.out.println(dienThoaiChinhHangs.get(i));
                    }
                }
            }else {
                System.out.println("dont find id!");
            }
        }
    }
    public static String menuPhamVi(){
        while (true) {
            System.out.print("*--Phạm vi : " + "\n" +
                    "1.Toan Quoc " + "\n" +
                    "2.Quoc Te  " + "\n" +
                    "you choice: ");
            int choice = Regex.checkParseInt();
            switch (choice) {
                case 1:
                    return "Toan Quoc";
                case 2:
                    return "Quoc Te";
                default:
                    System.out.println("Re choice: ");
                    break;
            }
        }
    }

}
