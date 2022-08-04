package com.link.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "text")
    private String img;

    private String phone;
    private String address;
    private int gender;

    @Column(columnDefinition = "date")
    private String birthDay;

    private Double salary;

    @Column(columnDefinition = "bit(1) default 0")
    private int status;

    @ManyToOne
    @JoinColumn(name = "position_id" ,referencedColumnName = "id")
    private Position position;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Employee() {
    }

    public Employee(Integer id, String name, String img, String phone, String address, int gender,int status, String birthDay,
                    Double salary, Position position, User user) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.status =status;
        this.birthDay = birthDay;
        this.salary = salary;
        this.position = position;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
