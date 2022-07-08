package com.link.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class FacilityAttach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double cost;
    private String unit;
    private String status;

    @JsonBackReference
    @OneToMany(mappedBy = "facilityAttach")
    List<DetailsContract> detailsContractList;

    public FacilityAttach() {
    }

    public FacilityAttach(Integer id,String name, Double cost, String unit, String status, List<DetailsContract> detailsContractList) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.detailsContractList = detailsContractList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DetailsContract> getDetailsContractList() {
        return detailsContractList;
    }

    public void setDetailsContractList(List<DetailsContract> detailsContractList) {
        this.detailsContractList = detailsContractList;
    }
}
