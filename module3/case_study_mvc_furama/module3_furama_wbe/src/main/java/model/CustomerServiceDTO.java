package model;

public class CustomerServiceDTO {
    private int customerId;
    private String customerName;
    private int customerGender;
    private String customerPhone;
    private String customerEmail;
    private String attachServiceName;

    public CustomerServiceDTO(int customerId, String customerName,int customerGender, String customerPhone,String customerEmail, String attachServiceName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.attachServiceName = attachServiceName;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    @Override
    public String toString() {
        return "CustomerUsingServiceDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", attachServiceName='" + attachServiceName + '\'' +
                '}';
    }
}
