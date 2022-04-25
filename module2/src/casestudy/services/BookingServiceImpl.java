package casestudy.services;

import casestudy.models.*;
import casestudy.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    static Scanner sc = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    //    (String name, String date, String gender, Integer idCard, String phone, String email, Integer customerID, String customerType, String address
    static {
        customerList.add(new Customer("Hoàn", "01/01/2001", "male", 1001, "01234", "Hoan@gmail.com", 1, "Vip", "xó núi"));
        customerList.add(new Customer("Luận", "01/01/2002", "male", 1001, "01234", "Luan@gmail.com", 2, "Vip", "xó núi"));
        customerList.add(new Customer("Phương", "01/02/2003", "male", 1002, "012345", "phuong@gmail.com", 3, "Normal", "xó núi"));
//public Villa(String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType, String roomStandard, Integer poolArea, Integer numberOfFloors)
        facilityIntegerMap.put(new Villa(1, "Villa 1", 1000, 500, 10, "Day", "Vip", 100, 2), 0);
        facilityIntegerMap.put(new Villa(2, "Villa 2", 2000, 1000, 30, "Day", "Vip", 400, 5), 0);
//        Integer id,String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType, String roomStandard, Integer numberOfFloors
        facilityIntegerMap.put(new House(3, "House 1", 2000, 1000, 30, "Day", "Vip",4), 0);
        facilityIntegerMap.put(new House(4, "House", 2000, 1000, 30, "Day", "Vip", 2), 0);
//        Integer id,String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType, String freeService
        facilityIntegerMap.put(new Room(5, "Room 1", 2000, 1000, 30, "Day","Breakfirst"), 0);
        facilityIntegerMap.put(new Room(6, "Room 2", 2000, 1000, 30, "Day", "BBQ"), 0);
    }

    public Set<Booking> sendBooking() {
        return bookingSet;
    }

    @Override
    public void addBooking() {
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size();
        }
        System.out.println("Enter the Day Check in: ");
        String starDay = sc.nextLine();
        System.out.println("Enter the Day Check out: ");
        String endDay = sc.nextLine();
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();

//      Booking(Integer bookingID, String startDay, String endDay, Integer customerID, String serviceName, Integer serviceID)
        Booking booking = new Booking(id, starDay, endDay, customer,facility);
        bookingSet.add(booking);
    }

    @Override
    public void displayListBooking() {
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    public static Customer chooseCustomer() {
        System.out.println("List Customer: ");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        System.out.println("Enter the ID Customer: ");
        boolean check = true;
        int id = Integer.parseInt(sc.nextLine());
        while (check) {
            for (Customer customer : customerList) {
                if (id == customer.getCustomerID()) {
                    check = true;
                    return customer;
                }
            }
            if (check) {
                System.out.println("You Re- choice: ");
                id = Integer.parseInt(sc.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("List Service: ");
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey().toString());
        }
        boolean check = true;
        System.out.println("Enter the ID Service: ");
        int id = Integer.parseInt(sc.nextLine());
        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                if (id == entry.getKey().getId()) {
                    check = true;
                    return entry.getKey();
                }
            }
            if (check) {
                System.out.println("You Re- choice: ");
                id = Integer.parseInt(sc.nextLine());
            }
        }
        return null;
    }
}
