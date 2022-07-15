package com.link.model;



public class ContractCheckTotal {
    private String id;
    private String personName;
    private String idCard;
    private String date;
    private int timeUnit;
    private int status;
    private Room room;
    private Double totalMoney;

    public ContractCheckTotal() {
    }

    public ContractCheckTotal(String id, String personName, String idCard, String date, int timeUnit, int status, Room room, Double totalMoney) {
        this.id = id;
        this.personName = personName;
        this.idCard = idCard;
        this.date = date;
        this.timeUnit = timeUnit;
        this.status = status;
        this.room = room;
        this.totalMoney = totalMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(int timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
