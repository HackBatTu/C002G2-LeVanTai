package casestudy.services;

import casestudy.models.House;
import casestudy.models.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomImpl {
    List<Room> rooms = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    //    String serviceName, Double area, Integer rentalCosts, Integer maxPerson, String rentalType, String freeService
    public void add(){
        System.out.println("*---Enter the Room---*");
        System.out.println("Enter the Service Name : ");
        String name = sc.nextLine();
        System.out.println("Enter the Area : ");
        Integer area = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental cost : ");
        int costs = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Max Person : ");
        int person = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental Type : ");
        String type = sc.nextLine();
        System.out.println("Enter the freeService : ");
        String free = sc.nextLine();
        Room room = new Room(name,area,costs,person,type,free);
        rooms.add(room);
    }
}
