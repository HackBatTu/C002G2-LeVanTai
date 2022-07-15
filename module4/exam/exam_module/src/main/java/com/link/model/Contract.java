package com.link.model;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    private String id;
    private String personName;
    private String idCard;

    @Column(columnDefinition = "date")
    private String date;
    private int timeUnit;

    @Column(columnDefinition = "bit(1) default 0")
    private int status;

    @OneToOne
    @JoinColumn(name = "room_id" , referencedColumnName = "id")
    private Room room;

    public Contract() {
    }

    public Contract(String id, String personName, String idCard, String date, int timeUnit, int status, Room room) {
        this.id = id;
        this.personName = personName;
        this.idCard = idCard;
        this.date = date;
        this.timeUnit = timeUnit;
        this.status = status;
        this.room = room;
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
}
