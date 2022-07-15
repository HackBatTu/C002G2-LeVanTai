package com.link.dto;

import com.link.model.contract.Contract;
import com.link.model.employee.Division;
import com.link.model.employee.EducationDegree;
import com.link.model.employee.Position;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.List;

public class EmployeeDTO {
    private Integer id;

    @NotNull
    @Pattern(regexp = "^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$")
    private String name;

    @NotNull
    @DateTimeFormat
    private String dateOfBird;

    @NotNull
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}" )
    private String idCard;

    @PositiveOrZero
    private Double salary;


    @NotNull
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$")
    private String phone;
    @NotNull
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String address;
    @NotNull
    private Position position;
    @NotNull
    private EducationDegree educationDegree;
    @NotNull
    private Division division;

    private List<Contract> contractList;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String name, String dateOfBird, String idCard, Double salary, String phone,
                       String email, String address, Position position, EducationDegree educationDegree, Division division, List<Contract> contractList) {
        this.id = id;
        this.name = name;
        this.dateOfBird = dateOfBird;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
