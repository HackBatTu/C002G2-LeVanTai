package com.link.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Value("false")
    private Boolean status;

    @JsonBackReference
    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;
}
