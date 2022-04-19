package casestudy.services;

import casestudy.models.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseImpl {
    List<House> houses = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
//    String serviceName, Double area, Integer rentalCosts, Integer maxPerson, String rentalType, String roomStandard, Integer numberOfFloors
    public void add(){
        System.out.println("*---Enter the House---*");
        System.out.println("Enter the service Name : ");
        String name = sc.nextLine();
        System.out.println("Enter the Area : ");
        int area = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental cost : ");
        int costs = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Max Person : ");
        int person = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental Type : ");
        String type = sc.nextLine();
        System.out.println("Enter the room standard : ");
        String room = sc.nextLine();
        System.out.println("Enter the num of floors : ");
        int num = Integer.parseInt(sc.nextLine());
        House house = new House(name,area,costs,person,type,room,num);
        houses.add(house);
    }
}
