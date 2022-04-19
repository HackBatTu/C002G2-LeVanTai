package casestudy.services;

import casestudy.models.House;
import casestudy.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VillaImpl {
    List<Villa> villas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
//    String serviceName, Double area, Integer rentalCosts, Integer maxPerson, String rentalType, String roomStandard, Double poolArea, Integer numberOfFloors
    public void add(){
        System.out.println("*---Enter the Villa---*");
        System.out.println("Enter the service Name : ");
        String name = sc.nextLine();
        System.out.println("Enter the Area : ");
        Integer area = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the rental cost : ");
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
        Villa villa = new Villa(name,area,costs,person,type,room,pool,num);
        villas.add(villa);


    }
}
