package com.link.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.link.model.customer.Customer;
import com.link.model.employee.Employee;
import com.link.model.service.Facility;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "date")
    private String dateCheckIn;
    @Column(columnDefinition = "date")
    private String dateCheckOut;
    private Double deposit;
    @Column(columnDefinition = "bit(1) default 0")
    private int status;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;

    @JsonBackReference
    @OneToMany(mappedBy = "contract")
    List<DetailsContract> detailsContractList;

    public Contract() {
    }

    public Contract(Integer id, String dateCheckIn, String dateCheckOut, Double deposit, int status, Employee employee,
                    Customer customer, Facility facility, List<DetailsContract> detailsContractList) {
        this.id = id;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.deposit = deposit;
        this.status = status;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.detailsContractList = detailsContractList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(String dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public String getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(String dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public List<DetailsContract> getDetailsContractList() {
        return detailsContractList;
    }

    public void setDetailsContractList(List<DetailsContract> detailsContractList) {
        this.detailsContractList = detailsContractList;
    }
}
