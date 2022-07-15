package com.link.dto;

import com.link.model.contract.Contract;
import com.link.model.customer.CustomerType;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDTO {
    private Integer id;

    @NotBlank(message = "not null and not blank")
    @Pattern(regexp = "^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$",message = "viết hoa chữ cái đầu")
    private String name;

    @NotBlank
    private String dateOfBird;

    @NotBlank
    private String gender;

    @NotBlank(message = "not null and not blank")
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}",message = "id card valid(9 or 12 number)")
    private String idCard;

    @NotBlank(message = "not null and not blank")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$", message = "phone valid")
    private String phone;

    @NotBlank(message = "not null and not blank")
    @Email(message = "mail not valid")
    private String email;

    @NotBlank(message = "address not valid")
    private String address;

    private CustomerType customerType;
    private List<Contract> contractList;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String name, String dateOfBird, String gender, String idCard, String phone, String email,
                       String address, CustomerType customerType, List<Contract> contractList) {
        this.id = id;
        this.name = name;
        this.dateOfBird = dateOfBird;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contractList = contractList;
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

    public String getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(String dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
