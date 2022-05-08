package casestudy.services.impl;

import casestudy.models.resort.Facility;
import casestudy.models.resort.House;
import casestudy.models.resort.Room;
import casestudy.models.resort.Villa;
import casestudy.services.inter_face.IFacilityService;
import casestudy.utils.file.ReadAndWriteBuffer;
import casestudy.utils.regex.Regex;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Facility, Integer> facilities = new LinkedHashMap<>();
    private static List<Villa> villas = new ArrayList<>();
    private static List<House> houses = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();
    private static List<Facility> facilityList = new ArrayList<>();
    private static List<Facility> maintenancefacilities = new ArrayList<>();
    private static final String PATH_HOUSE="src/casestudy/data/house.csv";
    private static final String PATH_ROOM ="src/casestudy/data/room.csv";
    private static final String PATH_VILLA="src/casestudy/data/villa.csv";


//    static {
//        Villa villa= new Villa("SVVL-1996", "Villa 1", 500.0, 500, 10, "Day", "Vip", 100.0, 2);
//       Villa villa1 = new Villa("SVVL-1997", "Villa 2", 2000.0, 1000, 30, "Day", "Vip", 400.0, 5);
//        House house=new House("SVHO-1996", "House 1", 500.0, 1000, 30, "Day", "Vip",4);
//        House house1 =new House("SVHO-1997", "House 2", 2000.0, 1000, 30, "Day", "Vip", 2);
//       Room room =new Room("SVRO-1996", "Room 1", 500.0, 1000, 30, "Day","Breakfast");
//        Room room1 =new Room("SVRO-1997", "Room 2", 2000.0, 1000, 30, "Day", "BBQ");
//        houses.add(house); facilityList.add(house); facilities.put(house,5);
//        rooms.add(room); facilityList.add(room); facilities.put(room,0);
//        villas.add(villa); facilityList.add(villa);facilities.put(villa,0);
//        houses.add(house1); facilityList.add(house1);facilities.put(house1,0);
//        rooms.add(room1); facilityList.add(room1);facilities.put(room1,0);
//        villas.add(villa1); facilityList.add(villa1);facilities.put(villa1,0);
//        ReadAndWriteBuffer.writeVilla(PATH_VILLA,villas);
//        ReadAndWriteBuffer.writeHouse(PATH_HOUSE,houses);
//        ReadAndWriteBuffer.writeRoom(PATH_ROOM,rooms);
//    }
    @Override
    public void display() {
        houses = ReadAndWriteBuffer.readHouse();
        rooms = ReadAndWriteBuffer.readRoom();
        villas = ReadAndWriteBuffer.readVilla();

        System.out.println("*---List Facility---*");
        for (Map.Entry<Facility, Integer> element : facilities.entrySet()) {
            System.out.println("- Service : " + element.getKey().getServiceName());
            System.out.println("Số lần đã thuê : " + element.getValue());
        }
    }
    @Override
    public void addNewVilla() {
        villas = ReadAndWriteBuffer.readVilla();
        System.out.println("*---Enter the Villa---*");
        String id = Regex.inputIDVL();
        String name = Regex.inputName();
        Double area = Double.parseDouble( Regex.inputArea());
        int costs = Integer.parseInt( Regex.inputRentalCost());
        int person = Integer.parseInt( Regex.inputMaxPerson());
        String type =  Regex.inputRentalType();
        String room =  Regex.inputRoomStandard();
        Double pool = Double.parseDouble( Regex.inputPoolArea());
        int num = Integer.parseInt( Regex.inputNumOfFloors());
        Facility villa = new Villa(id, name, area, costs, person, type, room, pool, num);
        add(villa);
        System.out.println("Success added!");
        ReadAndWriteBuffer.writeVilla(PATH_VILLA, villas);
    }

    @Override
    public void addNewHouse() {
        houses = ReadAndWriteBuffer.readHouse();
        System.out.println("*---Enter the House---*");
        String id =  Regex.inputIDHO();
        String name =  Regex.inputName();
        Double area = Double.parseDouble( Regex.inputArea());
        int costs = Integer.parseInt( Regex.inputRentalCost());
        int person = Integer.parseInt( Regex.inputMaxPerson());
        String type =  Regex.inputRentalType();
        String room =  Regex.inputRoomStandard();
        int num = Integer.parseInt( Regex.inputNumOfFloors());
        Facility house = new House(id, name, area, costs, person, type, room, num);
        add(house);
        System.out.println("Success added!");
        ReadAndWriteBuffer.writeHouse(PATH_HOUSE, houses);
    }
    @Override
    public void addNewRoom() {
        rooms = ReadAndWriteBuffer.readRoom();
        System.out.println("*---Enter the Room---*");
        String id =  Regex.inputIDRO();
        String name =  Regex.inputName();
        Double area = Double.parseDouble( Regex.inputArea());
        int costs = Integer.parseInt( Regex.inputRentalCost());
        int person = Integer.parseInt( Regex.inputMaxPerson());
        String type =  Regex.inputRentalType();
        String free =  Regex.inputFreeService();
        Facility room = new Room(id, name, area, costs, person, type, free);
        add(room);
        System.out.println("Success added !");
        ReadAndWriteBuffer.writeRoom(PATH_ROOM,rooms);
    }

    @Override
    public void displayMaintain() {
        if(!maintenancefacilities.isEmpty()){
            for (Facility facility: maintenancefacilities) {
                System.out.println(facility);
            }
        }else {
            System.err.println("Maintenance facilities is empty!");
        }
    }

    public static void add(Facility facility) {
        boolean check = true;
        Set<Facility> facilitySet = facilities.keySet();
        if(facilities.isEmpty()){
            facilities.put(facility,1);
        }else {
            for (Facility key: facilitySet) {
                if(facilities.equals(key)){
                    maintenanceCheck(key);
                    facilities.put(key,facilities.get(key)+1);
                    check = false;
                    break;
                }
            }
            if(check){
                facilities.put(facility,1);
            }
        }
    }

    public static void maintenanceCheck(Facility facility) {
        if(facilities.get(facility)>=5){
            System.err.println("Service under maintenance! ");
            maintenancefacilities.add(facility);
            facilities.put(facility,0);
        }
    }
//    public void displayNumberUsedOfService() {
//        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
//            System.out.println("Service: " + entry.getKey().getServiceName());
//            System.out.println("Number of used: " + entry.getValue());
//        }
//    }

    public static List<Facility> getFacilityList() {
        return facilityList;
    }
}
