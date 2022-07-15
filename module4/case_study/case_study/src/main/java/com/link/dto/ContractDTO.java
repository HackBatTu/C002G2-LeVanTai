package com.link.dto;

import com.link.model.contract.DetailsContract;
import com.link.model.customer.Customer;
import com.link.model.employee.Employee;
import com.link.model.service.Facility;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public class ContractDTO {
    private Integer id;
    @DateTimeFormat
    private String dateCheckIn;
    @DateTimeFormat
    private String dateCheckOut;
    @PositiveOrZero
    private Double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private List<DetailsContract> detailsContractList;

    public ContractDTO() {
    }

    public ContractDTO(Integer id, String dateCheckIn, String dateCheckOut, Double deposit, Employee employee,
                       Customer customer, Facility facility, List<DetailsContract> detailsContractList) {
        this.id = id;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.deposit = deposit;
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
