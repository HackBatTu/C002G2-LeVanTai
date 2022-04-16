package Transport;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportManager {
    List<Transport> transport;
    Scanner sc = new Scanner(System.in);

    public TransportManager(){
        transport =  new ArrayList<Transport>();
    }

    public void add(){
        System.out.println("enter the BKS : ");
        String bKS = sc.nextLine();

        System.out.println("Enter the mã : ");
        int  ma = Integer.parseInt(sc.nextLine());
        System.out.println("enter the tên Hãng: ");
        String hang = sc.nextLine();
        System.out.println("enter the tên quốc gia: ");
        String nameQG = sc.nextLine();
        HangSanXuat hangSanXuat = new HangSanXuat(ma,hang,nameQG);

        System.out.println("Enter the Năm SX : ");
        int namSx= Integer.parseInt(sc.nextLine());
        System.out.println("Enter name chủ : ");
        String nameChu = sc.nextLine();


    }


    public void display(){
        this.transport.stream().forEach(o -> System.out.println(o.toString()));
    }
    public void delete(){
        this.transport.remove(transport);
    }
    public void searchBKS(){

//        this.transportFathers.stream().filter(o -> o.bienKiemSoat.equals(bKS)).findAny().ifPresent( o-> System.out.println(o.toString()),null);
    }

}
