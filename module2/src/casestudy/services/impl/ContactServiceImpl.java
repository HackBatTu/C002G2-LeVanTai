package casestudy.services.impl;

import casestudy.models.service.Booking;
import casestudy.models.service.Contract;
import casestudy.models.person.Customer;
import casestudy.services.inter_face.IContactService;
import casestudy.utils.file.ReadAndWriteBuffer;

import java.util.*;

public class ContactServiceImpl implements IContactService {
    private static List<Contract> contractList = new ArrayList<>();
    private static Queue<Booking> bookingQueue = new LinkedList<>();
    private static Set<Booking> bookingSet= new BookingServiceImpl().sendBooking();
    private static Scanner sc = new Scanner(System.in);
    @Override
    public void createNewContract() {

        for(Booking booking: bookingSet){
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomerID();
            System.out.println("Contract for booking : " + booking.toString());
            System.out.println("Contract for Customer : " + customer.toString());
            System.out.println("Enter the Contract Id  : ");
            String id = sc.nextLine();
            System.out.println("Money check in :");
            String money = sc.nextLine();
            System.out.println("Total bill :");
            String total = sc.nextLine();
            Contract contract = new Contract(id, booking, money, total, customer);
            contractList.add(contract);
            System.out.println("Contract : " + contract.toString());
        }
        ReadAndWriteBuffer.writeContract("src/casestudy/data/contract.csv",contractList);
    }

    @Override
    public void displayListContract() {
//        contractList = ReadAndWriteBuffer.readFile("src/casestudy/data/contract.csv");
        for(Contract contract: contractList){
            System.out.println(contract);
        }
    }

    @Override
    public void editContract() {
        for(Booking booking: bookingSet){
            bookingQueue.add(booking);
        }
        System.out.println("Enter the id Contract you want edit: ");
        String id = sc.nextLine();
        boolean check = true ;
        for (int i = 0; i < contractList.size(); i++) {
            if(contractList.get(i).getContractID().equals(id)){
                check = true;
                break;
            }
        }
        if(check){
            for (int i = 0; i < contractList.size(); i++) {
                if(contractList.get(i).getContractID().equals(id)){
                    Booking booking = bookingQueue.poll();
                    Customer customer = booking.getCustomerID();
                    System.out.println("edit Booking : " + booking.toString());
                    System.out.println("edit Customer : " + customer.toString());
                    System.out.print("new ID contract: ");
                    contractList.get(i).setContractID(sc.nextLine());
                    System.out.println("new money ");
                    contractList.get(i).setFirstMoney(sc.nextLine());
                    System.out.println("new total ");
                    contractList.get(i).setTotalMoney(sc.nextLine());
                    ReadAndWriteBuffer.writeContract("src/casestudy/data/contract.csv",contractList);
                }else {
                    System.out.println("dont find ID");
                }
            }
        }

    }
}
