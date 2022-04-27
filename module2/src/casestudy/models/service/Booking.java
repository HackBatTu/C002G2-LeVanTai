package casestudy.models.service;

import casestudy.models.person.Customer;
import casestudy.models.resort.Facility;

public class Booking {
    private Integer bookingID;
    private String startDay;
    private String endDay;
    private Customer customerID;
    private Facility facilityID;

    //    mã booking, ngày bắt đầu, ngày kết thúc, mã khách hàng, tên dịch vụ, loại dịch vụ.

    public Booking(Integer bookingID, String startDay, String endDay, Customer customerID, Facility facilityID) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerID = customerID;
        this.facilityID = facilityID;
    }


    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Facility getServiceID() {
        return facilityID;
    }

    public void setServiceType(Facility serviceType) {
        this.facilityID = facilityID;
    }

    @Override
    public String toString() {
        return "Booking [" +
                "bookingID: "+ bookingID +
                ", startDay: " + startDay + '\'' +
                ", endDay: " + endDay + '\'' +
                ", customerID: " + customerID +
                ", serviceType: " + facilityID + '\'' +
                ']';
    }
}
