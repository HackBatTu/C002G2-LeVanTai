package com.link.model.customer;

import com.link.model.contract.FacilityAttach;
import com.link.model.service.Facility;


public class CustomerUsingServiceDTO {
    private Integer id;
    private Customer customer;
    private Facility facility;
    private FacilityAttach facilityAttach;

    public CustomerUsingServiceDTO() {
    }

    public CustomerUsingServiceDTO(Integer id, Customer customer, Facility facility, FacilityAttach facilityAttach) {
        this.id = id;
        this.customer = customer;
        this.facility = facility;
        this.facilityAttach = facilityAttach;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public FacilityAttach getFacilityAttach() {
        return facilityAttach;
    }

    public void setFacilityAttach(FacilityAttach facilityAttach) {
        this.facilityAttach = facilityAttach;
    }
}
