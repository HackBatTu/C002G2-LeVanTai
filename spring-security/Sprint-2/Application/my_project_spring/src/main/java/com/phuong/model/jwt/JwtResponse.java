package com.phuong.model.jwt;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private List<String> grantList;
    private String username;

    public JwtResponse(List<String> grantList, String username) {
        this.grantList = grantList;
        this.username = username;
    }


    public List<String> getGrantList() {
        return grantList;
    }


    public String getUsername() {
        return username;
    }
}
