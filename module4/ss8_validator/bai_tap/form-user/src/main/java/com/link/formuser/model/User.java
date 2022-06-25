package com.link.formuser.model;

import javax.validation.constraints.*;

public class User {
    @NotEmpty
    @Size(min = 5,max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5,max = 45)
    private String lastName;

    @Pattern(regexp = "^(09|\\(84\\)\\+9)[01]\\d{7}$" ,message = "phone valid")
    private int phone;

    @Min(18)
    private int age;

    @Email(message = "email valid")
    private String email;

    public User() {
    }

    public User( @NotEmpty @Size(min = 5,max = 45) String firstName,@NotEmpty
    @Size(min = 5,max = 45) String lastName,@Pattern(regexp = "^(09|\\(84\\)\\+9)[01]\\d{7}$" ,message = "phone valid") int phone,
                 @Min(18) int age,@Email(message = "email valid") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
