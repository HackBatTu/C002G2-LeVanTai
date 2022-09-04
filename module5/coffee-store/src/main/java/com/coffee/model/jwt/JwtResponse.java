package com.coffee.model.jwt;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private List<String> grantList;
    private String username;

    public JwtResponse(String jwttoken, List<String> grantList, String username) {
        this.jwttoken = jwttoken;
        this.grantList = grantList;
        this.username = username;
    }

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public List<String> getGrantList() {
        return grantList;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getUsername() {
        return username;
    }
}
