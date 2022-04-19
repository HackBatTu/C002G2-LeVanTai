package casestudy.models;

public class Customer extends Person{
    private Integer customerID;
    private String customerType;
    private String address;
//    Mã khách hàng, Họ tên , Ngày sinh, Giới tính, Số CMND, Số Điện Thoại, Email, Loại khách, Địa chỉ
    public Customer(String name, String date, String gender, Integer idCard, String phone, String email, Integer customerID, String customerType, String address) {
        super(name, date, gender, idCard, phone, email);
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(Integer customerId, String customerType, String address) {
        this.customerID = customerId;
        this.customerType = customerType;
        this.address = address;
    }
    public Customer() {}

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [" + super.toString()+
                "customerId : " + customerID +
                ", customerType: " + customerType + '\'' +
                ", address: " + address + '\'' +
                ']';
    }
}
