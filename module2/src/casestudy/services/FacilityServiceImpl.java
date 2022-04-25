package casestudy.services;

import casestudy.models.Facility;
import casestudy.models.House;
import casestudy.models.Room;
import casestudy.models.Villa;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService{
    private static Scanner sc = new Scanner(System.in);
    private static Map<Facility, Integer> facilities = new LinkedHashMap<>();
    private static List<Facility> facilityList = new ArrayList<>();
    private static List<Facility> maintenancefacilities = new ArrayList<>();
    {
        facilities.put(new Villa(1, "Villa 1", 1000, 500, 10, "Day", "Vip", 100, 2), 0);
        facilities.put(new Villa(2, "Villa 2", 2000, 1000, 30, "Day", "Vip", 400, 5), 0);
//        Integer id,String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType, String roomStandard, Integer numberOfFloors
        facilities.put(new House(3, "House 1", 2000, 1000, 30, "Day", "Vip",4), 0);
        facilities.put(new House(4, "House", 2000, 1000, 30, "Day", "Vip", 2), 0);
//        Integer id,String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType, String freeService
        facilities.put(new Room(5, "Room 1", 2000, 1000, 30, "Day","Breakfast"), 0);
        facilities.put(new Room(6, "Room 2", 2000, 1000, 30, "Day", "BBQ"), 0);

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
        for (Facility facility : maintenancefacilities) {
            System.out.println(facility);
        }
    }

    @Override
    public void displayNumberUsedOfService() {
        for (Map.Entry<Facility,Integer> entry: facilities.entrySet()) {
            System.out.println("Service: " + entry.getKey().getServiceName());
            System.out.println("Number of used: " + entry.getValue());
        }
    }

    @Override
    public void maintenanceCheck(Facility facility) {
        if (facilities.get(facility) >= 5) {
            System.out.println("Service is under maintenance!");
            maintenancefacilities.add(facility);
            facilities.put(facility, 0);
        }
    }
    public static List<Facility> getFacilities() {
        return facilityList;
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
