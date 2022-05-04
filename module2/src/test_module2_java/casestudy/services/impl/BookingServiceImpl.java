package test_module2_java.casestudy.services.impl;

import test_module2_java.casestudy.models.person.Customer;
import test_module2_java.casestudy.models.resort.Facility;
import test_module2_java.casestudy.models.resort.House;
import test_module2_java.casestudy.models.resort.Room;
import test_module2_java.casestudy.models.resort.Villa;
import test_module2_java.casestudy.models.service.Booking;
import test_module2_java.casestudy.services.inter_face.IBookingService;
import test_module2_java.casestudy.utils.comparator.BookingComparator;
import test_module2_java.casestudy.utils.file.ReadAndWriteBuffer;
import test_module2_java.casestudy.utils.regex.Regex;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    static Scanner sc = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilities = new LinkedHashMap<>();

    private static final String REGEX_DATE = "^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{4}$";
    private static final String PATH_BOOK ="src/test_module2_java/casestudy/data/booking.csv";

    static {
        customerList.add(new Customer(1, "Hoan", "01/01/2001", "male", 12345567, "054643", "Hoan@1234", "Vip", "xó núi"));
        customerList.add(new Customer(2, "Luan", "02/02/2001", "male", 4366566, "01232323", "Luan@1234", "Vip", "xó núi"));
        customerList.add(new Customer(3, "Phuong", "03/03/2001", "male", 1213123, "04543", "Phuong@1234", "Vip", "xó núi"));

        facilities.put(new Villa("SVVL-1996", "Villa 1", 500.0, 500, 10, "Day", "Vip", 100.0, 2), 0);
        facilities.put(new Villa("SVVL-1997", "Villa 2", 2000.0, 1000, 30, "Day", "Vip", 400.0, 5), 0);
        facilities.put(new House("SVHO-1996", "House 1", 500.0, 1000, 30, "Day", "Vip",4), 0);
        facilities.put(new House("SVHO-1997", "House 2", 2000.0, 1000, 30, "Day", "Vip", 2), 0);
        facilities.put(new Room("SVRO-1996", "Room 1", 500.0, 1000, 30, "Day","Breakfast"), 0);
        facilities.put(new Room("SVRO-1997", "Room 2", 2000.0, 1000, 30, "Day", "BBQ"), 0);
    }

    public static Set<Booking> sendBooking() {
        return bookingSet;
    }

    @Override
    public void addBooking() {
        bookingSet = ReadAndWriteBuffer.readBooking();
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size();
        }
        System.out.println("Enter the Day Check in: ");
        String starDay = Regex.regex(sc.nextLine(),REGEX_DATE,"Error: dd/MM/yyyy");
        System.out.println("Enter the Day Check out: ");
        String endDay = Regex.regex(sc.nextLine(),REGEX_DATE,"Error: dd/MM/yyyy");
        Integer customer = chooseCustomer();
        String facility = chooseFacility();
        Booking booking = new Booking(id, starDay, endDay, customer,facility);
        bookingSet.add(booking);
        ReadAndWriteBuffer.writeBooking(PATH_BOOK,bookingSet);
    }
    @Override
    public void displayListBooking() {
        bookingSet = ReadAndWriteBuffer.readBooking();
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }
    public static Integer chooseCustomer() {
        System.out.println("*List Customer: ");
        for (Customer customer : customerList) {
            System.out.println( " - " + customer.getID() + ": "+ customer.getName()+".");
        }
        System.out.println("Enter the ID Customer: ");
        boolean check = true;
        int id = Integer.parseInt(sc.nextLine());
        while (check) {
            for (Customer customer : customerList) {
                if (id == customer.getID()) {
                    check = true;
                    return customer.getID();
                }
            }
            if (check) {
                System.out.println("You Re- choice: ");
                id = Integer.parseInt(sc.nextLine());
            }
        }
        return null;
    }



        public static String chooseFacility() {
        System.out.println("*List Service: ");
        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
            System.out.println("-ID Facility Service : " + entry.getKey().getId());
            System.out.println("-Số lần đã sử dụng  : " + entry.getValue());
        }
        boolean check = true;
        System.out.println("Enter the ID Service: ");
        String id =sc.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
                if (entry.getKey().getId().equals(id)) {
                    check = true;
                    return entry.getKey().getId()+"";
                }
            }
            if (check) {
                System.out.println("You Re- choice: ");
                id = sc.nextLine();
            }
        }return null;

    }
}
