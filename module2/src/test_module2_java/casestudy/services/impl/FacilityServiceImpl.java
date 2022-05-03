package test_module2_java.casestudy.services.impl;

import test_module2_java.casestudy.models.resort.Facility;
import test_module2_java.casestudy.models.resort.House;
import test_module2_java.casestudy.models.resort.Room;
import test_module2_java.casestudy.models.resort.Villa;
import test_module2_java.casestudy.services.inter_face.IFacilityService;
import test_module2_java.casestudy.utils.file.ReadAndWriteBuffer;
import test_module2_java.casestudy.utils.regex.Regex;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Facility, Integer> facilities = new LinkedHashMap<>();
    private static List<Villa> villas = new ArrayList<>();
    private static List<House> houses = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();
    private static List<Facility> facilityList = new ArrayList<>();
    private static List<Facility> maintenancefacilities = new ArrayList<>();
    private static final String PATH_HOUSE="src/test_module2_java/casestudy/data/house.csv";
    private static final String PATH_ROOM ="src/test_module2_java/casestudy/data/room.csv";
    private static final String PATH_VILLA="src/test_module2_java/casestudy/data/villa.csv";


    static {
        Villa villa= new Villa("SVVL-1996", "Villa 1", 500, 500, 10, "Day", "Vip", 100, 2);
       Villa villa1 = new Villa("SVVL-1997", "Villa 2", 2000, 1000, 30, "Day", "Vip", 400, 5);
        House house=new House("SVHO-1996", "House 1", 500, 1000, 30, "Day", "Vip",4);
        House house1 =new House("SVHO-1997", "House 2", 2000, 1000, 30, "Day", "Vip", 2);
       Room room =new Room("SVRO-1996", "Room 1", 500, 1000, 30, "Day","Breakfast");
        Room room1 =new Room("SVRO-1997", "Room 2", 2000, 1000, 30, "Day", "BBQ");
        houses.add(house); facilityList.add(house); facilities.put(house,1);
        rooms.add(room); facilityList.add(room); facilities.put(room,1);
        villas.add(villa); facilityList.add(villa);facilities.put(villa,1);
        houses.add(house1); facilityList.add(house1);facilities.put(house1,1);
        rooms.add(room1); facilityList.add(room1);facilities.put(room1,1);
        villas.add(villa1); facilityList.add(villa1);facilities.put(villa1,1);
        ReadAndWriteBuffer.writeVilla(PATH_VILLA,villas);
        ReadAndWriteBuffer.writeHouse(PATH_HOUSE,houses);
        ReadAndWriteBuffer.writeRoom(PATH_ROOM,rooms);
    }
    @Override
    public void display() {
        System.out.println("*---List---*");
        for (Map.Entry<Facility, Integer> element : facilities.entrySet()) {
            System.out.println("Service : " + element.getKey().getServiceName());
            System.out.println("Số lần đã thuê : " + element.getValue());
        }

    }

    @Override
    public void add(Facility facility) {
        Set<Facility> facilityKey = facilities.keySet();

        if (facilities.isEmpty()) {
            facilities.put(facility, 1);
        } else {
            boolean flag = true;
            for (Facility key : facilityKey) {
                if (facility.equals(key)) {
                    maintenanceCheck(key);
                    facilities.put(key, facilities.get(key) + 1);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                facilities.put(facility, 1);
            }
        }
    }
    @Override
    public void displayMaintain() {
        if (!maintenancefacilities.isEmpty()) {
            for (Facility facility : maintenancefacilities) {
                System.out.println(facility);
            }
        } else {
            System.err.println("Maintenance facilities is empty!");
        }
    }

    @Override
    public void displayNumberUsedOfService() {
        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
            System.out.println("Service: " + entry.getKey().getServiceName());
            System.out.println("Number of used: " + entry.getValue());
        }
    }

    @Override
    public void maintenanceCheck(Facility facility) {
        if (facilities.get(facility) >= 5) {
            System.err.println("Service is under maintenance!");
            maintenancefacilities.add(facility);
            facilities.put(facility, 0);
        }
    }

    public static List<Facility> getFacilityList() {
        return facilityList;
    }


    @Override
    public void addNewVilla() {
        System.out.println("*---Enter the Villa---*");
        String id = Regex.inputIDVL();
        String name = Regex.inputName();
        Integer area = Integer.parseInt( Regex.inputArea());
        int costs = Integer.parseInt( Regex.inputRentalCost());
        int person = Integer.parseInt( Regex.inputMaxPerson());
        String type =  Regex.inputRentalType();
        String room =  Regex.inputRoomStandard();
        Integer pool = Integer.parseInt( Regex.inputPoolArea());
        int num = Integer.parseInt( Regex.inputNumOfFloors());
        Facility villa = new Villa(id, name, area, costs, person, type, room, pool, num);
        this.add(villa);
        System.out.println("add thành công!");
        ReadAndWriteBuffer.writeVilla(PATH_VILLA, villas);
    }

    @Override
    public void addNewHouse() {
        System.out.println("*---Enter the House---*");
        String id =  Regex.inputIDHO();
        String name =  Regex.inputName();
        Integer area = Integer.parseInt( Regex.inputArea());
        int costs = Integer.parseInt( Regex.inputRentalCost());
        int person = Integer.parseInt( Regex.inputMaxPerson());
        String type =  Regex.inputRentalType();
        String room =  Regex.inputRoomStandard();
        int num = Integer.parseInt( Regex.inputNumOfFloors());
        Facility house = new House(id, name, area, costs, person, type, room, num);
        this.add(house);
        System.out.println("add thành công!");
        ReadAndWriteBuffer.writeHouse(PATH_HOUSE, houses);
    }

    @Override
    public void addNewRoom() {
        System.out.println("*---Enter the Room---*");
        String id =  Regex.inputIDRO();
        String name =  Regex.inputName();
        Integer area = Integer.parseInt( Regex.inputArea());
        int costs = Integer.parseInt( Regex.inputRentalCost());
        int person = Integer.parseInt( Regex.inputMaxPerson());
        String type =  Regex.inputRentalType();
        String free =  Regex.inputFreeService();
        Facility room = new Room(id, name, area, costs, person, type, free);
        this.add(room);
        System.out.println("add thành công!");
        ReadAndWriteBuffer.writeRoom(PATH_ROOM,rooms);
    }

}
