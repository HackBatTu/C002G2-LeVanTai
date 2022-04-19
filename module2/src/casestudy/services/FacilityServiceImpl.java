package casestudy.services;

import casestudy.models.Facility;
import casestudy.models.House;
import casestudy.models.Room;
import casestudy.models.Villa;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService{
    LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();

    HouseImpl house = new HouseImpl();
    RoomImpl room = new RoomImpl();
    VillaImpl villa = new VillaImpl();

    {
        Villa villa1 = new Villa("villa1",1000,20000,10,"vip","vip",30,20);
        Villa villa2 = new Villa("villa2",500,10000,5,"pro","vip",15,10);
        House house1 = new House("house1",1000,20000,10,"vip","vip",30);
        House house2 = new House("house2",500,10000,5,"pro","vip",15);
        Room room1 = new Room("villa1",1000,20000,10,"vip","buffet");
        Room room2 = new Room("villa2",500,10000,5,"pro","alacarte");
        facilities.put(villa1,0);
        facilities.put(villa2,0);
        facilities.put(house1,0);
        facilities.put(house2,0);
        facilities.put(room1,0);
        facilities.put(room2,0);


    }


    Scanner sc = new Scanner(System.in);
    int choice;
    @Override
    public void add() {
        System.out.println("Enter the Service you want add : ");
        System.out.println("*---Menu add Service---*"+"\n" +
                "1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "0.Back to menu\n");
        choice = Integer.parseInt(sc.nextLine());
        while (true){
            switch (choice){
                case 1:
                    villa.add();
                    break;
                case 2:
                    house.add();
                    break;
                case 3:
                    room.add();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("see you again");
                    break;
            }
        }
    }

    @Override
    public void display() {
        System.out.println("*---List---*");
        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
            System.out.println("Key: " + entry.getKey().getServiceName());
            System.out.println("Value: " + entry.getValue());
        }

    }

    @Override
    public void edit() {

    }
}
