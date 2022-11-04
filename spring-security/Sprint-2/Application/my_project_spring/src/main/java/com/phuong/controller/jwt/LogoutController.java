package com.phuong.controller.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LogoutController {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/log/out", method = RequestMethod.POST)
    public ResponseEntity<?> onLogout(HttpServletResponse response) {
        Cookie deleteServletCookie = new Cookie("Authorization", null);
        deleteServletCookie.setMaxAge(0);
        deleteServletCookie.setPath("/");
        deleteServletCookie.setHttpOnly(true);
        deleteServletCookie.setSecure(false);
        response.addCookie(deleteServletCookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
