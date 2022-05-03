package casestudy_module2.model;

public class Customer extends Person{
    private String CustomerType;
    private String address;

    public Customer(String id, String name, String birthDay, String gender, String idCart, String email, String phone, String customerType, String address) {
        super(id, name, birthDay, gender, idCart, email, phone);
        CustomerType = customerType;
        this.address = address;
    }

    public Customer() {
    }

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String customerType) {
        CustomerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer : " + super.toString()+
                " CustomerType='" + CustomerType + '\'' +
                ", address='" + address + '\'' +
                '.';
    }
}
