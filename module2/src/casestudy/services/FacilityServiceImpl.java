package casestudy.services;

import casestudy.models.Facility;
import casestudy.models.House;
import casestudy.models.Room;
import casestudy.models.Villa;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService{

    Map<Facility, Integer> facilities = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);
    {
        Villa villa1 = new Villa(01,"villa1",1000,20000,10,"vip","vip",30,20);
        House house1 = new House(01,"house1",1000,20000,10,"vip","vip",30);
        Room room1 = new Room(01,"villa1",1000,20000,10,"vip","buffet");
        facilities.put(villa1,0);
        facilities.put(house1,0);
        facilities.put(room1,0);
    }

    @Override
    public void display() {
        System.out.println("*---List---*");
        for (Map.Entry<Facility, Integer> element : facilities.entrySet()) {
            System.out.println("Service : " + element.getKey().getServiceName());
            System.out.println("Số lần đã thuê : " +element.getValue());
        }

    }

    @Override
    public void displayMaintain() {

    }


    @Override
    public void addNewVilla() {
        System.out.println("*---Enter the Villa---*");
        System.out.println("Enter the ID Villa: ");
        Integer id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the service Name Villa: ");
        String name = sc.nextLine();
        System.out.println("Enter the Area Villa: ");
        Integer area = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental cost Villa: ");
        int costs = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Max Person : ");
        int person = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental Type : ");
        String type = sc.nextLine();
        System.out.println("Enter the room standard : ");
        String room = sc.nextLine();
        System.out.println("Enter the poolArea : ");
        Integer pool = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the num of floors : ");
        int num = Integer.parseInt(sc.nextLine());
        Villa villa = new Villa(id,name,area,costs,person,type,room,pool,num);
        facilities.put(villa,0);
        System.out.println("add thành công");
    }

    @Override
    public void addNewHouse() {
        System.out.println("*---Enter the House---*");
        System.out.println("Enter the ID House : ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the service Name House: ");
        String name = sc.nextLine();
        System.out.println("Enter the Area House: ");
        int area = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental cost House: ");
        int costs = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Max Person House: ");
        int person = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental Type : ");
        String type = sc.nextLine();
        System.out.println("Enter the room standard : ");
        String room = sc.nextLine();
        System.out.println("Enter the num of floors : ");
        int num = Integer.parseInt(sc.nextLine());
        House house = new House(id,name,area,costs,person,type,room,num);
        facilities.put(house,0);
    }

    @Override
    public void addNewRoom() {
        System.out.println("*---Enter the Room---*");
        System.out.println("Enter the ID room : ");
        Integer id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Service Name Room: ");
        String name = sc.nextLine();
        System.out.println("Enter the Area Room: ");
        Integer area = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental cost : ");
        int costs = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Max Person : ");
        int person = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental Type : ");
        String type = sc.nextLine();
        System.out.println("Enter the freeService : ");
        String free = sc.nextLine();
        Room room = new Room(id,name,area,costs,person,type,free);
        facilities.put(room,0);
    }


}
