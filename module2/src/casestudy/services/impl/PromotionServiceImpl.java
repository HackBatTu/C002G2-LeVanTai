package casestudy.services.impl;

import casestudy.controllers.FuramaController;
import casestudy.models.person.Customer;
import casestudy.models.service.Booking;
import casestudy.services.inter_face.IBookingService;
import casestudy.services.inter_face.IPromotionService;
import casestudy.utils.regex.Regex;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class PromotionServiceImpl implements IPromotionService {
    private final static String PATTERN = "yyyy";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
    private static Scanner sc = new Scanner(System.in);
    private static Integer totalVoucher10Percent = 0;
    private static Integer totalVoucher20Percent = 0;
    private static Integer totalVoucher50Percent = 0;
    private static IBookingService Booking = new BookingServiceImpl();
    private static Set<Booking> bookingSet = BookingServiceImpl.sendBooking();
    private static Integer totalOfVoucher = CustomerServiceImpl.getCustomers().size();
    private static List<Customer> customerList = CustomerServiceImpl.getCustomers();

    @Override
    public void displayListCustomersUseService() {
        Set<Booking> bookingList = BookingServiceImpl.sendBooking();
        boolean check = false;
        System.out.print("Enter year: ");
        String year = sc.nextLine();

        for (Booking booking : bookingList) {
            if (booking.getEndDay().equals(year)) {
                check = true;
                break;
            }
        }
        if (check) {
            for (Booking booking : bookingList) {
                if (booking.getEndDay().equals(year)) {
                    System.out.println(booking);
                }
            }
        } else {
            System.out.println("In " + year + " no one used the service");
        }
    }

    @Override
    public void voucher() {
        if (totalOfVoucher >= 1) {
            for (Booking booking : bookingSet) {
                if (totalVoucher50Percent > 0) {
                    System.out.println("Customer with id: " + booking.getCustomerID() + " will be give away " + 1 + " voucher 50%");
                    totalVoucher50Percent--;
                } else if (totalVoucher20Percent > 0) {
                    System.out.println("Customer with id: " + booking.getCustomerID() + " will be give away " + 1 + " voucher 20%");
                    totalVoucher20Percent--;
                } else if (totalVoucher10Percent > 0) {
                    System.out.println("Customer with id: " + booking.getCustomerID() + " will be give away " + 1 + " voucher 10%");
                    totalVoucher10Percent--;
                }
            }
        } else {
            System.err.println("Voucher is not enough!");
        }
    }

    @Override
    public void giveAwayVoucher() {
        System.out.print("Enter count of voucher (10%): ");
        int count10Percent = 0;
        count10Percent = Regex.getChoice(count10Percent);
        System.out.print("Enter count of voucher (20%): ");
        int count20Percent = 0;
        count20Percent = Regex.getChoice(count20Percent);
        System.out.print("Enter count of voucher (50%): ");
        int count50Percent = 0;
        count50Percent = Regex.getChoice(count50Percent);

        while ((count10Percent + count20Percent + count50Percent) > totalOfVoucher) {
            System.err.println("The total number of voucher cannot be greater than the total number of customers");
            System.out.println();
            System.out.print("Enter count of voucher (10%): ");
            count10Percent = Integer.parseInt(sc.nextLine());
            System.out.print("Enter count of voucher (20%): ");
            count20Percent = Integer.parseInt(sc.nextLine());
            System.out.print("Enter count of voucher (50%): ");
            count50Percent = Integer.parseInt(sc.nextLine());
        }
        totalVoucher10Percent = count10Percent;
        totalVoucher20Percent = count20Percent;
        totalVoucher50Percent = count50Percent;

        giveAwayVoucher();
    }
}
