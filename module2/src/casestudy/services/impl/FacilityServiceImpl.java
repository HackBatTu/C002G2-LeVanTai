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

    private static List<Facility> facilityList = new ArrayList<>();
    private static List<Facility> maintenancefacilities = new ArrayList<>();

    public static final String REGEX_ID_VL = "^(SVVL)\\-[0-9]{4}$";
    public static final String REGEX_ID_HO = "^(SVHO)-[0-9]{4}$";
    public static final String REGEX_ID_RO = "^(SVRO)[-][0-9]{4}$";
    public static final String REGEX_NAME = "^[A-Z][a-z0-9]+$";
    public static final String REGEX_PERSON = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_AREA = "^(3-9)\\d|([1-9]\\d{1,})$";
    public static final String REGEX_INT = "^(1-9)|([1][0-9])$";


    static {
        facilities.put(new Villa("1", "Villa 1", 500, 500, 10, "Day", "Vip", 100, 2), 0);
        facilities.put(new Villa("2", "Villa 2", 2000, 1000, 30, "Day", "Vip", 400, 5), 0);
        ReadAndWriteBuffer.writeFile(facilityList,"src/casestudy/data/villa.csv");
    }
    static {
        facilities.put(new House("3", "House 1", 500, 1000, 30, "Day", "Vip", 4), 0);
        facilities.put(new House("4", "House", 2000, 1000, 30, "Day", "Vip", 2), 0);
        ReadAndWriteBuffer.writeFile(facilityList,"src/casestudy/data/house.csv");
    }
    static {
        facilities.put(new Room("5", "Room 1", 500, 1000, 30, "Day", "Breakfast"), 0);
        facilities.put(new Room("6", "Room 2", 2000, 1000, 30, "Day", "BBQ"), 0);
        ReadAndWriteBuffer.writeFile(facilityList,"src/casestudy/data/room.csv");
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
    public void display() {
        System.out.println("*---List---*");
        for (Map.Entry<Facility, Integer> element : facilities.entrySet()) {
            System.out.println("Service : " + element.getKey().getServiceName());
            System.out.println("Số lần đã thuê : " + element.getValue());
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
        String id = inputIDVL();
        String name = inputName();
        Integer area = Integer.parseInt(inputArea());
        int costs = Integer.parseInt(inputRentalCost());
        int person = Integer.parseInt(inputMaxPerson());
        String type = inputRentalType();
        String room = inputRoomStandard();
        Integer pool = Integer.parseInt(inputPoolArea());
        int num = Integer.parseInt(inputNumOfFloors());
        Facility villa = new Villa(id, name, area, costs, person, type, room, pool, num);
        this.add(villa);
        System.out.println("add thành công");
        ReadAndWriteBuffer.writeFile(facilityList,"src/casestudy/data/villa.csv");

    }

    @Override
    public void addNewHouse() {
        System.out.println("*---Enter the House---*");
        String id = inputIDHO();
        String name = inputName();
        Integer area = Integer.parseInt(inputArea());
        int costs = Integer.parseInt(inputRentalCost());
        int person = Integer.parseInt(inputMaxPerson());
        String type = inputRentalType();
        String room = inputRoomStandard();
        int num = Integer.parseInt(inputNumOfFloors());
        Facility house = new House(id, name, area, costs, person, type, room, num);
        this.add(house);
        ReadAndWriteBuffer.writeFile(facilityList,"src/casestudy/data/house.csv");
    }

    @Override
    public void addNewRoom() {
        System.out.println("*---Enter the Room---*");
        String id = inputIDRO();
        String name = inputName();
        Integer area = Integer.parseInt(inputArea());
        int costs = Integer.parseInt(inputRentalCost());
        int person = Integer.parseInt(inputMaxPerson());
        String type = inputRentalType();
        String free = inputFreeService();
        Facility room = new Room(id, name, area, costs, person, type, free);
        this.add(room);
        ReadAndWriteBuffer.writeFile(facilityList,"src/casestudy/data/room.csv");
    }

    public String inputIDVL(){
        System.out.println("Enter the ID Villa: ");
        return Regex.regex(sc.nextLine(), REGEX_ID_VL, "nhập sai định dạng phải có dạng SVVL-XXXX");
    }
    public String inputIDHO(){
        System.out.println("Enter the ID House: ");
        return Regex.regex(sc.nextLine(), REGEX_ID_HO, "nhập sai định dạng phải có dạng SVHO-XXXX");
    }
    public String inputIDRO(){
        System.out.println("Enter the ID Room: ");
        return Regex.regex(sc.nextLine(), REGEX_ID_RO, "nhập sai định dạng phải có dạng SVRO-XXXX");
    }
    public String inputName(){
        System.out.println("Enter the service Name Villa: ");
        return Regex.regex(sc.nextLine(), REGEX_NAME, "nhập sai định dạng phải có chữ hoa đầu");
    }
    public  String inputArea(){
        System.out.println("Enter the Area House : ");
        return Regex.regex(sc.nextLine(), REGEX_AREA, "Area >30m2");

    }
    public  String inputRentalCost(){
        System.out.println("Enter the rental cost House: ");
        return Regex.regex(sc.nextLine(), REGEX_INT, "nhập sai định dạng giá là số dương");
    }
    public  String inputMaxPerson(){
        System.out.println("Enter the Max Person : ");
        return Regex.regex(sc.nextLine(), REGEX_PERSON, "nhập sai định dạng phải lớn 1 nhỏ hơn 20");
    }
    public  String inputRentalType(){
        System.out.println("Enter the rental Type House: ");
        return Regex.regex(sc.nextLine(), REGEX_NAME, "nhập sai định dạng phải có chữ hoa đầu");
    }
    public  String inputRoomStandard(){
        System.out.println("Enter the room standard House: ");
        return Regex.regex(sc.nextLine(), REGEX_NAME, "nhập sai định dạng phải có chữ hoa đầu");
    }
    public  String inputPoolArea(){
        System.out.println("Enter the poolArea : ");
        return Regex.regex(sc.nextLine(), REGEX_AREA, "Area >30m2");
    }
    public  String inputNumOfFloors(){
        System.out.println("Enter the num of floors : ");
        return Regex.regex(sc.nextLine(), REGEX_INT, "nhập sai định dạng giá là số dương");
    }
    public  String inputFreeService(){
        System.out.println("Enter the rental Type House: ");
        return Regex.regex(sc.nextLine(), REGEX_NAME, "nhập sai định dạng phải có chữ hoa đầu");
    }

}
