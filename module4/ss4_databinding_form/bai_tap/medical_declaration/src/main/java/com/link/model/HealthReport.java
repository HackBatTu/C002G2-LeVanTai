package com.link.model;

public class HealthReport {
    private String name;
    private String birth;
    private String gender;
    private String country;
    private String idCard;
    private String vehicleName;
    private String vehicleId;
    private String vehicleInformation;
    private String dateStart;
    private String dateEnd;
    private String citiesLast14days;

    public HealthReport() {
    }

    public HealthReport(String name, String birth, String gender, String country, String idCard, String vehicleName, String vehicleId, String vehicleInformation, String dateStart, String dateEnd, String citiesLast14days) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.vehicleName = vehicleName;
        this.vehicleId = vehicleId;
        this.vehicleInformation = vehicleInformation;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.citiesLast14days = citiesLast14days;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleInformation() {
        return vehicleInformation;
    }

    public void setVehicleInformation(String vehicleInformation) {
        this.vehicleInformation = vehicleInformation;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getCitiesLast14days() {
        return citiesLast14days;
    }

    public void setCitiesLast14days(String citiesLast14days) {
        this.citiesLast14days = citiesLast14days;
    }
}