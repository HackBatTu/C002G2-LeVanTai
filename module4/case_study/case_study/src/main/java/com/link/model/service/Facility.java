package com.link.model.service;

import javax.persistence.*;

@Entity
public class Facility {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double area;
    private Double poolArea;
    private Double cost;
    private Integer maxPerson;
    private String standardRoom;
    private String descriptionOther;
    private Integer numberOfFloors;
    private String facilityFree;

    @Column(columnDefinition = "bit(1) default 0")
    private int status;

    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;

    public Facility() {
    }

    public Facility(Integer id, String name, Double area, Double poolArea, Double cost, Integer maxPerson, String standardRoom,
                    String descriptionOther, Integer numberOfFloors, String facilityFree, Integer status, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.poolArea = poolArea;
        this.cost = cost;
        this.maxPerson = maxPerson;
        this.standardRoom = standardRoom;
        this.descriptionOther = descriptionOther;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.status = status;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(Integer maxPerson) {
        this.maxPerson = maxPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
