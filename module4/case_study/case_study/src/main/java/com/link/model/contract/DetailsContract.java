package com.link.model.contract;

import javax.persistence.*;

@Entity
public class DetailsContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;

    @Column(columnDefinition = "bit(1) default 0")
    private int status;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "facility_attach_id", referencedColumnName = "id")
    private FacilityAttach facilityAttach;

    public DetailsContract() {
    }

    public DetailsContract(Integer id, Integer quantity, Integer status, Contract contract, FacilityAttach facilityAttach) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
