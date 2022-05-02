package casestudy.models.service;

import casestudy.models.person.Customer;
import casestudy.models.resort.Facility;

public class Booking {
    private Integer bookingID;
    private String startDay;
    private String endDay;
    private Integer customerID;
    private String facilityID;

    //    mã booking, ngày bắt đầu, ngày kết thúc, mã khách hàng, tên dịch vụ, loại dịch vụ.

    public Booking(Integer bookingID, String startDay, String endDay, Integer customerID, String facilityID) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerID = customerID;
        this.facilityID = facilityID;
    }

    public Booking() {
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

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getServiceID() {
        return facilityID;
    }

    public void setServiceType(String serviceType) {
        this.facilityID = facilityID;
    }
    public String convertLine() {
        String line = this.bookingID+","+this.customerID+","+this.endDay+","+this.customerID+","+this.facilityID;
        return line;
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
