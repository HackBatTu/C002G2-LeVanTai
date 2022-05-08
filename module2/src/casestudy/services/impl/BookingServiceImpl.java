package casestudy.services.impl;

import casestudy.models.person.Customer;
import casestudy.models.resort.Facility;
import casestudy.models.resort.House;
import casestudy.models.resort.Room;
import casestudy.models.resort.Villa;
import casestudy.models.service.Booking;
import casestudy.services.inter_face.IBookingService;
import casestudy.utils.comparator.BookingComparator;
import casestudy.utils.file.ReadAndWriteBuffer;
import casestudy.utils.regex.Regex;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    static Scanner sc = new Scanner(System.in);

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();
    static Map<Facility, Integer> facilities = new LinkedHashMap<>();

    private static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private static final String PATH_BOOK ="src/casestudy/data/booking.csv";

    static {
//        customerList.add(new Customer(1, "Hoan", "01/01/2001", "male", 12345567, "054643", "Hoan@1234", "Vip", "xó núi"));
//        customerList.add(new Customer(2, "Luan", "02/02/2001", "male", 4366566, "01232323", "Luan@1234", "Vip", "xó núi"));
//        customerList.add(new Customer(3, "Phuong", "03/03/2001", "male", 1213123, "04543", "Phuong@1234", "Vip", "xó núi"));
//
        facilities.put(new Villa("SVVL-1996", "Villa 1", 500.0, 500, 10, "Day", "Vip", 100.0, 2), 1);
        facilities.put(new Villa("SVVL-1997", "Villa 2", 2000.0, 1000, 30, "Day", "Vip", 400.0, 5), 2);
        facilities.put(new House("SVHO-1996", "House 1", 500.0, 1000, 30, "Day", "Vip",4), 2);
        facilities.put(new House("SVHO-1997", "House 2", 2000.0, 1000, 30, "Day", "Vip", 2), 3);
        facilities.put(new Room("SVRO-1996", "Room 1", 500.0, 1000, 30, "Day","Breakfast"), 3);
        facilities.put(new Room("SVRO-1997", "Room 2", 2000.0, 1000, 30, "Day", "BBQ"), 4);
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
        customerList = ReadAndWriteBuffer.readCustomer();
        System.out.println("*List Customer: ");
        for (Customer customer : customerList) {
            System.out.println( " - ID : " + customer.getID() + " , "+ customer.getName()+".");
        }
        System.out.println("Enter the ID Customer: ");
        boolean check = true;
        int id = Integer.parseInt(sc.nextLine());
        while (check) {
            for (Customer customer : customerList) {
                if (id == customer.getID()) {
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
            System.out.println(" Số lần đã sử dụng  : " + entry.getValue());
        }
        boolean check = true;
        System.out.println("Enter the ID Service: ");
        String id =sc.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
                if (entry.getKey().getId().equals(id)) {
                    FacilityServiceImpl.add(entry.getKey());
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
