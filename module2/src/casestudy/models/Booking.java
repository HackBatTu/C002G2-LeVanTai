package casestudy.models;

public class Booking {
    private Integer bookingID;
    private String startDay;
    private String endDay;
    private Integer customerID;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }
    //    mã booking, ngày bắt đầu, ngày kết thúc, mã khách hàng, tên dịch vụ, loại dịch vụ.
    public Booking(Integer bookingID, String startDay, String endDay, Integer customerID, String serviceName, String serviceType) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking [" +
                "bookingID: "+ bookingID +
                ", startDay: " + startDay + '\'' +
                ", endDay: " + endDay + '\'' +
                ", customerID: " + customerID +
                ", serviceName: " + serviceName + '\'' +
                ", serviceType: " + serviceType + '\'' +
                ']';
    }
}
