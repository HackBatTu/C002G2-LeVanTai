package casestudy.services;

import casestudy.models.Booking;
import casestudy.models.Contract;
import casestudy.models.Customer;

import java.util.*;

public class ContactServiceImpl implements IContactService{
    static List<Contract> contractList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    @Override
    public void createNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet= new BookingServiceImpl().sendBooking();
        for(Booking booking: bookingSet){
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomerID();
            System.out.println("đang tạo hợp đồng cho Booking có thông tin " + booking.toString());
            System.out.println("đang tạo hợp đồng cho Khách hàng có thông tin " + customer.toString());
            System.out.println("nhập id hợp đồng : ");
            String id = sc.nextLine();
            System.out.println("Money check in :");
            String money = sc.nextLine();
            System.out.println("Total bill :");
            String total = sc.nextLine();
            Contract contract = new Contract(id, booking, money, total, customer);
            contractList.add(contract);
            System.out.println("tạo hợp đồng thành công " + contract.toString());
        }
    }

    @Override
    public void displayListContract() {
        for(Contract contract: contractList){
            System.out.println(contract.toString());
        }
    }

    @Override
    public void editContract() {

    }
}
