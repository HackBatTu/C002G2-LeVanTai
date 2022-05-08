package Product.service;

import Product.models.*;
import Product.utils.ReadAndWrite;

import java.sql.SQLOutput;
import java.util.*;

public class TransportImpl {
    private static final String FILE_OTO ="src/Product/data/oto.csv";
    private static final String FILE_MOTO ="src/Product/data/moto.csv";
    private static final String FILE_TRUCK ="src/Product/data/truck.csv";
    private static Scanner sc = new Scanner(System.in);
    private static List<Transport> transports = new ArrayList<>();
    private static List<Oto> otoList = new ArrayList<>();
    private static List<Moto> motoList = new ArrayList<>();
    private static List<Truck> truckList = new ArrayList<>();
    private static List<Manufacturer> manufacturerList = new ArrayList<>();
    static {
        transports.add(new Oto("43.12", "Dong lao", "1990", "Hoàn", "19", "đen"));
        transports.add(new Moto("43.123", "Dong lao", "1990", "Hoàn", "19000"));
        transports.add(new Truck("43.1234", "Dong lao", "1990", "Hoàn", "20000"));
        manufacturerList.add(new Manufacturer("1","Vinfast","Vietnames"));
        manufacturerList.add(new Manufacturer("2","Đông lào","Vietnames"));
        manufacturerList.add(new Manufacturer("3","36","Vietnames"));
    }
    public void addNewOto(){
        otoList = ReadAndWrite.readOto();
        System.out.println("Add list Oto: ");
        System.out.println("enter the bks : ");
        String bks = sc.nextLine();
        System.out.println("enter the hãng sản xuất : ");
        String hangsx = sc.nextLine();
        System.out.println("enter the year : ");
        String year = sc.nextLine();
        System.out.println("enter the Owner: ");
        String owner = sc.nextLine();
        System.out.println("enter the seats: ");
        String seats = sc.nextLine();
        System.out.println("enter the type: ");
        String type = sc.nextLine();
        otoList.add(new Oto(bks,hangsx,year,owner,seats,type));
        ReadAndWrite.writeOto(FILE_OTO,otoList);
    }
    public void addNewMoto(){
        motoList = ReadAndWrite.readMoto();
        System.out.println("Add list Moto: ");
        System.out.println("enter the bks : ");
        String bks = sc.nextLine();
        System.out.println("enter the hãng sản xuất : ");
        String hangsx = sc.nextLine();
        System.out.println("enter the year : ");
        String year = sc.nextLine();
        System.out.println("enter the Owner: ");
        String owner = sc.nextLine();
        System.out.println("enter the wattage: ");
        String wattage = sc.nextLine();
        motoList.add(new Moto(bks,hangsx,year,owner,wattage));
        ReadAndWrite.writeMoto(FILE_MOTO,motoList);
    }
    public void addNewTruck(){
        truckList = ReadAndWrite.readTruck();
        System.out.println("Add list Truck: ");
        System.out.println("enter the bks : ");
        String bks = sc.nextLine();
        System.out.println("enter the hãng sản xuất : ");
        String hangsx = sc.nextLine();
        System.out.println("enter the year : ");
        String year = sc.nextLine();
        System.out.println("enter the Owner: ");
        String owner = sc.nextLine();
        System.out.println("enter the tonnage: ");
        String tonnage = sc.nextLine();
        truckList.add(new Truck(bks,hangsx,year,owner,tonnage));
        ReadAndWrite.writeTruck(FILE_TRUCK,truckList);
    }
    public void displayOto(){
        for (Transport x: transports) {
            if(x instanceof Oto){
                System.out.println(x);
            }
        }
    }
    public void displayMoto(){
        for (Transport x: transports) {
            if(x instanceof Moto){
                System.out.println(x);
            }
        }
    }
    public void displayTruck(){
        for (Transport x: transports) {
            if(x instanceof Truck){
                System.out.println(x);
            }
        }
    }
    public void displayTransport(){
        for (Transport x: transports) {
            System.out.println(x);
        }
    }


}
