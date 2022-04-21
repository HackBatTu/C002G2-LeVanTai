package casestudy.models;

public class Contract {
    private String contractID;
    private Booking bookingID;
    private String firstMoney;
    private String totalMoney;
    private Customer customerID;

//    Số hợp đồng, mã booking, Số tiền cọc trước, Tổng số tiền thanh toán, mã khách hàng.


    public Contract(String contractID, Booking bookingID, String firstMoney, String totalMoney, Customer customerID) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.firstMoney = firstMoney;
        this.totalMoney = totalMoney;
        this.customerID = customerID;
    }

    public Contract() {
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public Booking getBookingID() {
        return bookingID;
    }

    public void setBookingID(Booking bookingID) {
        this.bookingID = bookingID;
    }

    public String getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(String firstMoney) {
        this.firstMoney = firstMoney;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Contract [" +
                "contractID: " + contractID +
                ", bookingID: " + bookingID +
                ", firstMoney: " + firstMoney +
                ", totalMoney: " + totalMoney +
                ", customerID: " + customerID +
                ']';
    }
}
