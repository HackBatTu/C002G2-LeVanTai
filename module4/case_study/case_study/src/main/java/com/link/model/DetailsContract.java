package com.link.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class DetailsContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;

    @Value("false")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "facility_attach_id", referencedColumnName = "id")
    private FacilityAttach facilityAttach;

    public DetailsContract() {
    }

    public DetailsContract(Integer id, Integer quantity, Boolean status, Contract contract, FacilityAttach facilityAttach) {
        this.id = id;
        this.quantity = quantity;
        this.status = status;
        this.contract = contract;
        this.facilityAttach = facilityAttach;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public FacilityAttach getFacilityAttach() {
        return facilityAttach;
    }

    public void setFacilityAttach(FacilityAttach facilityAttach) {
        this.facilityAttach = facilityAttach;
    }
}
