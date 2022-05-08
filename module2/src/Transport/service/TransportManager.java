package Transport.service;


import Transport.model.*;
import Transport.service.IService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportManager implements IService {
    List<Transport> transport = new ArrayList<>();
    {
        HangSanXuat hangSanXuat1 = new HangSanXuat(1, "VinFast", "VN");
        HangSanXuat hangSanXuat2 = new HangSanXuat(2, "VinFast1", "Lào");
        HangSanXuat hangSanXuat3 = new HangSanXuat(3, "VinFast2", "Thái");

        Transport car1 = new Car("x1", hangSanXuat1, 2020, "Yasou", 1, "hasaghi");
        Transport car2 = new Car("x2", hangSanXuat2, 2020, "jone", 1, "hasaghiiiii");
        Transport moto1 = new Motorcycle("x01", hangSanXuat1, 2020, "lucian", 150);
        Transport moto2 = new Motorcycle("x02", hangSanXuat3, 2020, "jana", 175);
        Transport truck1 = new Truck("x001", hangSanXuat2, 2020, "victor", 1000);
        Transport truck2 = new Truck("x002", hangSanXuat2, 2020, "oriana", 2000);

        transport.add(car1);
        transport.add(car2);
        transport.add(moto1);
        transport.add(moto2);
        transport.add(truck1);
        transport.add(truck2); }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("*****Add new Car : ");
                    Transport newCar = new Car();
                    newCar.input();
                    transport.add(newCar);
                    break;
                case 2:
                    System.out.println("*****Add new Moto : ");
                    Transport newMoto = new Motorcycle();
                    newMoto.input();
                    transport.add(newMoto);
                    break;
                case 3:
                    System.out.println("*****Add new Truck : ");
                    Transport newTruck = new Truck();
                    newTruck.input();
                    transport.add(newTruck);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("****Vui lòng nhập lại : ");
                    break;
            }

        }while(true);
    }

    @Override
    public void display() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("****** Car :");
                    for (Transport x : transport) {
                        if (x instanceof Car) {
                            System.out.println(x);
                        }
                    }
                    break;
                case 2:
                    System.out.println("******* Moto :");
                    for (Transport x : transport) {
                        if (x instanceof Motorcycle) {
                            System.out.println(x);
                        }
                    }
                    break;
                case 3:
                    System.out.println("******* Truck :");
                    for (Transport x : transport) {
                        if (x instanceof Truck) {
                            System.out.println(x);
                        }
                    }
                    break;
                case 4:
                    System.out.println("**** List Transport: ");
                    for (Transport x : transport){
                        System.out.println(x);
                    }
                case 0:
                   return;
                default:
                    System.out.println("****Nhập lại.");
                    break;
            }
        }while(true);
    }

    @Override
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***Delete Transport !!!!");
        System.out.print("***Enter bks delete: ");
        String bks = sc.nextLine();
        boolean flag = false;
        int choice;
        for (int i = 0; i < transport.size(); i++) {
            if (bks.equalsIgnoreCase(transport.get(i).getBienKiemSoat())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            do {
                System.out.println("Do you choice want delete: " + bks + "?");
                System.out.println("1. Yes" + "\n" +
                        "2. No");
                System.out.print("You choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        for (int i = 0; i < transport.size(); i++) {
                            if (bks.equalsIgnoreCase(transport.get(i).getBienKiemSoat())) {
                                transport.remove(i);
                                break;
                            }
                        }
                        System.out.println("***Yes Delete");
                        flag = false;
                        break;
                    case 2:
                        System.out.println("***No Delete");
                        flag = false;
                        break;
                    default:
                        System.out.println("****chọn lại");
                        break;
                }
            } while (flag);
        } else {
            System.out.println("***biển: "+bks + "không tìm thấy");
        }
    }


    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.print("Enter bks: ");
        String bks = sc.nextLine();

        for (int i = 0; i < transport.size(); i++) {
            if (transport.get(i).getBienKiemSoat().contains(bks)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("find: ");
            for (int i = 0; i < transport.size(); i++) {
                if (transport.get(i).getBienKiemSoat().contains(bks)) {
                    System.out.println(transport.get(i));
                }
            }
        } else {
            System.out.println(bks + " không tìm thấy ");
        }

    }
}
