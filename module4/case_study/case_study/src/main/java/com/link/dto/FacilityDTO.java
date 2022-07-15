package com.link.dto;

import com.link.model.service.FacilityType;
import com.link.model.service.RentType;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

public class FacilityDTO {
    private Integer id;
    @Pattern(regexp = "[A-Z][a-z0-9 ]{1,}")
    private String name;

    @PositiveOrZero
    private Double area;
    @PositiveOrZero
    private Double cost;
    @PositiveOrZero
    private Double poolArea;
    @PositiveOrZero
    private Integer maxPerson;

    private String standardRoom;
    private String descriptionOther;

    @Pattern(regexp = "[0-9]+")
    private Integer numberOfFloors;
    private String facilityFree;
    private FacilityType facilityType;
    private RentType rentType;

    public FacilityDTO() {
    }

    public FacilityDTO(Integer id, String name, Double area, Double cost, Double poolArea, Integer maxPerson,
                       String standardRoom, String descriptionOther, Integer numberOfFloors, String facilityFree, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.poolArea = poolArea;
        this.maxPerson = maxPerson;
        this.standardRoom = standardRoom;
        this.descriptionOther = descriptionOther;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(Integer maxPerson) {
        this.maxPerson = maxPerson;
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
