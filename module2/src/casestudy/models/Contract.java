package casestudy.models;

public class Contract {
    private Integer contractID;
    private Integer bookingID;
    private Integer firstMoney;
    private Integer totalMoney;
    private Integer customerID;

//    Số hợp đồng, mã booking, Số tiền cọc trước, Tổng số tiền thanh toán, mã khách hàng.
    public Contract() {
    }
    public Contract(Integer contractID, Integer bookingID, Integer firstMoney, Integer totalMoney, Integer customerID) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.firstMoney = firstMoney;
        this.totalMoney = totalMoney;
        this.customerID = customerID;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Integer getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(Integer firstMoney) {
        this.firstMoney = firstMoney;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
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
