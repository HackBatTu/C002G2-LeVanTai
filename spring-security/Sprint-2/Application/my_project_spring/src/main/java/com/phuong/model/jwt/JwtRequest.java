package com.phuong.model.jwt;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
    private String token;
    private String confirmPassword;

    //need default constructor for JSON Parsing
    public JwtRequest() {

    }

    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public JwtRequest(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public JwtRequest(String username, String password, String token, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
