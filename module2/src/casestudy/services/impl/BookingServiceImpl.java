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

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    static Scanner sc = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilities = new LinkedHashMap<>();


    static {
        customerList.add(new Customer(1, "Hoan", "day", "male", 12345567, "054643", "Hoan@1234", "Vip", "xó núi"));
        customerList.add(new Customer(2, "Luan", "day", "male", 4366566, "01232323", "Luan@1234", "Vip", "xó núi"));
        customerList.add(new Customer(3, "Phuong", "day", "male", 1213123, "04543", "Phuong@1234", "Vip", "xó núi"));

        facilities.put(new Villa("1", "Villa 1", 500, 500, 10, "Day", "Vip", 100, 2), 0);
        facilities.put(new Villa("2", "Villa 2", 2000, 1000, 30, "Day", "Vip", 400, 5), 0);

        facilities.put(new House("3", "House 1", 500, 1000, 30, "Day", "Vip",4), 0);
        facilities.put(new House("4", "House 2", 2000, 1000, 30, "Day", "Vip", 2), 0);

        facilities.put(new Room("5", "Room 1", 500, 1000, 30, "Day","Breakfast"), 0);
        facilities.put(new Room("6", "Room 2", 2000, 1000, 30, "Day", "BBQ"), 0);

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
        ReadAndWriteBuffer.writeFile(bookingSet,"src/casestudy/data/booking.csv");
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
                if (id == customer.getID()) {
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
        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
            System.out.println(entry.getKey().toString());
        }
        boolean check = true;
        System.out.println("Enter the ID Service: ");
        String id =sc.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
                if (entry.getKey().getId().equals(id)) {
                    check = true;
                    return entry.getKey();
                }
            }
            if (check) {
                System.out.println("You Re- choice: ");
                id = sc.nextLine();
            }
        }
        return null;
    }
}
