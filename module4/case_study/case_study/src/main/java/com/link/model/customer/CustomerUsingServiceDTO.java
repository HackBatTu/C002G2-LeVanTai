package com.link.model.customer;

import com.link.model.contract.FacilityAttach;
import com.link.model.service.Facility;


public class CustomerUsingServiceDTO {

    private Customer customerId;
    private Customer customerName;
    private Customer customerPhone;
    private Customer customerAddress;
    private Customer customerEmail;
    private Facility facilityID;
    private Facility facilityName;
    private FacilityAttach attachServiceName;

    public CustomerUsingServiceDTO() {
    }

    public CustomerUsingServiceDTO( Customer customerId, Customer customerName, Customer customerPhone,
                                   Customer customerAddress, Customer customerEmail, Facility facilityID, Facility facilityName, FacilityAttach attachServiceName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.facilityID = facilityID;
        this.facilityName = facilityName;
        this.attachServiceName = attachServiceName;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Customer customerName) {
        this.customerName = customerName;
    }

    public Customer getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Customer customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Customer getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Customer customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Customer getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(Customer customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Facility getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(Facility facilityID) {
        this.facilityID = facilityID;
    }

    public Facility getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(Facility facilityName) {
        this.facilityName = facilityName;
    }

    public FacilityAttach getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(FacilityAttach attachServiceName) {
        this.attachServiceName = attachServiceName;
    }
}
