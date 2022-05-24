package Exam.services;

import Exam.models.DienThoaiChinhHang;
import Exam.models.DienThoaiXachTay;
import Exam.models.Mobile;
import Exam.utils.FileService;
import Exam.utils.NotFoundProductException;
import Exam.utils.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MobileXachTayImpl implements IMobieXachTayService{
    List<DienThoaiXachTay> dienThoaiXachTayList = new ArrayList<>();
    private static final String FILE_NAME_XACH_TAY = "E:\\C002G2-LeVanTai-Module2\\test\\src\\Exam\\data\\mobilex.csv";
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        dienThoaiXachTayList = FileService.readMobieXachTay(FILE_NAME_XACH_TAY);
        if (!dienThoaiXachTayList.isEmpty()) {
            for (DienThoaiXachTay mobiex :dienThoaiXachTayList) {
                System.out.println(mobiex);
            }
        } else {
            System.out.println("Student list is empty!");
        }
    }

    @Override
    public void add() {
        dienThoaiXachTayList = FileService.readMobieXachTay(FILE_NAME_XACH_TAY);
        if (dienThoaiXachTayList.isEmpty()) {
            Mobile.setCountID(1);
        } else {
            int max = dienThoaiXachTayList.get(0).getId();
            for (DienThoaiXachTay mobiex : dienThoaiXachTayList) {
                if (mobiex.getId() > max) {
                    max = mobiex.getId();
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
        System.out.print("Nhập  quốc gia: ");
        String quocGia = sc.nextLine();

        String trangThai = menuTrangThai();
        dienThoaiXachTayList.add(new DienThoaiXachTay(Mobile.getCountID(), name.toLowerCase(),gia,num,nhaSX,quocGia,trangThai));
        FileService.writeMobieXachTay(FILE_NAME_XACH_TAY,dienThoaiXachTayList);    }

    @Override
    public void delete() {
        dienThoaiXachTayList = FileService.readMobieXachTay(FILE_NAME_XACH_TAY);
        boolean check = false;
        System.out.println("*---Delete Mobile!!!");
        System.out.println("enter the id want delete");
        Integer idDell = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < dienThoaiXachTayList.size(); i++) {
            if (dienThoaiXachTayList.get(i).getId() == idDell) {
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
                        for (int i = 0; i < dienThoaiXachTayList.size(); i++) {
                            if (dienThoaiXachTayList.get(i).getId()== idDell) {
                                dienThoaiXachTayList.remove(i);
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
            FileService.writeMobieXachTay(FILE_NAME_XACH_TAY,dienThoaiXachTayList);
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
        dienThoaiXachTayList = FileService.readMobieXachTay(FILE_NAME_XACH_TAY);
        boolean check = true;
        while (check){
            System.out.println("nhập tên tìm kiếm");
            String name = sc.nextLine();
            for(int i=0; i< dienThoaiXachTayList.size() ; i++){
                if(dienThoaiXachTayList.get(i).getName().contains(name.toLowerCase())){
                    check = false;
                    break;
                }
            }
            if(!check){
                for(int i=0; i< dienThoaiXachTayList.size() ; i++){
                    if(dienThoaiXachTayList.get(i).getName().contains(name.toLowerCase())){
                        System.out.println(dienThoaiXachTayList.get(i));
                    }
                }
            }else {
                System.out.println("dont find id!");
            }
        }
    }
    public static String menuTrangThai(){
        while (true) {
            System.out.print("*--Trang Thai : " + "\n" +
                    "1.Da sua chua " + "\n" +
                    "2.Chua sua chua " + "\n" +
                    "you choice: ");
            int choice = Regex.checkParseInt();
            switch (choice) {
                case 1:
                    return "Da sua chua";
                case 2:
                    return "Chua sua chua";
                default:
                    System.out.println("Re choice: ");
                    break;
            }
        }
    }
}
