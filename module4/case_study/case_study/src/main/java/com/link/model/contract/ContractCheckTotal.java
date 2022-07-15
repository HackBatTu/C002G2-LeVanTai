package com.link.model.contract;

import com.link.model.customer.Customer;
import com.link.model.employee.Employee;
import com.link.model.service.Facility;

import java.util.List;

public class ContractCheckTotal {
    private Integer id;
    private String dateCheckIn;
    private String dateCheckOut;
    private Double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;
    private List<DetailsContract> contractDetailList;
    private Double totalMoney;

    public ContractCheckTotal() {
    }

    public ContractCheckTotal(Integer id, String dateCheckIn, String dateCheckOut, Double deposit, Customer customer,
                              Employee employee, Facility facility, List<DetailsContract> contractDetailList, Double totalMoney) {
        this.id = id;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.deposit = deposit;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
        this.contractDetailList = contractDetailList;
        this.totalMoney = totalMoney;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public List<DetailsContract> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<DetailsContract> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
