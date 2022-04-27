package casestudy.models.person;

public class Customer extends Person {
    private String typeCustomer;
    private String address;
// Loại khách, Địa chỉ


    public Customer(Integer iD, String name, String date, String gender, Integer idCard, String phone, String email, String typeCustomer, String address) {
        super(iD, name, date, gender, idCard, phone, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public Customer() {
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return " Customer [ "+super.toString()+
                "typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                ']';
    }
}
