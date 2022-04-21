package casestudy.models;

public class Booking {
    private Integer bookingID;
    private String startDay;
    private String endDay;
    private Customer customerID;
    private String serviceName;
    private Facility serviceID;

    public Booking(int id, String starDay, String endDay, Customer customer, Facility facility) {
    }
    //    mã booking, ngày bắt đầu, ngày kết thúc, mã khách hàng, tên dịch vụ, loại dịch vụ.
    public Booking(Integer bookingID, String startDay, String endDay, Customer customerID, String serviceName, Facility serviceID) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.serviceID = serviceID;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Facility getServiceID() {
        return serviceID;
    }

    public void setServiceType(Facility serviceType) {
        this.serviceID = serviceID;
    }

    @Override
    public String toString() {
        return "Booking [" +
                "bookingID: "+ bookingID +
                ", startDay: " + startDay + '\'' +
                ", endDay: " + endDay + '\'' +
                ", customerID: " + customerID +
                ", serviceName: " + serviceName + '\'' +
                ", serviceType: " + serviceID + '\'' +
                ']';
    }
}
