package model;

public class Customer {
    private int id;
    private String name;
    private String idCard;
    private String phone;
    private CustomerType customerType;

    public Customer(int id, String name, String idCard, String phone, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.customerType = customerType;
    }

    public Customer() {
    }

    public Customer(String name, String idCard, String phone, CustomerType customerType) {
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
