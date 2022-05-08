package casestudy.utils.comparator;

import casestudy.models.service.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate starDate1 = LocalDate.parse(o1.getStartDay(), formatter);
        LocalDate starDate2 = LocalDate.parse(o1.getStartDay(), formatter);

        LocalDate endDate1 = LocalDate.parse(o1.getEndDay(), formatter);
        LocalDate endDate2 = LocalDate.parse(o1.getEndDay(), formatter);
        if(starDate1.compareTo(starDate2)>0){
            return 1;
        }else if(starDate1.compareTo(starDate2)<0){
            return -1;
        }else {
            if(endDate1.compareTo(endDate2)>0){
                return 1;
            }else if(endDate1.compareTo(endDate2)<0){
                return -1;
            }else {
                return 0;
            }
        }
    }
}
